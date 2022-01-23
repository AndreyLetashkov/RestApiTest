package models;

import lombok.Data;

@Data
public class DifficultUser {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private Geo geo;
    private String phone;
    private String website;
    private Company company;
}