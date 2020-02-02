package com.project.dto

import java.time.OffsetDateTime
import java.util.*

class UserDTO{
    var email:String=""
    var password:String=""
    var externalId:String=""
    var id:String=""
    var createdOn:OffsetDateTime?=null
    var modifiedOn:OffsetDateTime?=null
    var modifiedBy:String?=null
}
