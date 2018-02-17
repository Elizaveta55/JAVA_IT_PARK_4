package com.company.app.forms;

import com.company.app.models.User;
import lombok.Data;

@Data
public class PersonalDataForm {
    private String name;
    private String secondName;
    private String nickName;
    private int age;

    public void addInformation(User model){
        model.setName(name);
        model.setSecondName(secondName);
        model.setNickName(nickName);
        model.setAge(age);
    }
}
