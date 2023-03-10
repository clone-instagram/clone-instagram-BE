package com.hanghae.cloneinstagram.rest.post.model;

import com.hanghae.cloneinstagram.config.model.Timestamped;
import com.hanghae.cloneinstagram.rest.post.dto.PostRequestDto;
import com.hanghae.cloneinstagram.rest.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
//@Table(name="post", indexes = @Index(name = "idx__userId", columnList = "userId"))
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column
    private String content;

    @Column(nullable = false)
    private String imgUrl;

    @Column
    private int likes;

    @Column
    private boolean deleted;

    public Post(PostRequestDto postRequestDto, String imageUrl, User user) {
        this.userId = user.getId();
        this.content = postRequestDto.getContent();
        this.imgUrl = imageUrl;
        this.likes = 0;
        this.deleted = false;
    }

    public void softDelete() {
        this.deleted = true;
    }
    
    public void softDelete(PostRequestDto postRequestDto, String imageUrl) {
        this.content = postRequestDto.getContent();
        this.imgUrl = imageUrl;
    }
    
    public void addLike(){
        this.likes++;
    }
    
    public void unLike(){
        this.likes--;
    }
}
