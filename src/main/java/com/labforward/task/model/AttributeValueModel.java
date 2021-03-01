package com.labforward.task.model;

import com.labforward.task.dto.AttributeValueDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="attribute_value")
public class AttributeValueModel {
    private @Id @GeneratedValue Long id;

    private String value;

    @ManyToOne
    @JoinColumn(name="attribute_id")
    private AttributeModel attribute;

    @ManyToOne
    @JoinColumn(name="item_id")
    private ItemModel item;

    public AttributeValueModel() {}

    public AttributeValueModel(Long id, String value) {
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

    public AttributeModel getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeModel attribute) {
        this.attribute = attribute;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public AttributeValueDto toDto(Boolean mapAttribute) {
        AttributeValueDto attributeValueDto = new AttributeValueDto(id,value);
        if(mapAttribute && Objects.nonNull(attribute)) attributeValueDto.setAttribute(attribute.toDto());

        return attributeValueDto;
    }
}
