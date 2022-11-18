package com.project.gatihaeyo.user.dto.request

import javax.validation.constraints.NotBlank

class SaveLOLAccountRequest(

    @field:NotBlank
    val name: String
)