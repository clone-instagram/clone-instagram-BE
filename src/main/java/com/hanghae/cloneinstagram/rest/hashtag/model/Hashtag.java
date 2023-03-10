package com.hanghae.cloneinstagram.rest.hashtag.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name="hashtag", indexes = @Index(name = "idx__hashtag", columnList = "hashtag"))
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column
    private String hashtag;

    public Hashtag(Long id, String hashtag) {
        this.postId = id;
        this.hashtag = hashtag;
    }
}
