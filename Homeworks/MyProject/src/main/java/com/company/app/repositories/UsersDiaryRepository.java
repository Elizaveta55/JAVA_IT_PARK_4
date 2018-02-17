package com.company.app.repositories;

import com.company.app.models.User;
import com.company.app.models.UserDiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface UsersDiaryRepository extends JpaRepository<UserDiary, Long> {

    void deleteAllByCurrentDayBefore(LocalDate localDate);
    List<UserDiary> findByCurrentDayAfterAndTestGoodSleep(LocalDate time, int testGoodSleep);

}
