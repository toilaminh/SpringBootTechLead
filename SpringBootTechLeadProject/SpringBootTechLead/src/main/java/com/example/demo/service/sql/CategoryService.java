package com.example.demo.service.sql;

import com.example.demo.model.dto.sql.level1.CategoryDto_Ex4_1;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryDto_Ex4_1> findAvgRentalDuration(){
        return categoryRepository.findAvgRentalDuration();
    }
}
