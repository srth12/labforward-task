package com.labforward.task.dto;

import com.labforward.task.model.ItemModel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ItemDto {
    private Long id;
    private String name;
    private CategoryDto category;
    private List<AttributeValueDto> attributeValues;

    public ItemDto() {}

    public ItemDto(Long id, String name) {
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public List<AttributeValueDto> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValueDto> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public ItemModel toModel(Boolean mapCategory, Boolean mapAttributeValues) {
        ItemModel itemModel = new ItemModel(id,name);
        if(mapCategory && Objects.nonNull(category)) itemModel.setCategory(category.toModel(false,false));
        if(mapAttributeValues && Objects.nonNull(attributeValues)) itemModel.setAttributeValues(attributeValues.stream().map(av -> av.toModel(true)).collect(Collectors.toList()));

        return itemModel;
    }
}
