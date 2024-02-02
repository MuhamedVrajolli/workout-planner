package com.fitness.app.modules.workoutplans.controller;

import static com.fitness.app.utils.RestUtils.toJson;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fitness.app.exceptions.NotFoundException;
import com.fitness.app.modules.workoutplans.models.WorkoutPlanDetails;
import com.fitness.app.modules.workoutplans.service.WorkoutPlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WorkoutPlanController.class)
@WithMockUser
class WorkoutPlanControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private WorkoutPlanService workoutPlanService;

	@Test
	void getWorkoutPlans() throws Exception {
		this.mockMvc.perform(get("/workout-plans"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE));
	}

	@Test
	void getWorkoutPlansById() throws Exception {
		this.mockMvc.perform(get("/workout-plans/{id}", 1))
				.andExpect(status().isOk());
	}

	@Test
	void getWorkoutPlansById_notFound() throws Exception {
		when(workoutPlanService.getWorkoutPlanById(any())).thenThrow(new NotFoundException());

		this.mockMvc.perform(get("/workout-plans/{id}", 1))
				.andExpect(status().isNotFound());
	}

	@Test
	void createWorkoutPlan() throws Exception {
		WorkoutPlanDetails response = WorkoutPlanDetails.builder().id(1).build();
		when(workoutPlanService.createWorkoutPlan(any())).thenReturn(response);

		this.mockMvc.perform(post("/workout-plans")
						.with(csrf())
						.content(toJson(WorkoutPlanDetails.builder().name("Test").build()))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1));
	}

	@Test
	void updateWorkoutPlan() throws Exception {
		WorkoutPlanDetails response = WorkoutPlanDetails.builder().id(1).name("Test").build();
		when(workoutPlanService.updateWorkoutPlan(any(), any())).thenReturn(response);

		this.mockMvc.perform(put("/workout-plans/{id}", 1)
						.with(csrf())
						.content(toJson(WorkoutPlanDetails.builder().name("Test").build()))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Test"));
	}

	@Test
	void deleteWorkoutPlan() throws Exception {
		this.mockMvc.perform(delete("/workout-plans/{id}", 1)
						.with(csrf()))
				.andExpect(status().isNoContent());
	}
}
