package com.project.gatihaeyo.local.token.persistence.repository

import com.project.gatihaeyo.local.token.persistence.model.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}