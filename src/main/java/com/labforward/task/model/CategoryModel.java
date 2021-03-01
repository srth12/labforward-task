package com.labforward.task.model;

import com.labforward.task.dto.CategoryDto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="category")
public class CategoryModel {
    private @Id @GeneratedValue Long id;

    private String name;

    @OneToMany(mappedBy="category", cascade={CascadeType.ALL})
    private List<AttributeModel> attributes;

    @OneToMany(mappedBy = "category")
    private List<ItemModel> items;

    public CategoryModel(){}

    public CategoryModel(Long id, String name) {
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

    public List<AttributeModel> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeModel> attributes) {
        this.attributes = attributes;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public CategoryDto toDto(Boolean mapAttributes, Boolean mapItems){
        CategoryDto categoryDto = new CategoryDto(id,name);
        if(mapAttributes) categoryDto.setAttributes(attributes.stream().map(a -> a.toDto()).collect(Collectors.toList()));
        if(mapItems) categoryDto.setItems(items.stream().map(i -> i.toDto(false,false)).collect(Collectors.toList()));

        return categoryDto;
    }

}
