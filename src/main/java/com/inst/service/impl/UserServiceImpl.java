package com.inst.service.impl;

import com.inst.entity.User;
import com.inst.exception.EntityNotFoundException;
import com.inst.repository.UserRepository;
import com.inst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        if (login == null)
            throw new EntityNotFoundException("Login is null");
        User user;
        try {
            user = userRepository.findUserByLogin(login);
        } catch (UsernameNotFoundException e) {
            return null;
        }
        return user;
    }

    @Override
    public void create(User user) {

        if (user == null)
            throw new EntityNotFoundException("User entity is null");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.create(user);
    }

    @Override
    public User findById(int id) {
        if( id < 0)
            throw new IllegalArgumentException("User id is less than 0");
        return userRepository.findById(id);
    }

    @Override
    public List<User> searchUsersByLogin(String login) {
        if(login == null)
            throw new IllegalArgumentException("Image id is less than 0");
        return userRepository.searchUsersByLogin(login);
    }

    @Override
    @Transactional
    public void subscribe(User currentUser, User user) {
        if (currentUser == null)
            throw new EntityNotFoundException("CurrentUser entity is null");
        if (user == null)
            throw new EntityNotFoundException("User entity is null");

        currentUser = userRepository.findById(currentUser.getId());
        if (currentUser != null) {
            currentUser.addFollowing(user);
        }
    }

    @Override
    @Transactional
    public void unsubscribe(User currentUser, User user) {
        if (currentUser == null)
            throw new EntityNotFoundException("CurrentUser entity is null");
        if (user == null)
            throw new EntityNotFoundException("User entity is null");

        currentUser = userRepository.findById(currentUser.getId());
        user = userRepository.findById(user.getId());

        currentUser.getFollowing().remove(user);
        user.getFollowers().remove(currentUser);
    }


    //    to deal with a hibernate contains method in persistSet bug
    @Override
    public boolean contains(Collection<User> list, User user) {
        for (User u : list) {
            if(u.getId() == user.getId())
                return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void update(User user) {
        if (user == null)
            throw new EntityNotFoundException("User entity is null");
        userRepository.update(user);
    }

    @Override
    public void updatePassword(User user) {
        if (user == null)
            throw new EntityNotFoundException("User entity is null");

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        this.update(user);
    }
}
