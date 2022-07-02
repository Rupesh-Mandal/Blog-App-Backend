package com.rupesh_mandal.blog_app_backend.controller;

import com.rupesh_mandal.blog_app_backend.entity.PostEntity;
import com.rupesh_mandal.blog_app_backend.payloads.ApiResponse;
import com.rupesh_mandal.blog_app_backend.payloads.PostDto;
import com.rupesh_mandal.blog_app_backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable int userId,
                                              @PathVariable int categoryId) {
        PostDto createdPost = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable int postId) {
        PostDto createdPost = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/post")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable int userId) {

        List<PostDto> postDtoList = postService.getAllPostByUserId(userId);
        return new ResponseEntity<>(postDtoList,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/post")
    public ResponseEntity<List<PostDto>> getPostBycategory(@PathVariable int categoryId) {

        List<PostDto> postDtoList = postService.getAllPostByCategory(categoryId);
        return new ResponseEntity<>(postDtoList,HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostByPostId(@PathVariable int postId) {

        PostDto postDto = postService.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostDto>> getAllPost() {

        List<PostDto> postDtoList = postService.getAllPost();
        return new ResponseEntity<>(postDtoList,HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted Succefully",true), HttpStatus.OK);
    }
}
