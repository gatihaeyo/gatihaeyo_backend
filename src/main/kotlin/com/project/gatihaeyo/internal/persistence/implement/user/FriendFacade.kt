package com.project.gatihaeyo.internal.persistence.implement.user

import com.project.gatihaeyo.internal.application.port.user.CommandFriendPort
import com.project.gatihaeyo.internal.application.port.user.QueryFriendPort
import com.project.gatihaeyo.internal.domain.model.user.Friend
import com.project.gatihaeyo.internal.domain.model.user.User
import com.project.gatihaeyo.internal.persistence.mapper.user.FriendMapper
import com.project.gatihaeyo.internal.persistence.mapper.user.UserMapper
import com.project.gatihaeyo.internal.persistence.model.user.FriendEntityId
import com.project.gatihaeyo.internal.persistence.model.user.QFriendEntity.friendEntity
import com.project.gatihaeyo.internal.persistence.model.user.QUserEntity.userEntity
import com.project.gatihaeyo.internal.persistence.repository.user.FriendJpaRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FriendFacade(
    private val friendJpaRepository: FriendJpaRepository,
    private val friendMapper: FriendMapper,
    private val userMapper: UserMapper,
    private val jpaQueryFactory: JPAQueryFactory
) : CommandFriendPort, QueryFriendPort {

    override fun saveFriend(friend: Friend) = friendMapper.toDomain(
       friendJpaRepository.save(
           friendMapper.toEntity(friend)
       )
    )!!

    override fun deleteFriendByUserIdAndFriendId(userId: UUID, friendId: UUID) {
        friendJpaRepository.deleteById(
            FriendEntityId(
                userId = userId,
                friendId = friendId
            )
        )
    }

    override fun queryFriendListByUserId(userId: UUID): List<User> {
        return jpaQueryFactory
            .select(userEntity)
            .from(friendEntity)
            .join(userEntity)
            .on(friendEntity.friend.eq(userEntity))
            .where(friendEntity.user.id.eq(userId))
            .fetch().map {
                userMapper.toDomain(it)!!
            }
    }

    override fun existsFriendByUserIdAndFriendId(userId: UUID, friendId: UUID): Boolean {
        return friendJpaRepository.existsById(
            FriendEntityId(
                userId = userId,
                friendId = friendId
            )
        )
    }
}