package com.project.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class ConsumerController{
    @Get("/test")
    fun sayHello():HttpResponse<String>{
        return HttpResponse.ok("ok");
    }
}