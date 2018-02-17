package com.company.app.forms;

import lombok.Data;

import java.time.LocalTime;

@Data
public class RegistrationForm {
    private String email;
    private String password;
    private String checkPassword;
    private String timeWakeUp;
}
