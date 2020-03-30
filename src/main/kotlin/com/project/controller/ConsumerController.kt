package com.project.controller

import com.project.ConsumerService
import com.project.dto.UserSignUpRequest
import com.project.dto.UserSignUpResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller
class ConsumerController(@Inject var consumerService: ConsumerService) {

    @Post("/consumers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createUser(@Body user: UserSignUpRequest):HttpResponse<UserSignUpResponse>{
          var createdUser=consumerService.createUser(user)
          return HttpResponse.created(createdUser)
                  .status(201)
    }
}