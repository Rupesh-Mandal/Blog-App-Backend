package com.rupesh_mandal.blog_app_backend.repository;

import com.rupesh_mandal.blog_app_backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
