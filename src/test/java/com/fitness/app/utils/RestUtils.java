package com.fitness.app.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;

public final class RestUtils {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .setSerializationInclusion(Include.NON_EMPTY)
      .registerModule(new JavaTimeModule())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

  private RestUtils() {
  }

  public static String toJson(Object value) {
    try {
      return OBJECT_MAPPER.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException("invalid json conversion", e);
    }
  }

  public static <T> T fromJson(String json, Class<T> type) {
    try {
      return OBJECT_MAPPER.readValue(json, type);
    } catch (IOException e) {
      throw new IllegalArgumentException("cannot read json response", e);
    }
  }
}
