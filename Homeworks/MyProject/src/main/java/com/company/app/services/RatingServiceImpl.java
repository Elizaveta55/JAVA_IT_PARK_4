package com.company.app.services;

import com.company.app.models.UserDiary;
import com.company.app.repositories.UsersDiaryRepository;
import com.company.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    public UsersDiaryRepository usersDiaryRepository;

    @Autowired
    public UsersRepository usersRepository;

    @Override
    public List<UserDiary> getRatingByTest() {
        List<UserDiary> userDiaries10 = usersDiaryRepository.findByCurrentDayAfterAndTestGoodSleep(LocalDate.now().minusDays(1),10);
        List<UserDiary> userDiaries9 = usersDiaryRepository.findByCurrentDayAfterAndTestGoodSleep(LocalDate.now().minusDays(1),9);
        List<UserDiary> userDiaries8 = usersDiaryRepository.findByCurrentDayAfterAndTestGoodSleep(LocalDate.now().minusDays(1), 8);
        userDiaries10.addAll(userDiaries9);
        userDiaries10.addAll(userDiaries8);
        return userDiaries10;
    }
}
