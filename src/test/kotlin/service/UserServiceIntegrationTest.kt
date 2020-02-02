package service

import com.google.firebase.auth.UserRecord
import com.project.dto.UserDTO
import com.project.service.ConsumerService
import com.project.service.FirebaseService
import io.micronaut.test.annotation.MicronautTest
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import javax.inject.Inject

@MicronautTest(environments = ["integration-test","db-test"])
@ExtendWith(MockKExtension::class)
class UserServiceIntegrationTest {

    @Inject
    lateinit var consumerService:ConsumerService

    @MockK
    lateinit var firebaseService: FirebaseService

    @BeforeAll
    fun setUp(){
        var userRecord = mockk<UserRecord>()
        every { userRecord.uid } returns "testuid"
        every { firebaseService.createFirebaseUser(any()) }returns userRecord

    }
    @Test
    fun `whenUserRegisterWithValidCredential_createUser`(){
        var userDTO = UserDTO("test@test.com","testpassword")
       consumerService.createUser(userDTO)
    }
}