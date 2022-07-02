package com.rupesh_mandal.blog_app_backend.services;

import com.rupesh_mandal.blog_app_backend.entity.PostEntity;
import com.rupesh_mandal.blog_app_backend.payloads.PostDto;
import com.rupesh_mandal.blog_app_backend.payloads.PostResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId);

    PostDto updatePost(PostDto postDto, int postId);

    void deletePost(int postId);

    PostResponse getAllPost(Pageable pageable);

    PostDto getPostById(int postId);

    PostResponse getAllPostByCategory(int categoryId,Pageable pageable);

    PostResponse getAllPostByUserId(int userId,Pageable pageable);

    PostResponse searchPost(String keyword,Pageable pageable);


}
