package com.project.auth

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import javax.annotation.PostConstruct
import javax.inject.Singleton


@Singleton
class FirebaseAuthProvider {

    public lateinit var firebaseAuth:FirebaseAuth

    @PostConstruct
    fun initializeApp(){
        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl("https://goal-service.firebaseio.com")
                .build()

        val firebaseApp=FirebaseApp.initializeApp(options)
        firebaseAuth = FirebaseAuth.getInstance(firebaseApp)

    }

    public fun getFirebaseAuthInstance():FirebaseAuth{
        return firebaseAuth
    }
}