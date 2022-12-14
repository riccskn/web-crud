package com.riccskn.crud.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO{

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Nickname can't be blank")
    private String nickname;

    @NotBlank(message = "Nickname can't be blank")
    private String phone;

    @Email(message = "Invalid email")
    private String email;

    public UserDTO(String name, String nickname, String phone, String email) {
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
