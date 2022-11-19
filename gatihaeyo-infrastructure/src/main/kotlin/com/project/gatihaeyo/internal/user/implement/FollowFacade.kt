package com.project.gatihaeyo.internal.user.implement

import com.project.gatihaeyo.internal.user.mapper.FollowMapper
import com.project.gatihaeyo.internal.user.mapper.UserMapper
import com.project.gatihaeyo.internal.user.model.Follow
import com.project.gatihaeyo.internal.user.model.FollowEntityId
import com.project.gatihaeyo.internal.user.model.QFollowEntity.followEntity
import com.project.gatihaeyo.internal.user.model.QUserEntity.userEntity
import com.project.gatihaeyo.internal.user.model.User
import com.project.gatihaeyo.internal.user.port.CommandFollowPort
import com.project.gatihaeyo.internal.user.port.QueryFollowPort
import com.project.gatihaeyo.internal.user.repository.FollowJpaRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FollowFacade(
    private val followJpaRepository: FollowJpaRepository,
    private val followMapper: FollowMapper,
    private val userMapper: UserMapper,
    private val jpaQueryFactory: JPAQueryFactory
) : CommandFollowPort, QueryFollowPort {

    override fun saveFollow(friend: Follow) = followMapper.toDomain(
       followJpaRepository.save(
           followMapper.toEntity(friend)
       )
    )!!

    override fun deleteFollowByUserIdAndFollowId(userId: UUID, followId: UUID) {
        followJpaRepository.deleteById(
            FollowEntityId(
                userId = userId,
                followId = followId
            )
        )
    }

    override fun queryFollowListByUserId(userId: UUID): List<User> {
        return jpaQueryFactory
            .select(userEntity)
            .from(followEntity)
            .join(userEntity)
            .on(followEntity.follow.eq(userEntity))
            .where(followEntity.user.id.eq(userId))
            .fetch().map {
                userMapper.toDomain(it)!!
            }
    }

    override fun existsFollowByUserIdAndFollowId(userId: UUID, friendId: UUID): Boolean {
        return followJpaRepository.existsById(
            FollowEntityId(
                userId = userId,
                followId = friendId
            )
        )
    }
}