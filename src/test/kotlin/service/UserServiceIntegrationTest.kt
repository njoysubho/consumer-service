package service

import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest(environments = ["integration-test"])
class UserServiceIntegrationTest {

    @Test
    fun test() {
        assert(true)
    }
}