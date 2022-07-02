package com.rupesh_mandal.blog_app_backend.services;

import com.rupesh_mandal.blog_app_backend.entity.PostEntity;
import com.rupesh_mandal.blog_app_backend.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId);

    PostDto updatePost(PostDto postDto, int postId);

    void deletePost(int postId);

    List<PostDto> getAllPost();

    PostDto getPostById(int postId);

    List<PostDto> getAllPostByCategory(int categoryId);

    List<PostDto> getAllPostByUserId(int userId);

    List<PostDto> searchPost(String keyword);


}
