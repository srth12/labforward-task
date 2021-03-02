package com.labforward.task.model;

import com.labforward.task.dto.ItemDto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="item")
public class ItemModel {
    private @Id @GeneratedValue Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private CategoryModel category;

    @OneToMany(mappedBy="item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AttributeValueModel> attributeValues;

    public ItemModel() {}

    public ItemModel(Long id, String name) {
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

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel categoryModel) {
        this.category = categoryModel;
    }

    public List<AttributeValueModel> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValueModel> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public ItemDto toDto(Boolean mapCategory, Boolean mapAttributeValues) {
        ItemDto itemDto = new ItemDto(id,name);
        if(mapCategory) itemDto.setCategory(category.toDto(true,false));
        if(mapAttributeValues) itemDto.setAttributeValues(attributeValues.stream().map(av -> av.toDto(true)).collect(Collectors.toList()));

        return itemDto;
    }
}
