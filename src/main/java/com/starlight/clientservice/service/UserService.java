package com.starlight.clientservice.service;

import com.starlight.clientservice.model.User;
import com.starlight.clientservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements CommonService<User, Long> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User model) {
        model.setCreationDate(LocalDate.now());
        userRepository.save(model);

    }

    @Override
    public User findById(Long value) {
        return null;
    }

    @Override
    public User update(User model) {
        return null;
    }

    @Override
    public void delete(Long value) {

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
