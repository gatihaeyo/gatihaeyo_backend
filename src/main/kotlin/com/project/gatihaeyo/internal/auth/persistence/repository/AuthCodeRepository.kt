package com.project.gatihaeyo.internal.auth.persistence.repository

import com.project.gatihaeyo.internal.auth.persistence.model.AuthCodeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthCodeRepository : CrudRepository<AuthCodeEntity, String> {
}