package com.project.gatihaeyo.internal.team.implement

import com.project.gatihaeyo.internal.team.mapper.TeamMemberMapper
import com.project.gatihaeyo.internal.team.repository.TeamMemberJpaRepository
import com.project.gatihaeyo.internal.team.model.TeamMember
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
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

    override fun queryTeamMemberListByTeamId(teamId: UUID): List<TeamMember> {
        return teamMemberJpaRepository.queryTeamMemberEntitiesByTeamId(teamId)
            .map {
                teamMemberMapper.toDomain(it)!!
            }
    }

    override fun existsTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean {
        return teamMemberJpaRepository.existsTeamMemberEntityByUserIdAndTeamId(userId, teamId)
    }
}