package com.project.gatihaeyo.internal.report.model

import com.project.gatihaeyo.internal.BaseTimeEntity
import com.project.gatihaeyo.internal.report.ReportType
import com.project.gatihaeyo.internal.user.model.UserEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tb_report")
class ReportEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    val type: ReportType,

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suspect_id", columnDefinition = "BINARY(16)", nullable = false)
    val suspect: UserEntity

) : BaseTimeEntity()