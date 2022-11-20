package com.project.gatihaeyo.internal.report.port

import com.project.gatihaeyo.internal.report.model.Report

interface CommandReportPort {

    fun saveReport(report: Report): Report
}