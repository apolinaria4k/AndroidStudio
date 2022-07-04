package com.example.project32;

public enum Sex {
    Male,
    Female;
    public static com.example.project32.Sex valueOf(int ordinal){
        for(com.example.project32.Sex item:values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
