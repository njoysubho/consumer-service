package com.project.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import com.project.auth.FirebaseAuthProvider
import com.project.dto.UserDTO
import io.micronaut.configuration.hystrix.annotation.HystrixCommand
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class FirebaseService {

   @Inject
   private lateinit var firebaseAuthProvider: FirebaseAuthProvider

    @HystrixCommand
    open fun  createFirebaseUser(userDTO: UserDTO):UserRecord{
        val createRequest=UserRecord.CreateRequest()
        createRequest.setEmail(userDTO.email)
        createRequest.setPassword(userDTO.password)
        return firebaseAuthProvider.getFirebaseAuthInstance()
                .createUser(createRequest);
    }
}