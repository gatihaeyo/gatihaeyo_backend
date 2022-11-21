package com.project.gatihaeyo.message

import com.project.gatihaeyo.internal.message.dto.ShowMessageListDto
import com.project.gatihaeyo.internal.message.service.ShowMessageListService
import com.project.gatihaeyo.message.dto.request.ShowMessageListRequest
import com.project.gatihaeyo.message.dto.response.ShowMessageListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/chat")
class MessageController(
    private val showMessageListService: ShowMessageListService
) {

    @GetMapping
    fun showMessageList(@Valid request: ShowMessageListRequest) : ShowMessageListResponse {
        return ShowMessageListResponse(
            showMessageListService.execute(
                ShowMessageListDto(
                    roomId = request.teamId,
                    size = request.size,
                    page = request.page
                )
            )
        )
    }
}