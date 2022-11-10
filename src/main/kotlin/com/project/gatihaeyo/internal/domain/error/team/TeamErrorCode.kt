package com.project.gatihaeyo.internal.domain.error.team

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class TeamErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    TEAM_PERMISSION(HttpStatus.FORBIDDEN, "파티장이 아닙니다."),

    TEAM_FULL_PERSONNEL(HttpStatus.CONFLICT, "팀 인원이 가득 찼습니다."),

    TEAM_LIST_TOP_DELAY(HttpStatus.CONFLICT, "목록 갱신 대기시간입니다."),

    ALREADY_INVITE_TEAM(HttpStatus.CONFLICT, "파티에 이미 초대하였습니다."),

    ALREADY_JOIN_TEAM(HttpStatus.CONFLICT, "파티에 이미 참가되어 있습니다."),

    ALREADY_APPLY_TEAM(HttpStatus.CONFLICT, "파티 신청을 이미 했습니다."),

    TEAM_MASTER_BREAKAWAY(HttpStatus.CONFLICT, "파티장은 파티를 나갈 수 없습니다."),

    TEAM_APPLICANT_NOT_FOUND(HttpStatus.NOT_FOUND, "파티 신청을 찾을 수 없습니다."),

    TEAM_INVITATION_NOT_FOUND(HttpStatus.NOT_FOUND, "파티 초대를 찾을 수 없습니다."),

    TEAM_MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "파티원을 찾을 수 없습니다."),

    TEAM_NOT_FOUND(HttpStatus.NOT_FOUND, "파티를 찾을 수 없습니다.");

    override fun getStatus() = status.value()

    override fun getMessage() = message

}