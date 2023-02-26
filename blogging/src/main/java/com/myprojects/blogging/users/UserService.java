package com.myprojects.blogging.users;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;


    public UserResponseDto createUser(CreateUserDto userDto){
        //TODO: Encrypt the password
        //TODO: check for the email

        var newUser = modelMapper.map(userDto, UserEntity.class);
        var user = userRepository.findByUsername(userDto.getUsername());
        if(user!=null){
            throw new UserAlreadyExist(newUser.getUsername());
        }

        var savedUser  = userRepository.save(newUser);

        var userResponseDto = modelMapper.map(savedUser, UserResponseDto.class);
        return userResponseDto;
    }


    public UserResponseDto loginUser(UserLoginDto userDto){


        var user = userRepository.findByUsername(userDto.getUsername());
        if(user == null){
            throw new UserNotFoundException(userDto.getUsername());
        }
        //TODO: decrypt the password and check
        if(!user.getPassword().equals(userDto.getPassword())) {
            throw new IllegalArgumentException("Incorrect Password");
        }

        var userResponseDto = modelMapper.map(user, UserResponseDto.class);
        return userResponseDto;


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
