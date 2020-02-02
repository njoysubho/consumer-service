package com.project.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import com.project.auth.FirebaseAuthProvider
import com.project.dto.UserDTO
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
class FirebaseService {

   @Inject
   private lateinit var firebaseAuthProvider: FirebaseAuthProvider

    fun  createFirebaseUser(userDTO: UserDTO):UserRecord{
        val createRequest=UserRecord.CreateRequest()
        createRequest.setEmail(userDTO.email)
        createRequest.setPassword(userDTO.password)
        return firebaseAuthProvider.getFirebaseAuthInstance()
                .createUser(createRequest);
    }
}