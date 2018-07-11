package com.inst.service.impl;

import com.inst.entity.User;
import com.inst.exception.EntityNotFoundException;
import com.inst.repository.UserRepository;
import com.inst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if (login == null)
            throw new EntityNotFoundException("Login is null");
        return userRepository.findUserByLogin(login);
    }

    @Override
    public void create(User user) {
        if (user == null)
            throw new EntityNotFoundException("User entity is null");
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
            if( u.equals(user))
                return true;
        }
        return false;
    }
}
