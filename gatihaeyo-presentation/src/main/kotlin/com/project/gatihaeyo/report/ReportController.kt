package com.project.gatihaeyo.report

import com.project.gatihaeyo.internal.report.dto.ReportUserDto
import com.project.gatihaeyo.internal.report.dto.ShowReportDto
import com.project.gatihaeyo.internal.report.dto.response.ShowReportListResponse
import com.project.gatihaeyo.internal.report.service.ReportUserService
import com.project.gatihaeyo.internal.report.service.ShowReportService
import com.project.gatihaeyo.report.dto.request.ReportUserRequest
import com.project.gatihaeyo.report.dto.request.ShowReportRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/reports")
class ReportController(
    private val showReportService: ShowReportService,
    private val reportUserService: ReportUserService
) {

    @GetMapping
    fun reportList(request: ShowReportRequest) : ShowReportListResponse {
        val (last, size, type) = request

        return showReportService.execute(
            ShowReportDto(last, size, type)
        )
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun reportUser(@Valid @RequestBody request: ReportUserRequest) {
        val (userId, type, content) = request

        reportUserService.execute(
            ReportUserDto(userId, type, content)
        )
    }
}