package com.labforward.task.repository;

import com.labforward.task.model.CategoryModel;
import com.labforward.task.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {
}
