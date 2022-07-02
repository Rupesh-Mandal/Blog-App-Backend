package com.rupesh_mandal.blog_app_backend.repository;

import com.rupesh_mandal.blog_app_backend.entity.CategoryEntity;
import com.rupesh_mandal.blog_app_backend.entity.PostEntity;
import com.rupesh_mandal.blog_app_backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity,Integer> {

    List<PostEntity> findAllByUserEntity(UserEntity userEntity);
    List<PostEntity> findAllByCategoryEntity(CategoryEntity categoryEntity);

}
