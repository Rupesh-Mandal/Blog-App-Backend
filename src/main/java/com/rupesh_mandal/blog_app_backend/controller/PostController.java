package com.rupesh_mandal.blog_app_backend.controller;

import com.rupesh_mandal.blog_app_backend.config.AppConstants;
import com.rupesh_mandal.blog_app_backend.entity.PostEntity;
import com.rupesh_mandal.blog_app_backend.payloads.ApiResponse;
import com.rupesh_mandal.blog_app_backend.payloads.PostDto;
import com.rupesh_mandal.blog_app_backend.payloads.PostResponse;
import com.rupesh_mandal.blog_app_backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

import static com.rupesh_mandal.blog_app_backend.config.AppConstants.PAGE_SIZE;

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
    public ResponseEntity<PostResponse> getPostByUser(@PathVariable int userId,
                                                      @RequestParam(value = "pageSize") Optional<Integer> pageSize,
                                                      @RequestParam(value = "pageNumber") Optional<Integer> pageNumber,
                                                      @RequestParam(value = "sortBy") Optional<String> sortBy,
                                                      @RequestParam(value = "sortDir") Optional<Sort.Direction> sort) {
        Pageable pageable = PageRequest.of(pageNumber.orElse(AppConstants.PAGE_NUMBBER),
                pageSize.orElse(AppConstants.PAGE_SIZE), sort.orElse(AppConstants.sort), sortBy.orElse(AppConstants.SORT_BY));

        PostResponse postDtoList = postService.getAllPostByUserId(userId,pageable);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/post")
    public ResponseEntity<PostResponse> getPostBycategory(@PathVariable int categoryId,
                                                          @RequestParam(value = "pageSize") Optional<Integer> pageSize,
                                                          @RequestParam(value = "pageNumber") Optional<Integer> pageNumber,
                                                          @RequestParam(value = "sortBy") Optional<String> sortBy,
                                                          @RequestParam(value = "sortDir") Optional<Sort.Direction> sort) {
        Pageable pageable = PageRequest.of(pageNumber.orElse(AppConstants.PAGE_NUMBBER),
                pageSize.orElse(AppConstants.PAGE_SIZE), sort.orElse(AppConstants.sort), sortBy.orElse(AppConstants.SORT_BY));

        PostResponse postResponse = postService.getAllPostByCategory(categoryId, pageable);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostByPostId(@PathVariable int postId) {

        PostDto postDto = postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<PostResponse> getAllPost(@RequestParam(value = "pageSize") Optional<Integer> pageSize,
                                                   @RequestParam(value = "pageNumber") Optional<Integer> pageNumber,
                                                   @RequestParam(value = "sortBy") Optional<String> sortBy,
                                                   @RequestParam(value = "sortDir") Optional<Sort.Direction> sort) {
        Pageable pageable = PageRequest.of(pageNumber.orElse(AppConstants.PAGE_NUMBBER),
                pageSize.orElse(AppConstants.PAGE_SIZE), sort.orElse(AppConstants.sort), sortBy.orElse(AppConstants.SORT_BY));

        PostResponse postResponse = postService.getAllPost(pageable);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted Succefully", true), HttpStatus.OK);
    }

    @GetMapping("/post/search/{keyword}")
    public ResponseEntity<PostResponse> searchPost(@PathVariable String keyword,
                                                   @RequestParam(value = "pageSize") Optional<Integer> pageSize,
                                                   @RequestParam(value = "pageNumber") Optional<Integer> pageNumber,
                                                   @RequestParam(value = "sortBy") Optional<String> sortBy,
                                                   @RequestParam(value = "sortDir") Optional<Sort.Direction> sort) {
        Pageable pageable = PageRequest.of(pageNumber.orElse(AppConstants.PAGE_NUMBBER),
                pageSize.orElse(AppConstants.PAGE_SIZE), sort.orElse(AppConstants.sort), sortBy.orElse(AppConstants.SORT_BY));

        PostResponse postResponse = postService.searchPost(keyword,pageable);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }
}
