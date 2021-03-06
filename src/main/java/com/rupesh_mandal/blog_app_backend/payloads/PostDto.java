package com.rupesh_mandal.blog_app_backend.payloads;

import com.rupesh_mandal.blog_app_backend.entity.CategoryEntity;
import com.rupesh_mandal.blog_app_backend.entity.CommentEntity;
import com.rupesh_mandal.blog_app_backend.entity.UserEntity;
import lombok.*;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    private int postId;

    @Size(min = 4,message = "title must be min 4 charactes !!")
    private String title;

    @Size(min = 10,message = "title must be min 10 charactes !!")
    private String content;

    private String imageName;

    private Date addedDate;

    private UserDto userEntity;

    private CategoryDto categoryEntity;


}
