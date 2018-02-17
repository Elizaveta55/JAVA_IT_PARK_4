package com.company.app.services;

import com.company.app.forms.DiaryForm;
import com.company.app.models.User;
import com.company.app.models.UserDiary;
import com.company.app.repositories.UsersDiaryRepository;
import com.company.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private UsersDiaryRepository usersDiaryRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addToDB(DiaryForm form, Authentication authentication) {
        try {
        User user = usersRepository.findByEmail(authentication.getName()).orElseThrow(IllegalArgumentException::new);


            String time1 = form.getTimeGoToSleep();
            String time2 = form.getTimeWakeUpCurrent();
            LocalTime time3 = user.getTimeWakeUp();
            LocalTime check = LocalTime.parse(time2);
            if (check.isAfter(time3)){
                time2 = time3.toString();
            }
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            long difference = date2.getTime() - date1.getTime();
            long diffMinutes = difference / (60 * 1000) % 60;
            long diffHours = difference / (60 * 60 * 1000) % 24;
            if (difference < 0){
                diffHours = 24 + diffHours;
                diffMinutes = 60 + diffMinutes;
            }
            if (diffMinutes == 60) {
                diffHours = diffHours + 1;
                diffMinutes = 0;
            }
            if (diffHours == 24){
                diffHours = 23;
                diffMinutes = 59;
            }
            LocalTime deltaTimes = LocalTime.of((int)diffHours, (int)diffMinutes);

        UserDiary newUserDiary = UserDiary.builder()
                .timeGoToSleep(LocalTime.parse(form.getTimeGoToSleep()))
                .timeWakeUpCurrent(LocalTime.parse(form.getTimeWakeUpCurrent()))
                .nickName(user.getNickName())
                .delta(deltaTimes)
                .currentDay(LocalDate.now())
                .appUser(user)
                .testGoodSleep(form.getTestGoodSleep())
                .testMoonWalker(form.getTestMoonWalker())
                .testDreams(form.getTestDreams())
                .build();

            if (user.getImage() != null){
                newUserDiary.setImageUrl("/files/" + user.getImage().getStorageFileName());
            }

        usersDiaryRepository.save(newUserDiary);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void delete() {
        System.out.println(LocalDate.now().minusDays(14));
        usersDiaryRepository.deleteAllByCurrentDayBefore(LocalDate.now().minusDays(14));
    }

    @Override
    public List<UserDiary> findAll(Authentication authentication) {
        User currentUser = usersRepository.findByEmail(authentication.getName()).orElseThrow(IllegalArgumentException::new);
        return currentUser.getUserDiaries();
    }
}
