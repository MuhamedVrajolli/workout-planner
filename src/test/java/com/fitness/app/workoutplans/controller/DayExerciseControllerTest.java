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

import com.fitness.app.workoutplans.models.DayExercise;
import com.fitness.app.workoutplans.service.DayExerciseService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DayExerciseController.class)
@WithMockUser
class DayExerciseControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private DayExerciseService dayExerciseService;

  @Test
  void getDayExercises() throws Exception {
    var response = List.of(DayExercise.builder().id(1).build());
    when(dayExerciseService.getDayExercises(any())).thenReturn(response);

    this.mockMvc.perform(get("/day-exercises")
            .param("workoutDayId", "1"))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1));
  }

  @Test
  void getDayExercises_noWorkoutDayIdParam() throws Exception {
    var response = List.of(DayExercise.builder().id(1).build());
    when(dayExerciseService.getDayExercises(any())).thenReturn(response);

    this.mockMvc.perform(get("/day-exercises"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").exists());
  }

  @Test
  void getDayExercisesById() throws Exception {
    DayExercise response = DayExercise.builder().id(1).build();
    when(dayExerciseService.getDayExerciseById(any())).thenReturn(response);

    this.mockMvc.perform(get("/day-exercises/{id}", anyInt()))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void createDayExercise() throws Exception {
    DayExercise response = DayExercise.builder().id(1).build();
    when(dayExerciseService.createDayExercise(any())).thenReturn(response);

    this.mockMvc.perform(post("/day-exercises")
            .with(csrf())
            .content(toJson(DayExercise.builder().sets(3).build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void updateDayExercise() throws Exception {
    DayExercise response = DayExercise.builder().id(1).sets(3).build();
    when(dayExerciseService.updateDayExercise(any(), any())).thenReturn(response);

    this.mockMvc.perform(put("/day-exercises/{id}", 1)
            .with(csrf())
            .content(toJson(DayExercise.builder().id(2).sets(3).build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.sets").value(3));
  }

  @Test
  void deleteDayExercise() throws Exception {
    this.mockMvc.perform(delete("/day-exercises/{id}", anyInt())
            .with(csrf()))
        .andExpect(status().isNoContent());
  }
}
