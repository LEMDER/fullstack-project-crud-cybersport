package com.lenkhan.fullstackcrud.exception;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(Long id){
        super("Could not found the user with id: " + id);
    }
}
