package com.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ApplicationTest {

    @Resource
    internal var testRestTemplate: TestRestTemplate? = null

    @Test
    fun testMessage() {
        var response = testRestTemplate!!.getForEntity("/message", String::class.java)
        assertThat(response.statusCodeValue).isEqualTo(200)
        assertThat(response.body).isEqualTo("Hello default")

    }

}
