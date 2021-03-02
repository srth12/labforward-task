package com.labforward.task.controller;

import com.labforward.task.dto.CategoryDto;
import com.labforward.task.dto.ItemDto;
import com.labforward.task.dto.ResponseObject;
import com.labforward.task.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public ResponseEntity<ResponseObject> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<ResponseObject>(new ResponseObject("Sucessful",200,categoryService.createCategory(categoryDto)), HttpStatus.OK);
    }

    @PostMapping("/createItem")
    public ResponseEntity<ResponseObject> createItem(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<ResponseObject>(new ResponseObject("Sucessful",200,categoryService.createItem(itemDto)), HttpStatus.OK);
    }

    @PutMapping("/updateItem")
    public ResponseEntity<ResponseObject> updateItem(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<ResponseObject>(new ResponseObject("Sucessful",200,categoryService.updateItem(itemDto)), HttpStatus.OK);
    }

    @GetMapping("/itemsByCategory/{categoryId}")
    public ResponseEntity<ResponseObject> findItemsByCategory(@PathVariable Long categoryId) {
        return new ResponseEntity<ResponseObject>(new ResponseObject("Sucessful",200,categoryService.findItemsByCategory(categoryId)), HttpStatus.OK);
    }
}
