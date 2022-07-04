package com.example.project33;

import java.io.Serializable;

public enum Priority implements Serializable {
    High,
    Medium,
    Low;
    public static com.example.project33.Priority valueOf(int ordinal){
        for(com.example.project33.Priority item: values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

}