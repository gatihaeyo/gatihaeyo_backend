package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.application.service.team.ApplyTeamService
import com.project.gatihaeyo.internal.application.service.team.CreateTeamService
import com.project.gatihaeyo.internal.application.service.team.DelegateTeamService
import com.project.gatihaeyo.internal.application.service.team.ExpulsionTeamService
import com.project.gatihaeyo.internal.application.service.team.InviteTeamService
import com.project.gatihaeyo.internal.application.service.team.ListTopTeamService
import com.project.gatihaeyo.internal.application.service.team.ReceiveTeamApplicationService
import com.project.gatihaeyo.internal.application.service.team.ReceiveTeamInvitationService
import com.project.gatihaeyo.internal.application.service.team.ShowTeamInvitationService
import com.project.gatihaeyo.internal.application.service.team.ShowTeamListService
import com.project.gatihaeyo.internal.application.service.team.ShowTeamMemberService
import com.project.gatihaeyo.internal.application.service.team.TeamDissipateService
import com.project.gatihaeyo.internal.application.service.team.TeamWithdrawalService
import com.project.gatihaeyo.internal.dto.request.team.CreateTeamRequest
import com.project.gatihaeyo.internal.dto.request.team.DelegateTeamRequest
import com.project.gatihaeyo.internal.dto.request.team.ExpulsionTeamRequest
import com.project.gatihaeyo.internal.dto.request.team.InviteTeamRequest
import com.project.gatihaeyo.internal.dto.request.team.ReceiveTeamApplicationRequest
import com.project.gatihaeyo.internal.dto.request.team.ShowTeamListRequest
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamInvitationResponse
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamMemberResponse
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping("/teams")
class TeamController(
    private val createTeamService: CreateTeamService,
    private val showTeamMemberService: ShowTeamMemberService,
    private val showTeamInvitationService: ShowTeamInvitationService,
    private val applyTeamService: ApplyTeamService,
    private val inviteTeamService: InviteTeamService,
    private val listTopTeamService: ListTopTeamService,
    private val showTeamListService: ShowTeamListService,
    private val delegateTeamService: DelegateTeamService,
    private val receiveTeamApplicationService: ReceiveTeamApplicationService,
    private val receiveTeamInvitationService: ReceiveTeamInvitationService,
    private val expulsionTeamService: ExpulsionTeamService,
    private val teamDissipateService: TeamDissipateService,
    private val teamWithdrawalService: TeamWithdrawalService
) {

    @GetMapping
    fun showTeamList(@Valid request: ShowTeamListRequest): ShowTeamResponse {
        return showTeamListService.execute(request)
    }

    @GetMapping("/{team-id}")
    fun showTeamMemberList(@PathVariable("team-id") teamId: UUID): ShowTeamMemberResponse {
        return showTeamMemberService.execute(teamId)
    }

    @GetMapping("/invitation")
    fun showInvitationList(): ShowTeamInvitationResponse {
        return showTeamInvitationService.execute()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeam(@Valid @RequestBody request: CreateTeamRequest) {
        createTeamService.execute(request)
    }

    @PostMapping("/invitation")
    @ResponseStatus(HttpStatus.CREATED)
    fun inviteTeam(@Valid @RequestBody request: InviteTeamRequest) {
        inviteTeamService.execute(request)
    }

    @PostMapping("/list-top/{team-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun listTopTeam(@PathVariable("team-id") teamId: UUID) {
        listTopTeamService.execute(teamId)
    }

    @PostMapping("/participation/{team-id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun applyTeam(@PathVariable("team-id") teamId: UUID) {
        applyTeamService.execute(teamId)
    }

    @PutMapping("/delegation")
    fun delegateMaster(@Valid @RequestBody request: DelegateTeamRequest) {
        delegateTeamService.execute(request)
    }

    @PutMapping("/participation")
    fun receiveTeamApplication(@Valid @RequestBody request: ReceiveTeamApplicationRequest) {
        receiveTeamApplicationService.execute(request)
    }

    @PutMapping("/invitation/{team-id}")
    fun receiveTeamInvitation(@PathVariable("team-id") teamId: UUID) {
        receiveTeamInvitationService.execute(teamId)
    }

    @DeleteMapping("/expulsion")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun expulsionTeam(@Valid @RequestBody request:ExpulsionTeamRequest) {
        expulsionTeamService.execute(request)
    }

    @DeleteMapping("/dissolution/{team-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun dissolution(@PathVariable("team-id") teamId: UUID) {
        teamDissipateService.execute(teamId)
    }

    @DeleteMapping("/withdrawal/{team-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun withdrawalTeam(@PathVariable("team-id") teamId: UUID) {
        teamWithdrawalService.execute(teamId)
    }

}