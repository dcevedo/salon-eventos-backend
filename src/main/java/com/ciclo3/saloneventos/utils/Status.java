package com.ciclo3.saloneventos.utils;

public enum Status {

    PROGRAMMED("programmed"),
    COMPLETED("completed"),
    CANCELLED("cancelled");

    private String value;

    Status(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return this.getValue();
    }
}
