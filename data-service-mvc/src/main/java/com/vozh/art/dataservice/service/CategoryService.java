package com.vozh.art.dataservice.service;

import com.vozh.art.dataservice.dto.response.CategoryResponse;
import com.vozh.art.dataservice.entity.Category;
import com.vozh.art.dataservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

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

    public static CategoryResponse mapToResponse(Category category, int depth) {
        if (category == null || depth < 0) {
            return null;
        }

        CategoryResponse.CategoryResponseBuilder builder = CategoryResponse.builder()
                .categoryId(category.getId())
                .description(category.getDescription());

        if (depth > 0) {
            builder.parentCategory(mapToResponse(category.getParentCategory(), depth - 1))
                    .subCategories(category.getSubCategories() != null ?
                            category.getSubCategories().stream()
                                    .map(sub -> mapToResponse(sub, depth - 1))
                                    .collect(Collectors.toSet()) : new HashSet<>());
        }

        return builder.build();
    }
}
