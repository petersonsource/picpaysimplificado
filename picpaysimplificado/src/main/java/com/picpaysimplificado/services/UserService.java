package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validaTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT){
            throw new Exception("usuario do tipo logista não esta autorizado a realizar transação");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Salda Insuficiente!");
        }
    }


    public User findUserById(Long id) throws Exception {
        return (User) this.repository.findUserById(id)
                .orElseThrow(() -> new Exception("usuário não encontrado"));
    }

    public void saveUser(User user){
        repository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new  User(data);
        return repository.save(newUser);
    }

    public List<User> getAllUusers() {
        return repository.findAll();
    }
}
