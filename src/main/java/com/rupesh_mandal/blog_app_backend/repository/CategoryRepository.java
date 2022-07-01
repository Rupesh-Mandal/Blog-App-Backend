package com.rupesh_mandal.blog_app_backend.repository;

import com.rupesh_mandal.blog_app_backend.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
