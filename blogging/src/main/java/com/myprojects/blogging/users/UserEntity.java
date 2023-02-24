package com.myprojects.blogging.users;

import com.myprojects.blogging.articles.Article;
import com.myprojects.blogging.commons.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public class UserEntity extends BaseEntity {
    @Column(unique = true,nullable = false,length = 50)
    private String username;

    // to create the password authentication
    private String password;

    private String bio;
    private String image;

    @JoinTable(
            name = "article likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")

    )
    @ManyToMany
    private List<Article> likedArticles;

    @ManyToMany
    @JoinTable(
            name = "user_follow",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private List<UserEntity> followers;

    @ManyToMany(mappedBy = "followers")
    private List<UserEntity> following;
}
