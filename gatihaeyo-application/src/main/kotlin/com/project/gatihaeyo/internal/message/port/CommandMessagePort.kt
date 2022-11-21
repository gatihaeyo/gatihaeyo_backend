package com.project.gatihaeyo.internal.message.port

import com.project.gatihaeyo.internal.message.model.Message

interface CommandMessagePort {

    fun saveMessage(message: Message): Message
}