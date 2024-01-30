package com.fitness.app.modules.workoutplans.entities;

import com.fitness.app.common.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class TagEntity extends BaseEntity {

  private String name;
}
