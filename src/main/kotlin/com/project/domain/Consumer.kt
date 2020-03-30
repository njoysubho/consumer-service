package com.project.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "consumers", schema = "consumer")
class Consumer(
        @Column(name = "email")
        var email: String,
        @Column(name = "firebase_id")
        var firebaseId: String,
        @Column(name = "name")
        var name: String
) {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    val id: UUID? = null
    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: Timestamp?=null
    @Column(name = "modified_at")
    @UpdateTimestamp
    val modifiedAt: Timestamp?=null
}