package com.company.app.forms;

import com.company.app.models.User;
import com.company.app.repositories.UsersRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class ChangePasswordForm {
    private String oldPassword;
    private String newPassword;


    public boolean changePassword(User model){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(oldPassword, model.getHashPassword())){
            model.setHashPassword(passwordEncoder.encode(newPassword));
            return true;
        } else return false;
    }
}
