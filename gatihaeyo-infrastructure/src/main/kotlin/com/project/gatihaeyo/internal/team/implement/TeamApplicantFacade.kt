package com.project.gatihaeyo.internal.team.implement

import com.project.gatihaeyo.internal.team.mapper.TeamApplicantMapper
import com.project.gatihaeyo.internal.team.model.TeamUserEntityId
import com.project.gatihaeyo.internal.team.repository.TeamApplicantJpaRepository
import com.project.gatihaeyo.internal.team.model.TeamApplicant
import com.project.gatihaeyo.internal.team.port.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.QueryTeamApplicantPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TeamApplicantFacade(
    private val teamApplicantMapper: TeamApplicantMapper,
    private val teamApplicantJpaRepository: TeamApplicantJpaRepository
) : CommandTeamApplicantPort, QueryTeamApplicantPort {

    override fun saveTeamApplicant(teamApplicant: TeamApplicant) = teamApplicantMapper.toDomain(
       teamApplicantJpaRepository.save(
           teamApplicantMapper.toEntity(teamApplicant)
       )
    )!!

    override fun deleteTeamApplicantByTeamId(teamId: UUID) {
        teamApplicantJpaRepository.deleteTeamApplicantEntitiesByTeamId(teamId)
    }

    override fun deleteTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID) {
        teamApplicantJpaRepository.deleteById(
            TeamUserEntityId(
                userId = userId,
                teamId = teamId
            )
        )
    }

    override fun queryTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID) = teamApplicantMapper
        .toDomain(
            teamApplicantJpaRepository.queryTeamApplicantEntityByKey(
                TeamUserEntityId(
                    userId = userId,
                    teamId = teamId
                )
            )
        )

    override fun queryTeamApplicantListByUserId(userId: UUID): List<TeamApplicant> {
        return teamApplicantJpaRepository.queryTeamApplicantEntitiesByUserId(userId)
            .map {
                teamApplicantMapper.toDomain(it)!!
            }
    }

    override fun existsTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean {
        return teamApplicantJpaRepository.existsById(
            TeamUserEntityId(
                userId = userId,
                teamId = teamId
            )
        )
    }

}