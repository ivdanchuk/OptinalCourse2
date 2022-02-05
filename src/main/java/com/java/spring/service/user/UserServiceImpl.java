package com.java.spring.service.user;

import java.util.List;
import java.util.Optional;

import com.java.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.spring.entity.user.User;

@Service
public class

UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public boolean createUser(User user) {
        if (userRepository.existsByLogin(user.getEmail()))
            return false;
        userRepository.save(user);
        return true;
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findUserByEmail(login);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }
}
