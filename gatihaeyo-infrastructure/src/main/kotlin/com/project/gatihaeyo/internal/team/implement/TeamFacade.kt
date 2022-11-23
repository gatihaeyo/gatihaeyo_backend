package com.project.gatihaeyo.internal.team.implement

import com.project.gatihaeyo.internal.team.Category
import com.project.gatihaeyo.internal.team.Order
import com.project.gatihaeyo.internal.team.mapper.TeamMapper
import com.project.gatihaeyo.internal.team.model.QTeamEntity.teamEntity
import com.project.gatihaeyo.internal.team.model.Team
import com.project.gatihaeyo.internal.team.model.TeamEntity
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import com.project.gatihaeyo.internal.team.repository.TeamJpaRepository
import com.querydsl.jpa.impl.JPAQuery
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
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

    override fun searchTeamByKeyword(keyword: String, order: Order): List<Team> {
        return jpaQueryFactory
            .selectFrom(teamEntity)
            .where(teamEntity.currentPersonnel.ne(teamEntity.personnel))
            .orderTeam(order)
            .fetch()
            .map {
                teamMapper.toDomain(it)!!
            }
    }

    override fun queryTeamPage(size: Int, page: Long, order: Order, category: Category): List<Team> {
        return jpaQueryFactory
            .selectFrom(teamEntity)
            .where(
                teamEntity.currentPersonnel.ne(teamEntity.personnel)
                    .and(teamEntity.category.eq(category))
            )
            .orderTeam(order)
            .offset(page * size)
            .limit(size.toLong())
            .fetch()
            .map {
                teamMapper.toDomain(it)!!
            }
    }

    private fun JPAQuery<TeamEntity>.orderTeam(order: Order) : JPAQuery<TeamEntity> {
        return when (order) {
            Order.PERSONNEL -> orderBy(teamEntity.currentPersonnel.desc())
            Order.RECENT -> orderBy(teamEntity.updateAt.desc())
        }
    }

}