package com.vozh.art.dataservice.service;

import com.vozh.art.dataservice.entity.Category;
import com.vozh.art.dataservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
