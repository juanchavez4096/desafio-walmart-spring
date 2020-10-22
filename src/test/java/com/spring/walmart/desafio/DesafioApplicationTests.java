package com.spring.walmart.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties="page.size=24")
class DesafioApplicationTests {

	@Test
	void contextLoads() {
	}

}
