package com.project.gatihaeyo.external.email

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.model.Destination
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class AwsSESFacade(
    private val amazonSimpleEmailService: AmazonSimpleEmailService,
    private val awsSESProperties: AwsSESProperties,
    private val objectMapper: ObjectMapper
): SendEmailPort {

    override fun sendAuthCode(code: String, email: String) {
        sendEmail(
            template = "AuthCodeTemplate",
            templateData = mapOf(Pair("code", code)),
            email
        )
    }

    private fun sendEmail(template: String, templateData: Map<String, String>, vararg emails: String) {
        val emailRequest = SendTemplatedEmailRequest().also {
            it.destination = Destination(emails.toList())
            it.template = template
            it.source = awsSESProperties.source
            it.templateData = objectMapper.writeValueAsString(templateData)
        }

        amazonSimpleEmailService.sendTemplatedEmail(emailRequest)
    }
}