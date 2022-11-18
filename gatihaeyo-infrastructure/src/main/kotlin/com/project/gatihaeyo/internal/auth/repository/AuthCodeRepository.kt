package com.project.gatihaeyo.internal.auth.repository

import com.project.gatihaeyo.internal.auth.model.AuthCodeEntity
import org.springframework.data.repository.CrudRepository

interface AuthCodeRepository : CrudRepository<AuthCodeEntity, String> {
}