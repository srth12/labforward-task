package com.labforward.task.controller;

import com.labforward.task.dto.CategoryDto;
import com.labforward.task.dto.ItemDto;
import com.labforward.task.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public Long createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @PostMapping("/createItem")
    public Long createItem(@RequestBody ItemDto itemDto) {
        return categoryService.createItem(itemDto);
    }

    @PutMapping("/updateItem")
    public Long updateItem(@RequestBody ItemDto itemDto) {
        return categoryService.updateItem(itemDto);
    }

    @GetMapping("/itemsByCategory/{categoryId}")
    public List<ItemDto> findItemsByCategory(@PathVariable Long categoryId) {
        return categoryService.findItemsByCategory(categoryId);
    }
}
