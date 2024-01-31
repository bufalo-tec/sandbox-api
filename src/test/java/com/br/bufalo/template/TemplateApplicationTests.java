package com.br.bufalo.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertDoesNotThrow(() -> System.out.println("Test"));
	}

}
