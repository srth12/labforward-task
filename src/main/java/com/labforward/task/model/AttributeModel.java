package com.labforward.task.model;

import com.labforward.task.dto.AttributeDto;

import javax.persistence.*;

@Entity
@Table(name="attribute")
public class AttributeModel {
    private @Id @GeneratedValue Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private CategoryModel category;

    public AttributeModel() {}

    public AttributeModel(Long id, String name) {
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

    public AttributeDto toDto() {
        return new AttributeDto(id,name);
    }
}
