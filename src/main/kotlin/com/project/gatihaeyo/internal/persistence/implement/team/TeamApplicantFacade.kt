package com.project.gatihaeyo.internal.persistence.implement.team

import com.project.gatihaeyo.internal.application.port.team.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.domain.model.team.TeamApplicant
import com.project.gatihaeyo.internal.persistence.mapper.team.TeamApplicantMapper
import com.project.gatihaeyo.internal.persistence.model.team.TeamUserEntityId
import com.project.gatihaeyo.internal.persistence.repository.team.TeamApplicantJpaRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TeamApplicantFacade(
    private val teamApplicantMapper: TeamApplicantMapper,
    private val teamApplicantJpaRepository: TeamApplicantJpaRepository
) : CommandTeamApplicantPort, QueryTeamApplicantPort{

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