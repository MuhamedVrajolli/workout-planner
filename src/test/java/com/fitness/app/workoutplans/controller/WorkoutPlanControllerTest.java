package com.fitness.app.workoutplans.controller;

import static com.fitness.app.utils.RestUtils.toJson;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fitness.app.workoutplans.models.WorkoutPlan;
import com.fitness.app.workoutplans.models.WorkoutPlanDetails;
import com.fitness.app.workoutplans.service.WorkoutPlanService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
		var response = new PageImpl<>(List.of(WorkoutPlan.builder().id(1).build()),
				PageRequest.of(0, 10), 1);
		when(workoutPlanService.getWorkoutPlans(any(), any())).thenReturn(response);

		this.mockMvc.perform(get("/workout-plans"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content.length()").value(1));
	}

	@Test
	void getWorkoutPlans_shouldApplyPaginationAndSorting() throws Exception {
		var response = new PageImpl<>(List.of(WorkoutPlan.builder().id(1).build()),
				PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "name")), 1);
		when(workoutPlanService.getWorkoutPlans(any(), any())).thenReturn(response);

		mockMvc.perform(get("/workout-plans")
						.param("page", "0")
						.param("size", "10")
						.param("sort", "name,desc"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content").isArray())
				.andExpect(jsonPath("$.content.length()").value(1))
				.andExpect(jsonPath("$.total_elements").value(1))
				.andExpect(jsonPath("$.pageable.sort.sorted").value(true))
				.andExpect(jsonPath("$.pageable.page_number").value(0))
				.andExpect(jsonPath("$.pageable.page_size").value(10));
	}

	@Test
	void getWorkoutPlans_invalidFilters() throws Exception {
		this.mockMvc.perform(get("/workout-plans")
						.param("name", " ")
						.param("category", "NON_EXISTING_CATEGORY")
						.param("tagIds", "[]"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
				.andExpect(jsonPath("$.message").exists());
	}

	@Test
	void getWorkoutPlans_validFilters() throws Exception {
		this.mockMvc.perform(get("/workout-plans")
						.param("name", "test")
						.param("category", "BEGINNER")
						.param("tagIds", "[1]"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
				.andExpect(jsonPath("$.message").exists());
	}

	@Test
	void getWorkoutPlansById() throws Exception {
		WorkoutPlanDetails response = WorkoutPlanDetails.builder().id(1).build();
		when(workoutPlanService.getWorkoutPlanById(any())).thenReturn(response);

		this.mockMvc.perform(get("/workout-plans/{id}", anyInt()))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void createWorkoutPlan() throws Exception {
		WorkoutPlan response = WorkoutPlan.builder().id(1).build();
		when(workoutPlanService.createWorkoutPlan(any())).thenReturn(response);

		this.mockMvc.perform(post("/workout-plans")
						.with(csrf())
						.content(toJson(WorkoutPlan.builder().name("Test").build()))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1));
	}

	@Test
	void updateWorkoutPlan() throws Exception {
		WorkoutPlan response = WorkoutPlan.builder().id(1).name("Test").build();
		when(workoutPlanService.updateWorkoutPlan(any(), any())).thenReturn(response);

		this.mockMvc.perform(put("/workout-plans/{id}", 1)
						.with(csrf())
						.content(toJson(WorkoutPlan.builder().id(2).name("Test").build()))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Test"));
	}

	@Test
	void deleteWorkoutPlan() throws Exception {
		this.mockMvc.perform(delete("/workout-plans/{id}", anyInt())
						.with(csrf()))
				.andExpect(status().isNoContent());
	}
}
