package com.project.config;

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import lombok.extern.slf4j.Slf4j
import org.testcontainers.containers.PostgreSQLContainer
import javax.annotation.PostConstruct
import javax.inject.Singleton;

@Singleton
class TestPostgress : AutoCloseable{

   var psql:KGenericContainer = KGenericContainer("postgres:10.10")
            .withDatabaseName("test-db")
            .withUsername("test")
            .withPassword("test")
            .withExposedPorts(5432)

   override fun close() {
      psql.close()
   }

}
