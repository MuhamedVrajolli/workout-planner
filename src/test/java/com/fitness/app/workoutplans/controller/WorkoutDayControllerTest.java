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

import com.fitness.app.workoutplans.models.WorkoutDay;
import com.fitness.app.workoutplans.service.WorkoutDayService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WorkoutDayController.class)
@WithMockUser
class WorkoutDayControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private WorkoutDayService workoutDayService;

  @Test
  void getWorkoutDays() throws Exception {
    var response = List.of(WorkoutDay.builder().id(1).build());
    when(workoutDayService.getWorkoutDays(any())).thenReturn(response);

    this.mockMvc.perform(get("/workout-days")
            .param("workoutPlanId", "1"))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1));
  }

  @Test
  void getWorkoutDays_noWorkoutPlanIdParam() throws Exception {
    var response = List.of(WorkoutDay.builder().id(1).build());
    when(workoutDayService.getWorkoutDays(any())).thenReturn(response);

    this.mockMvc.perform(get("/workout-days"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").exists());
  }

  @Test
  void getWorkoutDaysById() throws Exception {
    WorkoutDay response = WorkoutDay.builder().id(1).build();
    when(workoutDayService.getWorkoutDayById(any())).thenReturn(response);

    this.mockMvc.perform(get("/workout-days/{id}", anyInt()))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void createWorkoutDay() throws Exception {
    WorkoutDay response = WorkoutDay.builder().id(1).build();
    when(workoutDayService.createWorkoutDay(any())).thenReturn(response);

    this.mockMvc.perform(post("/workout-days")
            .with(csrf())
            .content(toJson(WorkoutDay.builder().dayName("Test").build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void updateWorkoutDay() throws Exception {
    WorkoutDay response = WorkoutDay.builder().id(1).dayName("Test").build();
    when(workoutDayService.updateWorkoutDay(any(), any())).thenReturn(response);

    this.mockMvc.perform(put("/workout-days/{id}", 1)
            .with(csrf())
            .content(toJson(WorkoutDay.builder().id(2).dayName("Test").build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.day_name").value("Test"));
  }

  @Test
  void deleteWorkoutDay() throws Exception {
    this.mockMvc.perform(delete("/workout-days/{id}", anyInt())
            .with(csrf()))
        .andExpect(status().isNoContent());
  }
}
