package com.project.gatihaeyo.internal.report.implement

import com.project.gatihaeyo.internal.report.ReportType
import com.project.gatihaeyo.internal.report.mapper.ReportMapper
import com.project.gatihaeyo.internal.report.model.QReportEntity.reportEntity
import com.project.gatihaeyo.internal.report.model.Report
import com.project.gatihaeyo.internal.report.port.CommandReportPort
import com.project.gatihaeyo.internal.report.port.QueryReportPort
import com.project.gatihaeyo.internal.report.repository.ReportJpaRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ReportFacade(
    private val reportMapper: ReportMapper,
    private val reportJpaRepository: ReportJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : CommandReportPort, QueryReportPort {

    override fun saveReport(report: Report) = reportMapper.toDomain(
       reportJpaRepository.save(
           reportMapper.toEntity(report)
       )
    )!!

    override fun queryReportList(size: Long, last: Long?, type: ReportType?): List<Report> {
        return jpaQueryFactory.selectFrom(reportEntity)
            .apply {
                when {
                    last != null -> where(reportEntity.id.lt(last))
                    type != null -> where(reportEntity.type.eq(type))
                }
            }
            .orderBy(reportEntity.id.desc())
            .limit(size)
            .fetch()
            .map {
                reportMapper.toDomain(it)!!
            }
    }

    override fun existsReportByUserIdAndReportUserId(userId: UUID, reportUserId: UUID) = reportJpaRepository
        .existsReportEntityByUserIdAndSuspectId(
            userId = userId,
            suspectId = reportUserId
        )

}