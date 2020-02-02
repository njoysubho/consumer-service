package com.project.service

import com.project.domain.User
import com.project.dto.UserDTO
import com.project.mapper.UserConverter
import com.project.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
class ConsumerService(@Inject val userRepository: UserRepository
                      , @Inject val firebaseService: FirebaseService) {


    @Transactional
    fun createUser(userDTO: UserDTO): UserDTO {
        val userRecord = firebaseService.createFirebaseUser(userDTO)
        var user = User()
        user.externalId = userRecord.uid
        user.email = userRecord.email
        val savedUser = userRepository.save(user)
        return UserConverter.toDTO(savedUser)
    }
}