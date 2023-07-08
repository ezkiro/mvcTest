package com.toyfactory.mvcTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {

    @Test
    void testNestedObject(@Autowired WebTestClient webClient) {
        log.debug("testNestedObject");

        webClient.get().uri("/nestedObject")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("test1")
                .jsonPath("$.someResultList[0].resultCode").isEqualTo("100")
                .jsonPath("$.someResultList[0].resultMessage").isEqualTo("success")
                .jsonPath("$.someResultList[1].resultCode").isEqualTo("200")
                .jsonPath("$.someResultList[1].resultMessage").isEqualTo("fail");

    }
}
