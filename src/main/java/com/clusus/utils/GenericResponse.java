package com.clusus.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GenericResponse<T>{

    int status;
    private List<T> message;
}
