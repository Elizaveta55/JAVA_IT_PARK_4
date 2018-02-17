package com.company.app.services;

import com.company.app.forms.RegistrationForm;
import com.company.app.models.Role;
import com.company.app.models.State;
import com.company.app.models.User;
import com.company.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;


    @Override
    public boolean registrationUser(RegistrationForm form) {
        String confirmString = UUID.randomUUID().toString();
        if (form.getPassword().equals(form.getCheckPassword())){
            User newUser = User.builder()
                    .email(form.getEmail())
                    .hashPassword(passwordEncoder.encode(form.getPassword()))
                    .registrationDate(LocalDateTime.now())
                    .timeWakeUp(LocalTime.parse(form.getTimeWakeUp()))
                    .state(State.NOT_CONFIRMED)
                    .role(Role.USER)
                    .confirmString(confirmString)
                    .build();
        String mailText = "<a href=\"http://localhost/confirm/" + confirmString + "\">Подвтердить</a>";
        usersRepository.save(newUser);
        String email = newUser.getEmail();
        email = "<"+email+">";
        emailService.sendMail(email, "Подтвреждение регистрации", mailText);
        return true;
       }
       else return false;
    }

    @Override
    public boolean confirmUser(String confirmString) {
        Optional<User> userOptional = usersRepository.findByConfirmString(confirmString);

        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setConfirmString(null);
            user.setState(State.CONFIRMED);
            usersRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
