package com.epul.exception;

/**
 * Created by Sacha on 16/05/2017.
 */
public class CustomException extends Exception{
    private String message;
    private String type;

    public CustomException( String libelle,  String type) {
        this.message = libelle;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
