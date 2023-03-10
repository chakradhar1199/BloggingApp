package com.myprojects.blogging.articles;

import com.myprojects.blogging.commons.BaseEntity;
import com.myprojects.blogging.users.UserEntity;
import jakarta.persistence.*;

import javax.swing.plaf.basic.BasicArrowButton;
import java.util.List;

@Entity(name = "article")
public class Article extends BaseEntity {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 200)
    private String title;
    private String subtitle;

    @Column(nullable = false, length = 8000)
    private String body;

    @ManyToOne
    private UserEntity author;

    @ManyToMany(mappedBy = "likedArticles")
    private List<UserEntity> likes;

}
