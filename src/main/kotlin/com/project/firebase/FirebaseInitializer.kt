package com.project.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.discovery.event.ServiceStartedEvent
import java.util.logging.Logger
import javax.inject.Singleton


@Singleton
class FirebaseInitializer:ApplicationEventListener<ServiceStartedEvent> {
    private val log = Logger.getLogger(FirebaseInitializer::class.java.name)
    fun initialize() {
        log.info("Initializing firebase")
        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl("https://goal-service.firebaseio.com")
                .build()

        FirebaseApp.initializeApp(options)
        log.info("Successfully initialized firebase with ${options.projectId} ${options.databaseUrl}")
    }

    override fun onApplicationEvent(event: ServiceStartedEvent?) {
        initialize()
    }
}