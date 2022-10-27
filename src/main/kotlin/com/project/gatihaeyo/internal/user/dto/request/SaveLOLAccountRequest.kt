package com.project.gatihaeyo.internal.user.dto.request

import javax.validation.constraints.NotBlank

class SaveLOLAccountRequest(

    @field:NotBlank
    val name: String
)