package com.project

import com.project.domain.Consumer
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface ConsumerRepository:JpaRepository<Consumer,UUID> {
}