package models;

import lombok.Data;

@Data
public class Response<T> {
    private boolean status;
    private T result;
}
