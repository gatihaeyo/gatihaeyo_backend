package com.project.gatihaeyo.internal.report.repository

import com.project.gatihaeyo.internal.report.model.ReportEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ReportJpaRepository : CrudRepository<ReportEntity, UUID> {
}