package com.starlight.clientservice.service;

import com.starlight.clientservice.model.Client;
import com.starlight.clientservice.model.User;
import com.starlight.clientservice.model.enums.Role;
import com.starlight.clientservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        model.setRole(Role.USER);
        userRepository.save(model);

    }

    @Override
    public Optional<User> findById(Long id) {
        return null;
    }

    @Override
    public User update(User model) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
