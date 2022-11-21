package com.project.gatihaeyo.internal.message.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.message.error.MessageErrorCode.MESSAGE_NOT_FOUND

object MessageNotFoundException : GlobalException(MESSAGE_NOT_FOUND)