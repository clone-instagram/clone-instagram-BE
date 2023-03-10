package com.hanghae.cloneinstagram.rest.post.dto;

import com.hanghae.cloneinstagram.rest.comment.dto.CommentResponseDto;
import com.hanghae.cloneinstagram.rest.comment.model.Comment;
import com.hanghae.cloneinstagram.rest.post.model.Post;
import com.hanghae.cloneinstagram.rest.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String profileUrl;
    private Long userId;
    private String username;
    private String content;
    private String imgUrl;
    private int likes;
    private boolean like;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int commentsNum;
    private List<CommentResponseDto> commentResponseList = new ArrayList<>();

    public void addCommentResponseDtos(List<CommentResponseDto> commentResponseDtoList){
        this.commentResponseList = commentResponseDtoList;
    }
    
    public PostResponseDto(PostUsernameInterface postUsernameInterface) {
        this.id = postUsernameInterface.getId();
        this.username = postUsernameInterface.getUsername();
        this.userId = postUsernameInterface.getUser_id();
        this.profileUrl = postUsernameInterface.getProfile_url();
        this.content = postUsernameInterface.getContent();
        this.likes = postUsernameInterface.getLikes();
        this.like = postUsernameInterface.getIsLike() != null; // 수정필요
        this.imgUrl = postUsernameInterface.getImg_url();
        this.createdAt = postUsernameInterface.getCreated_at();
        this.modifiedAt = postUsernameInterface.getModified_at();
    }
    
    @Getter
    @NoArgsConstructor
    public static class saveResponse {
        private Long id;
        private Long userId;
        private String content;
        private String imgUrl;
        public saveResponse(Post post) {
            this.id = post.getId();
            this.userId = post.getUserId();
            this.content = post.getContent();
            this.imgUrl = post.getImgUrl();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class getOriginalPost {
        private Long id;
        private String content;
        private String imgUrl;
        public getOriginalPost(Post post) {
            this.id = post.getId();
            this.content = post.getContent();
            this.imgUrl = post.getImgUrl();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class updatePost {
        private Long id;
        private String username;
        private String content;
        private String imgUrl;
        public updatePost(User user, Long postId, PostRequestDto postRequestDto, String imageUrl) {
            this.id = postId;
            this.username = user.getUsername();
            this.content = postRequestDto.getContent();
            this.imgUrl = imageUrl;
        }
    }
}
