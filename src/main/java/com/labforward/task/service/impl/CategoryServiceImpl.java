package com.labforward.task.service.impl;

import com.labforward.task.dto.CategoryDto;
import com.labforward.task.dto.ItemDto;
import com.labforward.task.exception.CategoryNotFoundException;
import com.labforward.task.model.CategoryModel;
import com.labforward.task.model.ItemModel;
import com.labforward.task.repository.CategoryRepository;
import com.labforward.task.repository.ItemRepository;
import com.labforward.task.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDto> findItemsByCategory(Long categoryId) {
        CategoryModel categoryModel = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
        return categoryModel.getItems().stream().map(im -> im.toDto(true,true)).collect(Collectors.toList());
    }

    public Long createCategory(CategoryDto categoryDto) {
        CategoryModel categoryModel = categoryDto.toModel(true,true);
        categoryModel.getAttributes().forEach(a -> a.setCategory(categoryModel));
        return categoryRepository.save(categoryModel).getId();
    }

    public Long createItem(ItemDto itemDto) {
        ItemModel itemModel = itemDto.toModel(true,true);
        itemModel.getAttributeValues().forEach(av -> av.setItem(itemModel));
        return itemRepository.save(itemModel).getId();
    }

    public Long updateItem(ItemDto itemDto) {
        ItemModel itemModel = itemDto.toModel(true,true);
        itemModel.getAttributeValues().forEach(av -> av.setItem(itemModel));
        return itemRepository.save(itemModel).getId();
    }
}
