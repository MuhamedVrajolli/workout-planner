package com.fitness.app.progresstracker.models;

import java.time.LocalDateTime;
import java.util.List;

public record ProgressTracker(Integer id, Integer sets, List<Integer> repsAndWeight, Boolean untilFailure,
                              LocalDateTime createdDate) {

}
