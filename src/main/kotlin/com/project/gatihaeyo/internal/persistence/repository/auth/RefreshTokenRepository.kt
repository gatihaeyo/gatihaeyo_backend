package com.project.gatihaeyo.internal.persistence.repository.auth

import com.project.gatihaeyo.internal.persistence.model.auth.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}