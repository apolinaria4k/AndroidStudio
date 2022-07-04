package com.example.project32;

public enum Status {
    Pupil,
    Student,
    Worker,
    Teacher;
    public static com.example.project32.Status valueOf(int ordinal){
        for(com.example.project32.Status item:values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
