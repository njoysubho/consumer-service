package com.project.repository

import com.project.domain.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface UserRepository:JpaRepository<User, UUID>{
}