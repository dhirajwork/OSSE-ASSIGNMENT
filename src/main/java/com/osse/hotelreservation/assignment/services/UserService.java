package com.osse.hotelreservation.assignment.services;

import com.osse.hotelreservation.assignment.entity.User;
import com.osse.hotelreservation.assignment.temp.CurrentUser;
import org.springframework.security.core.userdetails.UserDetailsService;

//Service Pattern for User
public interface UserService extends UserDetailsService {

    public User findUserByEmail(String email);

    public void saveUser(CurrentUser currentUser);

    public int getLoggedUserId();
}
