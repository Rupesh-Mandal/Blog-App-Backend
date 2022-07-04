package com.rupesh_mandal.blog_app_backend.payloads;

import com.rupesh_mandal.blog_app_backend.entity.PostEntity;
import com.rupesh_mandal.blog_app_backend.entity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Data
@Setter
@Getter
@NoArgsConstructor
public class CommentDto {
    private int commentId;

    @Size(min = 4,message = "comment must be min 4 charactes !!")
    private String content;

    private UserDto userEntity;
    private PostDto postEntity;

}
