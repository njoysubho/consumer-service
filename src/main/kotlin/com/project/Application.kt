package com.project

import io.micronaut.runtime.Micronaut

public object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.project")
                .mainClass(Application.javaClass)
                .start()
    }
}