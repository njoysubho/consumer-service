package com.project.domain

import lombok.Getter
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users",schema = "consumer")
@Getter
@Setter
class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    var id:UUID?=null

    @Column(name = "external_id")
    var externalId:String="UNKNOWN"

    @Column(name="email")
    var email:String=""

    @Column(name = "created_on")
    @CreationTimestamp
    var createdOn:Timestamp?=null

    @Column(name="created_by")
    var createdBy:String?=null

    @Column(name="modified_on")
    @UpdateTimestamp
    var modifiedOn:Timestamp?=null
}