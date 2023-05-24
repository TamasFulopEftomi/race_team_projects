package com.example.race_team.service.exception;

public class TeamNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException(int id) {
        super(String.valueOf(id));
    }
}
