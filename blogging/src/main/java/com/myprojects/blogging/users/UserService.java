package com.myprojects.blogging.users;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;


    public UserResponseDto createUser(CreateUserDto userDto){
        //TODO: Encrypt the password
        //TODO: check for the email

        var newUser = modelMapper.map(userDto, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        var user = userRepository.findByUsername(userDto.getUsername());
        if(user!=null){
            throw new UserAlreadyExist(newUser.getUsername());
        }

        var savedUser  = userRepository.save(newUser);

        var userResponseDto = modelMapper.map(savedUser, UserResponseDto.class);
        return userResponseDto;
    }

    public List<UserResponseDto> getUsers(){
        var userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(UserEntity user: userList){
            userResponseDtos.add(modelMapper.map(user,UserResponseDto.class));
        }
        return userResponseDtos;
    }
    public UserResponseDto loginUser(UserLoginDto userDto){


        var user = userRepository.findByUsername(userDto.getUsername());
        if(user == null){
            throw new UserNotFoundException(userDto.getUsername());
        }
        //TODO: decrypt the password and check
        var passMatch = passwordEncoder.matches(userDto.getPassword(), user.getPassword());
        if(!passMatch){
            throw new IllegalArgumentException("Incorrect Password");
        }


        var userResponseDto = modelMapper.map(user, UserResponseDto.class);
        return userResponseDto;


    }

    public UserResponseDto upateUser(Long id, CreateUserDto createUserDto) {
         UserEntity user = userRepository.getReferenceById(id);
         user.setUsername(createUserDto.getUsername());
         user.setPassword(createUserDto.getPassword());
         user.setEmail(createUserDto.getEmail());
         return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto getReferenceById(Long id) {
        UserEntity user = userRepository.getReferenceById(id);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public Long deleteUser(Long id) {
        UserEntity user = userRepository.getReferenceById(id);

        if(!user.equals(null)){
        Long deletedUserId = user.getId();
        userRepository.delete(user);
        return deletedUserId;
        }
        else throw new UserNotFoundException(id);

    }

    public static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(Long id){
            super("User with id "+id+" not found");
        }

        public UserNotFoundException(String username){
            super("User with username: "+username+" not found");
        }


    }

    public static class UserAlreadyExist extends IllegalArgumentException{
        public UserAlreadyExist(String username){
            super("Username "+ username+" already exists");
        }
    }
}
