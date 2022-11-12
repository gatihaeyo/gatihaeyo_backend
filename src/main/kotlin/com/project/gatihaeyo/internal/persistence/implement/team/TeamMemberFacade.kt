package com.project.gatihaeyo.internal.persistence.implement.team

import com.project.gatihaeyo.internal.application.port.team.CommandTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamMemberPort
import com.project.gatihaeyo.internal.domain.model.team.TeamMember
import com.project.gatihaeyo.internal.persistence.mapper.team.TeamMemberMapper
import com.project.gatihaeyo.internal.persistence.repository.team.TeamMemberJpaRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TeamMemberFacade(
    private val teamMemberMapper: TeamMemberMapper,
    private val teamMemberJpaRepository: TeamMemberJpaRepository
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

    override fun queryTeamMemberByUserId(userId: UUID) = teamMemberMapper.toDomain(
        teamMemberJpaRepository.queryTeamMemberEntityByUserId(userId)
    )

    override fun existsTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean {
        return teamMemberJpaRepository.existsTeamMemberEntityByUserIdAndTeamId(userId, teamId)
    }
}