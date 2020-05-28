package com.desafio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class DesafioGetnetApplicationTests {

	@Test
	void contextLoads() {
		DesafioGetnetApplication.main(new String[] {});
		assertNotNull(DesafioGetnetApplication.class);
	}

}
