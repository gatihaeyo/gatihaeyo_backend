package com.project.gatihaeyo.internal.persistence.implement.team

import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.domain.model.Order
import com.project.gatihaeyo.internal.domain.model.team.Team
import com.project.gatihaeyo.internal.persistence.mapper.team.TeamMapper
import com.project.gatihaeyo.internal.persistence.model.team.QTeamEntity.teamEntity
import com.project.gatihaeyo.internal.persistence.repository.team.TeamJpaRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.UUID

@Component
class TeamFacade(
    private val teamJpaRepository: TeamJpaRepository,
    private val teamMapper: TeamMapper,
    private val jpaQueryFactory: JPAQueryFactory
) : CommandTeamPort, QueryTeamPort {

    override fun saveTeam(team: Team) = teamMapper.toDomain(
        teamJpaRepository.save(
            teamMapper.toEntity(team)
        )
    )!!

    override fun deleteTeamById(teamId: UUID) {
        teamJpaRepository.deleteById(teamId)
    }

    override fun queryTeamById(id: UUID) = teamMapper.toDomain(
        teamJpaRepository.queryTeamEntityById(id)
    )

    override fun existsTeamById(id: UUID): Boolean {
        return teamJpaRepository.existsById(id)
    }

    override fun queryTeamList(size: Int, last: LocalDateTime, order: Order, category: Category): List<Team> {
        return jpaQueryFactory
            .selectFrom(teamEntity)
            .where(
                teamEntity.currentPersonnel.ne(teamEntity.personnel)
                    .and(teamEntity.category.eq(category))
                    .and(teamEntity.updateAt.before(last)))
            .orderBy(order.sort)
            .limit(size.toLong())
            .fetch()
            .map {
                teamMapper.toDomain(it)!!
            }
    }


}