package com.labforward.task.dto;

import com.labforward.task.model.AttributeValueModel;

import java.util.Objects;

public class AttributeValueDto {
    private Long id;
    private String value;
    private AttributeDto attribute;

    public AttributeValueDto() {}

    public AttributeValueDto(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public AttributeDto getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeDto attribute) {
        this.attribute = attribute;
    }

    public AttributeValueModel toModel(Boolean mapAttribute) {
        AttributeValueModel attributeValueModel = new AttributeValueModel(id,value);
        if(mapAttribute && Objects.nonNull(attribute)) attributeValueModel.setAttribute(attribute.toModel());

        return attributeValueModel;
    }
}
