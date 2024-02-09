package com.fitness.app.exercises.controller;

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

import com.fitness.app.exercises.models.Exercise;
import com.fitness.app.exercises.service.ExerciseService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ExerciseController.class)
@WithMockUser
class ExerciseControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private ExerciseService exerciseService;

  @Test
  void getExercises() throws Exception {
    var response = new PageImpl<>(List.of(Exercise.builder().id(1).build()),
        PageRequest.of(0, 10), 1);
    when(exerciseService.getExercises(any())).thenReturn(response);

    this.mockMvc.perform(get("/exercises"))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content.length()").value(1));
  }

  @Test
  void getExercisesById() throws Exception {
    Exercise response = Exercise.builder().id(1).build();
    when(exerciseService.getExerciseById(any())).thenReturn(response);

    this.mockMvc.perform(get("/exercises/{id}", anyInt()))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void createExercise() throws Exception {
    Exercise response = Exercise.builder().id(1).build();
    when(exerciseService.createExercise(any())).thenReturn(response);

    this.mockMvc.perform(post("/exercises")
            .with(csrf())
            .content(toJson(Exercise.builder().name("Test").build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void updateExercise() throws Exception {
    Exercise response = Exercise.builder().id(1).name("Test").build();
    when(exerciseService.updateExercise(any(), any())).thenReturn(response);

    this.mockMvc.perform(put("/exercises/{id}", 1)
            .with(csrf())
            .content(toJson(Exercise.builder().id(2).name("Test").build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Test"));
  }

  @Test
  void deleteExercise() throws Exception {
    this.mockMvc.perform(delete("/exercises/{id}", anyInt())
            .with(csrf()))
        .andExpect(status().isNoContent());
  }
}
