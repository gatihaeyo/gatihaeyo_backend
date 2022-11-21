package com.project.gatihaeyo.team

import com.project.gatihaeyo.internal.team.dto.CreateTeamDto
import com.project.gatihaeyo.internal.team.dto.DelegateTeamDto
import com.project.gatihaeyo.internal.team.dto.ExpulsionTeamDto
import com.project.gatihaeyo.internal.team.dto.InviteTeamDto
import com.project.gatihaeyo.internal.team.dto.ReceiveTeamApplicantDto
import com.project.gatihaeyo.internal.team.dto.RemoveTeamApplicantDto
import com.project.gatihaeyo.internal.team.dto.ShowTeamListDto
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamApplicantResponse
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamInvitationResponse
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamListResponse
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamMemberResponse
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamResponse
import com.project.gatihaeyo.internal.team.service.ApplyTeamService
import com.project.gatihaeyo.internal.team.service.CreateTeamService
import com.project.gatihaeyo.internal.team.service.DelegateTeamService
import com.project.gatihaeyo.internal.team.service.ExpulsionTeamService
import com.project.gatihaeyo.internal.team.service.InviteTeamService
import com.project.gatihaeyo.internal.team.service.ListTopTeamService
import com.project.gatihaeyo.internal.team.service.ReceiveTeamApplicantService
import com.project.gatihaeyo.internal.team.service.ReceiveTeamInvitationService
import com.project.gatihaeyo.internal.team.service.RemoveTeamApplicantService
import com.project.gatihaeyo.internal.team.service.RemoveTeamInvitationService
import com.project.gatihaeyo.internal.team.service.ShowEmbeddedTeamService
import com.project.gatihaeyo.internal.team.service.ShowTeamApplicantService
import com.project.gatihaeyo.internal.team.service.ShowTeamInvitationService
import com.project.gatihaeyo.internal.team.service.ShowTeamListService
import com.project.gatihaeyo.internal.team.service.ShowTeamMemberService
import com.project.gatihaeyo.internal.team.service.ShowTeamService
import com.project.gatihaeyo.internal.team.service.TeamDissipateService
import com.project.gatihaeyo.internal.team.service.TeamWithdrawalService
import com.project.gatihaeyo.team.dto.request.CreateTeamRequest
import com.project.gatihaeyo.team.dto.request.DelegateTeamRequest
import com.project.gatihaeyo.team.dto.request.ExpulsionTeamRequest
import com.project.gatihaeyo.team.dto.request.InviteTeamRequest
import com.project.gatihaeyo.team.dto.request.ReceiveTeamApplicantRequest
import com.project.gatihaeyo.team.dto.request.RemoveTeamApplicantRequest
import com.project.gatihaeyo.team.dto.request.ShowTeamListRequest
import com.project.gatihaeyo.user.dto.response.ShowEmbeddedTeamResponse
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
    private val showTeamService: ShowTeamService,
    private val showTeamMemberService: ShowTeamMemberService,
    private val showTeamInvitationService: ShowTeamInvitationService,
    private val showTeamApplicantService: ShowTeamApplicantService,
    private val applyTeamService: ApplyTeamService,
    private val inviteTeamService: InviteTeamService,
    private val listTopTeamService: ListTopTeamService,
    private val showTeamListService: ShowTeamListService,
    private val delegateTeamService: DelegateTeamService,
    private val receiveTeamApplicantService: ReceiveTeamApplicantService,
    private val receiveTeamInvitationService: ReceiveTeamInvitationService,
    private val expulsionTeamService: ExpulsionTeamService,
    private val teamDissipateService: TeamDissipateService,
    private val teamWithdrawalService: TeamWithdrawalService,
    private val removeTeamApplicantService: RemoveTeamApplicantService,
    private val removeTeamInvitationService: RemoveTeamInvitationService,
    private val showEmbeddedTeamService: ShowEmbeddedTeamService
) {

    @GetMapping
    fun showTeamList(@Valid request: ShowTeamListRequest): ShowTeamListResponse {
        val (size, category, order, page) = request

        return showTeamListService.execute(
            ShowTeamListDto(
                size = size,
                page = page - 1,
                category = category,
                order = order
            )
        )
    }

    @GetMapping("/{team-id}")
    fun showTeamDetail(@PathVariable("team-id") teamId: UUID): ShowTeamResponse {
        return showTeamService.execute(teamId)
    }

    @GetMapping("/member/{team-id}")
    fun showTeamMemberList(@PathVariable("team-id") teamId: UUID): ShowTeamMemberResponse {
        return showTeamMemberService.execute(teamId)
    }

    @GetMapping("/invitation")
    fun showInvitationList(): ShowTeamInvitationResponse {
        return showTeamInvitationService.execute()
    }

    @GetMapping("/participation")
    fun showApplicant() : ShowTeamApplicantResponse {
        return showTeamApplicantService.execute()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeam(@Valid @RequestBody request: CreateTeamRequest) {
        val (title, content, category, personnel) = request

        createTeamService.execute(
            CreateTeamDto(
                title = title,
                content = content,
                category = category,
                personnel = personnel
            )
        )
    }

    @PostMapping("/invitation")
    @ResponseStatus(HttpStatus.CREATED)
    fun inviteTeam(@Valid @RequestBody request: InviteTeamRequest) {
        inviteTeamService.execute(
            InviteTeamDto(
                userId = request.userId,
                teamId = request.teamId
            )
        )
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
        delegateTeamService.execute(
            DelegateTeamDto(
                userId = request.userId,
                teamId = request.teamId
            )
        )
    }

    @PutMapping("/participation")
    fun receiveTeamApplication(@Valid @RequestBody request: ReceiveTeamApplicantRequest) {
        receiveTeamApplicantService.execute(
            ReceiveTeamApplicantDto(
                userId = request.userId,
                teamId = request.teamId
            )
        )
    }

    @PutMapping("/invitation/{team-id}")
    fun receiveTeamInvitation(@PathVariable("team-id") teamId: UUID) {
        receiveTeamInvitationService.execute(teamId)
    }

    @DeleteMapping("/expulsion")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun expulsionTeam(@Valid @RequestBody request: ExpulsionTeamRequest) {
        expulsionTeamService.execute(
            ExpulsionTeamDto(
                userId = request.userId,
                teamId = request.teamId
            )
        )
    }

    @DeleteMapping("/{team-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun dissolution(@PathVariable("team-id") teamId: UUID) {
        teamDissipateService.execute(teamId)
    }

    @DeleteMapping("/withdrawal/{team-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun withdrawalTeam(@PathVariable("team-id") teamId: UUID) {
        teamWithdrawalService.execute(teamId)
    }

    @DeleteMapping("/participation/removal")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeApplicant(@Valid request: RemoveTeamApplicantRequest) {
        removeTeamApplicantService.execute(
            RemoveTeamApplicantDto(
                userId = request.userId,
                teamId = request.teamId
            )
        )
    }

    @DeleteMapping("/invitation/removal/{team-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeInvitation(@PathVariable("team-id") teamId: UUID) {
        removeTeamInvitationService.execute(teamId)
    }

    @GetMapping("/current")
    fun showEmbeddedTeam() : ShowEmbeddedTeamResponse {
        return ShowEmbeddedTeamResponse(
            showEmbeddedTeamService.execute()
        )
    }

}