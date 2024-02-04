package com.fitness.app.users.models;

public record User(Integer id, String username, String firstName, String lastName, Integer age, Boolean gender,
                   Integer weight, Integer height) {

}
