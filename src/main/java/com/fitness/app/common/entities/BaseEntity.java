package com.fitness.app.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@MappedSuperclass
@Getter
@Setter
@SQLRestriction("deleted = false")
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;

  @Column(name = "created_date", insertable = false, updatable = false)
  protected LocalDateTime createdDate;

  @Column(name = "updated_date")
  protected LocalDateTime updatedDate;

  @Column
  protected Boolean deleted = false;
}
