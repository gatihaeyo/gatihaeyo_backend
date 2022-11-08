package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.application.service.team.CreateTeamService
import com.project.gatihaeyo.internal.dto.request.team.CreateTeamRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/teams")
class TeamController(
    private val createTeamService: CreateTeamService
) {

    @PostMapping
    fun createTeam(@Valid @RequestBody request: CreateTeamRequest) {
        createTeamService.execute(request)
    }


}