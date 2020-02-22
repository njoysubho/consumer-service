package service

import com.google.firebase.auth.UserRecord
import com.project.auth.FirebaseAuthProvider
import com.project.dto.UserDTO
import com.project.service.ConsumerService
import com.project.service.FirebaseService
import io.micronaut.test.annotation.MicronautTest
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@MicronautTest(environments = ["integration-test","db-test"])
@ExtendWith(MockKExtension::class)
class UserServiceIntegrationTest {

    @InjectMocks
    lateinit var consumerService:ConsumerService
    @Mock
    lateinit var firebaseAuthProvider: FirebaseAuthProvider

    @InjectMocks
    lateinit var firebaseService: FirebaseService

    @BeforeEach
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        var userRecord = Mockito.mock(UserRecord::class.java)
        Mockito.`when`(userRecord.email).thenReturn("test@test.com")
        Mockito.`when`(firebaseService.createFirebaseUser(Mockito.any(UserDTO::class.java))).thenReturn(userRecord)

    }

    @Test
    fun `dummy test`(){
        assertTrue(true)
    }
    /*@Test
    fun `whenUserRegisterWithValidCredential_createUser`(){
        var userDTO = UserDTO()
        userDTO.email="test@test.com"
        userDTO.password="mysafestpassword"
        val createdUser=consumerService.createUser(userDTO)
        Assert.assertTrue(createdUser.email.equals(userDTO.email))
        Assert.assertTrue(createdUser.password.isEmpty())
        Assert.assertNotNull(createdUser.createdOn)
        Assert.assertNull(createdUser.modifiedOn)
    }*/
}