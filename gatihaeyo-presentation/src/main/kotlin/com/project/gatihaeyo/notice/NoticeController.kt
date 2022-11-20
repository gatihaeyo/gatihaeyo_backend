package com.project.gatihaeyo.notice

import com.project.gatihaeyo.internal.notice.dto.response.ShowNoticeListResponse
import com.project.gatihaeyo.internal.notice.service.RemoveNoticeService
import com.project.gatihaeyo.internal.notice.service.ShowNoticeListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/notices")
class NoticeController(
    private val showNoticeListService: ShowNoticeListService,
    private val removeNoticeService: RemoveNoticeService
) {

    @GetMapping
    fun noticeList() : ShowNoticeListResponse {
        return showNoticeListService.execute()
    }

    @DeleteMapping("/{notice-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNotice(@PathVariable("notice-id") noticeId: UUID) {
        removeNoticeService.execute(noticeId)
    }

}