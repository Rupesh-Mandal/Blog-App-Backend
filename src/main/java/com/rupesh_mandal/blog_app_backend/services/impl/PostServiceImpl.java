package com.rupesh_mandal.blog_app_backend.services.impl;

import com.rupesh_mandal.blog_app_backend.entity.CategoryEntity;
import com.rupesh_mandal.blog_app_backend.entity.PostEntity;
import com.rupesh_mandal.blog_app_backend.entity.UserEntity;
import com.rupesh_mandal.blog_app_backend.exeptions.ResourceNotFountException;
import com.rupesh_mandal.blog_app_backend.payloads.CategoryDto;
import com.rupesh_mandal.blog_app_backend.payloads.PostDto;
import com.rupesh_mandal.blog_app_backend.payloads.UserDto;
import com.rupesh_mandal.blog_app_backend.repository.CategoryRepository;
import com.rupesh_mandal.blog_app_backend.repository.PostRepository;
import com.rupesh_mandal.blog_app_backend.repository.UserRepository;
import com.rupesh_mandal.blog_app_backend.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto,int userId,int categoryId) {
        PostEntity postEntity=modelMapper.map(postDto,PostEntity.class);
        postEntity.setImageName("Default.png");
        postEntity.setAddedDate(new Date());

        UserEntity userEntity=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFountException("User","id",userId));
        CategoryEntity categoryEntity=categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFountException("Caregory","id",categoryId));

        postEntity.setUserEntity(userEntity);
        postEntity.setCategoryEntity(categoryEntity);

        PostEntity newPost=postRepository.save(postEntity);

        PostDto newPostDto=modelMapper.map(newPost,PostDto.class);

        return newPostDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, int postId) {
        PostEntity postEntity=postRepository.findById(postId).orElseThrow(()-> new ResourceNotFountException("Post","id",postId));
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        postEntity.setImageName(postDto.getImageName());

        PostEntity newPost=postRepository.save(postEntity);

        PostDto newPostDto=modelMapper.map(newPost,PostDto.class);

        return newPostDto;
    }

    @Override
    public void deletePost(int postId) {
        PostEntity postEntity=postRepository.findById(postId).orElseThrow(()-> new ResourceNotFountException("Post","id",postId));
        postRepository.delete(postEntity);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<PostEntity> postEntityList=postRepository.findAll();
        List<PostDto> postDtoList=postEntityList.stream().map(postEntity -> modelMapper.map(postEntity,PostDto.class)).collect(Collectors.toList());

        return postDtoList;    }

    @Override
    public PostDto getPostById(int postId) {
        PostEntity postEntity=postRepository.findById(postId).orElseThrow(()-> new ResourceNotFountException("Post","id",postId));
        PostDto postDto=modelMapper.map(postEntity,PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getAllPostByCategory(int categoryId) {
        CategoryEntity categoryEntity=categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFountException("Caregory","id",categoryId));
        List<PostEntity> postEntityList=postRepository.findAllByCategoryEntity(categoryEntity);

        List<PostDto> postDtoList=postEntityList.stream().map(postEntity -> modelMapper.map(postEntity,PostDto.class)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<PostDto> getAllPostByUserId(int userId) {
        UserEntity userEntity=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFountException("User","id",userId));
        List<PostEntity> postEntityList=postRepository.findAllByUserEntity(userEntity);
        List<PostDto> postDtoList=postEntityList.stream().map(postEntity -> modelMapper.map(postEntity,PostDto.class)).collect(Collectors.toList());

        return postDtoList;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }
}
