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

import com.fitness.app.exercises.models.Muscle;
import com.fitness.app.exercises.service.MuscleService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MuscleController.class)
@WithMockUser
class MuscleControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private MuscleService muscleService;

  @Test
  void getMuscles() throws Exception {
    var response = List.of(Muscle.builder().id(1).build());
    when(muscleService.getMuscles()).thenReturn(response);

    this.mockMvc.perform(get("/muscles"))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1));
  }

  @Test
  void getMusclesById() throws Exception {
    Muscle response = Muscle.builder().id(1).build();
    when(muscleService.getMuscleById(any())).thenReturn(response);

    this.mockMvc.perform(get("/muscles/{id}", anyInt()))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void createMuscle() throws Exception {
    Muscle response = Muscle.builder().id(1).build();
    when(muscleService.createMuscle(any())).thenReturn(response);

    this.mockMvc.perform(post("/muscles")
            .with(csrf())
            .content(toJson(Muscle.builder().name("Test").build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void updateMuscle() throws Exception {
    Muscle response = Muscle.builder().id(1).name("Test").build();
    when(muscleService.updateMuscle(any(), any())).thenReturn(response);

    this.mockMvc.perform(put("/muscles/{id}", 1)
            .with(csrf())
            .content(toJson(Muscle.builder().id(2).name("Test").build()))
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Test"));
  }

  @Test
  void deleteMuscle() throws Exception {
    this.mockMvc.perform(delete("/muscles/{id}", anyInt())
            .with(csrf()))
        .andExpect(status().isNoContent());
  }
}

