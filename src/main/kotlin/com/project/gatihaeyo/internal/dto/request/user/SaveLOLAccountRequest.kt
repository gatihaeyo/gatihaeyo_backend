package com.project.gatihaeyo.internal.dto.request.user

import javax.validation.constraints.NotBlank

class SaveLOLAccountRequest(

    @field:NotBlank
    val name: String
)