package com.myprojects.blogging.articles;

import com.myprojects.blogging.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired private ArticleService articleService;
    @Autowired private UserService userService;


    @GetMapping("")
    public String getArticle(){
        return "Article";
    }

    @GetMapping("/private")
    public String getPrivateArticle(@AuthenticationPrincipal Long userId){
        return "Private Article end point for user ID " + userId + " username is "+userService.getReferenceById(userId).getUsername();
    }


}
