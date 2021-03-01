package com.labforward.task.service;

import com.labforward.task.dto.CategoryDto;
import com.labforward.task.dto.ItemDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
    List<ItemDto> findItemsByCategory(Long categoryId);
    Long createCategory(CategoryDto categoryDto);
    Long createItem(ItemDto itemDto);
    Long updateItem(ItemDto itemDto);
}
