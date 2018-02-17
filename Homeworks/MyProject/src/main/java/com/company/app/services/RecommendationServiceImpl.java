package com.company.app.services;

import com.company.app.models.User;
import com.company.app.models.UserDiary;
import com.company.app.repositories.UsersDiaryRepository;
import com.company.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private UsersDiaryRepository usersDiaryRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<LocalTime> getRecommendation(Authentication authentication) {
        User user = usersRepository.findByEmail(authentication.getName()).orElseThrow(IllegalArgumentException::new);
        List<UserDiary> userDiaries = user.getUserDiaries();

        if (userDiaries.size() == 0) {
            LocalTime temp = user.getTimeWakeUp();
            int hours = temp.getHour();
            int mins = temp.getMinute();
            LocalTime tempUser2 = LocalTime.of(hours, mins);
            if (mins < 10) {
                mins = mins + 50;
                hours = hours - 1;
            }
            else
            {
                mins = mins -10;
            }
            if (hours < 7) {
                hours = hours + 17;
            }
            else
            {
                hours = hours - 7;
            }
            LocalTime goSleep = LocalTime.of(hours, mins);
            List<LocalTime> times = new ArrayList<>();
            times.add(goSleep);
            times.add(tempUser2);
            return times;
        } else {
            int usersSleepZona[] = new int[1000];
            for (int i = 0; i < 1000; i++) {
                usersSleepZona[i] = -1;
            }
            UserDiary temp = userDiaries.get(0);
            LocalTime delta = temp.getDelta();
            int hours = delta.getHour();
            int mins = delta.getMinute();
            int sum = hours * 60 + mins;
            usersSleepZona[sum] = temp.getTestGoodSleep();
            for(Iterator it = userDiaries.iterator(); it.hasNext();){
                temp = (UserDiary)it.next();
                delta = temp.getDelta();
                hours = delta.getHour();
                mins = delta.getMinute();
                sum = hours * 60 + mins;
                usersSleepZona[sum] = temp.getTestGoodSleep();
            }

            int result10 = -1;
            for (int i = 999; i > 0; i--) {
                if (usersSleepZona[i] == 10) {
                    result10 = i;
                    break;
                }
            }
            if (result10 == -1) {
                int result9 = -1;
                for (int i = 999; i > 0; i--) {
                    if (usersSleepZona[i] == 9) {
                        result9 = i;
                        break;
                    }
                }
                if (result9 == -1) {
                    int result8 = -1;
                    for (int i = 999; i > 0; i--) {
                        if (usersSleepZona[i] == 8) {
                            result8 = i;
                            break;
                        }
                    }
                    if (result8 == -1) {
                        LocalTime tempUser = user.getTimeWakeUp();
                        int hoursUser = tempUser.getHour();
                        int minsUser = tempUser.getMinute();
                        LocalTime tempUser2 = LocalTime.of(hoursUser, minsUser);
                        if (minsUser < 10) {
                            minsUser = minsUser + 50;
                            hoursUser = hoursUser - 1;
                        }
                        else{
                            minsUser = minsUser - mins;
                        }
                        if (hoursUser < 7) {
                            hoursUser = hoursUser + 17;
                        }
                        else{
                            hoursUser = hoursUser - hours;
                        }
                        LocalTime goSleep = LocalTime.of(hoursUser, minsUser);
                        List<LocalTime> times = new ArrayList<>();
                        times.add(goSleep);
                        times.add(tempUser2);
                        return times;
                    } else {
                        LocalTime tempUser = user.getTimeWakeUp();
                        int hoursUser = tempUser.getHour();
                        int minsUser = tempUser.getMinute();
                        LocalTime tempUser2 = LocalTime.of(hoursUser, minsUser);
                        if (minsUser < (result8 % 60)) {
                            minsUser = minsUser + 60 - (result8 % 60);
                            hoursUser = hoursUser - 1;
                        }
                        else{
                            minsUser = minsUser - mins;
                        }
                        if (hoursUser < (result8 / 60)) {
                            hoursUser = hoursUser + 24 - (result8 / 60);
                        }
                        else{
                            hoursUser = hoursUser - hours;
                        }
                        LocalTime goSleep = LocalTime.of(hoursUser, minsUser);
                        List<LocalTime> times = new ArrayList<>();
                        times.add(goSleep);
                        times.add(tempUser2);
                        return times;
                    }
                } else {
                    LocalTime tempUser = user.getTimeWakeUp();
                    int hoursUser = tempUser.getHour();
                    int minsUser = tempUser.getMinute();
                    LocalTime tempUser2 = LocalTime.of(hoursUser, minsUser);
                    if (minsUser < (result9 % 60)) {
                        minsUser = minsUser + 60 - (result9 % 60);
                        hoursUser = hoursUser - 1;
                    }
                    else{
                        minsUser = minsUser - (result9 % 60);
                    }
                    if (hoursUser < (result9 / 60)) {
                        hoursUser = hoursUser + 24 - (result9 / 60);
                    }
                    else {
                        hoursUser = hoursUser - (result9 / 60);
                    }
                    LocalTime goSleep = LocalTime.of(hoursUser, minsUser);
                    List<LocalTime> times = new ArrayList<>();
                    times.add(goSleep);
                    times.add(tempUser2);
                    return times;
                }
            } else {

                LocalTime tempUser = user.getTimeWakeUp();
                int hoursUser = tempUser.getHour();
                int minsUser = tempUser.getMinute();
                LocalTime tempUser2 = LocalTime.of(hoursUser, minsUser);
                if (minsUser < (result10 % 60)) {
                    minsUser = minsUser + 60 - (result10 % 60);
                    hoursUser = hoursUser - 1;
                }
                else{
                    minsUser = minsUser - (result10 % 60);
                }
                if (hoursUser < (result10 / 60)) {
                    hoursUser = hoursUser + 24 - (result10 / 60);
                }
                else {
                    hoursUser = hoursUser - (result10 / 60);
                }
                LocalTime goSleep = LocalTime.of(hoursUser, minsUser);
                List<LocalTime> times = new ArrayList<>();
                times.add(goSleep);
                times.add(tempUser2);
                return times;
            }
        }
    }
}
