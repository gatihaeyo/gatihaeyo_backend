package com.project.gatihaeyo.internal.persistence.repository.auth

import com.project.gatihaeyo.internal.persistence.model.auth.AuthCodeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthCodeRepository : CrudRepository<AuthCodeEntity, String> {
}