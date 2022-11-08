package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamMember

interface CommandTeamMemberPort {

    fun saveTeamMember(teamMember: TeamMember): TeamMember
}