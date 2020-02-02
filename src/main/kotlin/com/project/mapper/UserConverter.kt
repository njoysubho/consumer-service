package com.project.mapper

import com.google.firebase.auth.UserRecord
import com.project.domain.User
import com.project.dto.UserDTO
import java.util.*

class UserConverter {
    companion object {
        fun toDTO(user: User):UserDTO {
            val userDTO=UserDTO()
            userDTO.email=user.email
            userDTO.id= user.id.toString()
            userDTO.externalId = user.externalId
            return userDTO
        }
    }

}