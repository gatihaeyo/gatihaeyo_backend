package com.project.gatihaeyo.internal.team.implement

import com.project.gatihaeyo.internal.team.mapper.TeamMemberMapper
import com.project.gatihaeyo.internal.team.model.QTeamMemberEntity.teamMemberEntity
import com.project.gatihaeyo.internal.team.model.TeamMember
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.team.repository.TeamMemberJpaRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TeamMemberFacade(
    private val teamMemberMapper: TeamMemberMapper,
    private val teamMemberJpaRepository: TeamMemberJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
): CommandTeamMemberPort, QueryTeamMemberPort {

    override fun saveTeamMember(teamMember: TeamMember) = teamMemberMapper.toDomain(
       teamMemberJpaRepository.save(
           teamMemberMapper.toEntity(teamMember)
       )
    )!!

    override fun deleteTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID) {
        teamMemberJpaRepository.deleteTeamMemberEntityByUserIdAndTeamId(userId, teamId)
    }

    override fun deleteTeamMemberByTeamId(teamId: UUID) {
        teamMemberJpaRepository.deleteTeamMemberEntitiesByTeamId(teamId)
    }

    override fun queryTeamMemberByUserId(userId: UUID) : List<TeamMember> {
        return jpaQueryFactory.selectFrom(teamMemberEntity)
            .where(teamMemberEntity.user.id.eq(userId))
            .orderBy(teamMemberEntity.createdAt.desc())
            .fetch()
            .map {
                teamMemberMapper.toDomain(it)!!
            }
    }

    override fun queryTeamMemberListByTeamId(teamId: UUID): List<TeamMember> {
        return jpaQueryFactory.selectFrom(teamMemberEntity)
            .where(teamMemberEntity.team.id.eq(teamId))
            .orderBy(teamMemberEntity.createdAt.asc())
            .fetch()
            .map {
                teamMemberMapper.toDomain(it)!!
            }
    }

    override fun existsTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean {
        return teamMemberJpaRepository.existsTeamMemberEntityByUserIdAndTeamId(userId, teamId)
    }
}