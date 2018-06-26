package com.inst.service.impl;

import com.inst.entity.User;
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
        return userRepository.findUserByLogin(login);
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public User findById(int id) {
       return  userRepository.findById(id);
    }

    @Override
    public List<User> searchUsersByLogin(String login) {
        return userRepository.searchUsersByLogin(login);
    }

    @Override
    @Transactional
    public void subscribe(User currentUser, User user) {
        currentUser = userRepository.findById(currentUser.getId());

        if (currentUser != null) {
            currentUser.addFollowing(user);
        }
    }

    @Override
    @Transactional
    public void unsubscribe(User currentUser, User user) {
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
