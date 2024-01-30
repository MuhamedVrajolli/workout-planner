package com.fitness.app.modules.users.models;

public record User(Integer id, String username, String firstName, String lastName, Integer age, Boolean gender,
                   Integer weight, Integer height) {

}
