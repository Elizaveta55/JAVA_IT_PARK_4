package com.company.app.services;

import com.company.app.models.UserDiary;
import org.springframework.security.core.Authentication;

import java.time.LocalTime;
import java.util.List;

public interface RecommendationService {

    List<LocalTime> getRecommendation(Authentication authentication);

}
