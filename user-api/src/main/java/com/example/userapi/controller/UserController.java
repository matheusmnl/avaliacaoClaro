package com.example.userapi.controller;

import com.example.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;

    }
    @GetMapping("/users/{email}")
    public  UserDTO getUsersFiltro(@PathVariable String email) {
        for (UserDTO userFilter: users) {
            if(userFilter.getEmail().equals(email)){
                return userFilter;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    UserDTO inserir (@RequestBody UserDTO userDTO) {
        userDTO.setRegistrationDate(new Date());
        users.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/user/{email}")
    public boolean remover(@PathVariable String email) {
        for (UserDTO userFilter: users) {
            if(userFilter.getEmail().equals(email)) {
                users.remove(userFilter);
                return true;
            }
        }
        return false;
    }

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("userOne");
        userDTO.setEmail("EmailUserOne@email.com");
        userDTO.setPhone("EmailUserOne");
        userDTO.setCep("59104-120");
        userDTO.setAddress("AddressUserOne");
        userDTO.setCity("CityUserOne");
        userDTO.setUf("UfUserOne");
        userDTO.setRegistrationDate(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO.setName("userTwo");
        userDTO.setEmail("EmailUserTwo@email.com");
        userDTO.setPhone("EmailUserTwo");
        userDTO.setCep("59104-120");
        userDTO.setAddress("AddressUserTwo");
        userDTO.setCity("CityUserTwo");
        userDTO.setUf("UfUserTwo");
        userDTO.setRegistrationDate(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO.setName("userTree");
        userDTO.setEmail("EmailUserTree@email.com");
        userDTO.setPhone("EmailUserTree");
        userDTO.setCep("59104-120");
        userDTO.setAddress("AddressUserTree");
        userDTO.setCity("CityUserTree");
        userDTO.setUf("UfUseTree");
        userDTO.setRegistrationDate(new Date());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }
}
