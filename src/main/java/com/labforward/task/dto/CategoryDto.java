package com.labforward.task.dto;

import com.labforward.task.model.CategoryModel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CategoryDto {
    private Long id;
    private String name;
    private List<AttributeDto> attributes;
    private List<ItemDto> items;

    public CategoryDto(){}

    public CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AttributeDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDto> attributes) {
        this.attributes = attributes;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public CategoryModel toModel(Boolean mapAttributes, Boolean mapItems) {
        CategoryModel categoryModel = new CategoryModel(id,name);
        if(mapAttributes && Objects.nonNull(attributes)) categoryModel.setAttributes(attributes.stream().map(a -> a.toModel()).collect(Collectors.toList()));
        if(mapItems && Objects.nonNull(items)) categoryModel.setItems(items.stream().map(i -> i.toModel(false,false)).collect(Collectors.toList()));

        return categoryModel;
    }
}
