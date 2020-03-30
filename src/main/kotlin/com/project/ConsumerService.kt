package com.project

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import com.project.domain.Consumer
import com.project.dto.UserSignUpRequest
import com.project.dto.UserSignUpResponse
import java.util.logging.Logger
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
class ConsumerService(var consumerRepository: ConsumerRepository) {
    private val log = Logger.getLogger(ConsumerService::class.java.name)
    @Transactional
    fun createUser(user: UserSignUpRequest): UserSignUpResponse {
        var createRequest = UserRecord.CreateRequest().setEmail(user.email)
                .setPassword(user.password)
        var userRecord = FirebaseAuth.getInstance().createUser(createRequest)
        userRecord.also {
            log.info("Successfully created firebase user with uid ${it.uid}")
            var consumer = Consumer(userRecord.email, userRecord.uid, userRecord.displayName)
            consumerRepository.save(consumer)
        }



        return UserSignUpResponse(userRecord.email)
    }
}