package com.company.app.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "UserDiary")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "appUser")
@ToString(exclude = "appUser")
@Builder
public class UserDiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;

    private LocalTime timeGoToSleep;

    private LocalTime timeWakeUpCurrent;

    private LocalDate currentDay;

    private LocalTime delta;

    private int testGoodSleep;

    private int testMoonWalker;

    private int testDreams;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private User appUser;
}
