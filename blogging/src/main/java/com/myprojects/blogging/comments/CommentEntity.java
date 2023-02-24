package com.myprojects.blogging.comments;

import com.myprojects.blogging.articles.Article;
import com.myprojects.blogging.commons.BaseEntity;
import com.myprojects.blogging.users.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(length = 1000)
    private String body;

    @Column(nullable = false, length = 100)
    private String title;


    @ManyToOne
    private UserEntity commentAuthor;

    @ManyToOne
    private Article article;
}
