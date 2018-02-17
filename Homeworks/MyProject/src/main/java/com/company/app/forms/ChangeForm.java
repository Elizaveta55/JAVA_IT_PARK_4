package com.company.app.forms;

import com.company.app.models.User;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ChangeForm {
    private String name;
    private String secondName;
    private String nickName;
    private String timeWakeUp;

    public void update(User model){
        if (name.equals("")){
            name = null;
        }
        model.setName(name);

        if (secondName.equals("")){
            secondName = null;

        }
        model.setSecondName(secondName);

        if (nickName.equals("")){
            nickName = null;

        }
        model.setNickName(nickName);
        model.setTimeWakeUp(LocalTime.parse(timeWakeUp));
    }
}
