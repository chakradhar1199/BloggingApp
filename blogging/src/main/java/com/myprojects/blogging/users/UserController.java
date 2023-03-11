package com.myprojects.blogging.users;

import com.myprojects.blogging.security.authtoken.AuthToken;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getReferenceById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.getReferenceById(id);
        return ResponseEntity.ok().body(userResponseDto);
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        var userList = userService.getUsers();
        return ResponseEntity.ok().body(userList);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id,@RequestBody CreateUserDto createUserDto){
        var userRespone = userService.upateUser(id, createUserDto);
        return ResponseEntity.accepted().body(userRespone);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){

        return ResponseEntity.accepted().body("User id " + userService.deleteUser(id) + " deleted");
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> loginUser(@RequestBody UserLoginDto loginDto,
                                                     @RequestParam(required = false,value = "token") String authToken){

        // (default) auth token is JWT
        var auth_token = UserService.AuthType.JWT;
        if(authToken!=null && authToken.equals("auth_token") ){
            auth_token = UserService.AuthType.AUTH_TOKEN;
        }
        var savedUser = userService.loginUser(loginDto, auth_token);
        return ResponseEntity.ok(savedUser);
    }

    @ExceptionHandler(UserService.UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
