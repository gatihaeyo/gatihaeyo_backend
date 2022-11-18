package com.project.gatihaeyo.internal.user.implement

import com.project.gatihaeyo.internal.user.mapper.FollowMapper
import com.project.gatihaeyo.internal.user.mapper.UserMapper
import com.project.gatihaeyo.internal.user.model.FollowEntityId
import com.project.gatihaeyo.internal.user.model.Friend
import com.project.gatihaeyo.internal.user.model.QFollowEntity.followEntity
import com.project.gatihaeyo.internal.user.model.QUserEntity.userEntity
import com.project.gatihaeyo.internal.user.model.User
import com.project.gatihaeyo.internal.user.port.CommandFriendPort
import com.project.gatihaeyo.internal.user.port.QueryFriendPort
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
) : CommandFriendPort, QueryFriendPort {

    override fun saveFriend(friend: Friend) = followMapper.toDomain(
       followJpaRepository.save(
           followMapper.toEntity(friend)
       )
    )!!

    override fun deleteFriendByUserIdAndFriendId(userId: UUID, friendId: UUID) {
        followJpaRepository.deleteById(
            FollowEntityId(
                userId = userId,
                friendId = friendId
            )
        )
    }

    override fun queryFriendListByUserId(userId: UUID): List<User> {
        return jpaQueryFactory
            .select(userEntity)
            .from(followEntity)
            .join(userEntity)
            .on(followEntity.friend.eq(userEntity))
            .where(followEntity.user.id.eq(userId))
            .fetch().map {
                userMapper.toDomain(it)!!
            }
    }

    override fun existsFriendByUserIdAndFriendId(userId: UUID, friendId: UUID): Boolean {
        return followJpaRepository.existsById(
            FollowEntityId(
                userId = userId,
                friendId = friendId
            )
        )
    }
}