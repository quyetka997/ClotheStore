package com.nnstore.dto;

import com.nnstore.entity.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private Long id;

    private String name;

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
}
