package com.fitness.app.common.repository;

import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public abstract class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

  protected final JPAQueryFactory jpaQueryFactory;
  @Getter
  private final Querydsl querydsl;

  protected BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
    super(domainClass, entityManager);
    this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    this.querydsl = new Querydsl(entityManager, new PathBuilder<>(domainClass, "entity"));
  }
}
