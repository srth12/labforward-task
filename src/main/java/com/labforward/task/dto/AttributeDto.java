package com.labforward.task.dto;

import com.labforward.task.model.AttributeModel;

public class AttributeDto {
    private Long id;
    private String name;

    public AttributeDto() {}

    public AttributeDto(Long id, String name) {
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

    public AttributeModel toModel() {
        return new AttributeModel(id,name);
    }
}
