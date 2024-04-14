package com.mokito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public User adduser(User user){

       return iUserRepository.save(user);

    }

    public boolean isUserAktiert(User user){
        if(user.isAktive()){
            return true;
        }
        else return false;
    }
}
