package com.company.app.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "appUser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String secondName;

    private String nickName;

    private int age;

    private LocalTime timeWakeUp;

    private String email;

    private String confirmString;

    private String hashPassword;

    private LocalDateTime registrationDate;

    @Enumerated(EnumType.ORDINAL)
    private State state;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user")
    private FileInfo image;

    @OneToMany(mappedBy = "appUser")
    private List<UserDiary> userDiaries;
}
