package com.fitness.app;

import com.fitness.app.configuration.TestPostgresConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ExtendWith(TestPostgresConfiguration.class)
@DirtiesContext
@ActiveProfiles("test")
class FitnessAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
