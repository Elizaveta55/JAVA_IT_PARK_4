package com.company.app.dto;

import com.company.app.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String email;
    private String name;
    private String secondName;
    private String nickName;
    private int age;
    private LocalTime timeWakeUp;
    private LocalDateTime registrationDate;
    private String imageUrl;

    public static UserDto from(User model){
        LocalTime temp = model.getTimeWakeUp();
        int hours = temp.getHour();
        int mins = temp.getMinute();
        temp = LocalTime.of(hours, mins);
        UserDto result = UserDto.builder()
                .email(model.getEmail())
                .name(model.getName())
                .secondName(model.getSecondName())
                .nickName(model.getNickName())
                .age(model.getAge())
                .timeWakeUp(temp)
                .registrationDate(model.getRegistrationDate())
                .build();

        if (model.getImage() != null){
            result.imageUrl = "/files/" + model.getImage().getStorageFileName();
        }

        return result;
    }
}
