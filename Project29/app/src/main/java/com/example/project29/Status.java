package com.example.project29;

public enum Status {
    Pupil,
    Student,
    Worker,
    Teacher;
    public static Status valueOf(int ordinal){
        for(Status item:values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
