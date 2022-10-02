package com.project.gatihaeyo.internal.auth.persistence.repository

import com.project.gatihaeyo.internal.auth.persistence.model.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}