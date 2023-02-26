package com.myprojects.blogging.users;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserDto request){
        var savedUser = userService.createUser(request);
        return ResponseEntity
                .created(URI.create("/users/" + savedUser.getId()))
                .body(savedUser);

    }
}
