package com.project.gatihaeyo.internal.auth.repository

import com.project.gatihaeyo.internal.auth.model.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}