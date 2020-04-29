package com.linelong.item.service;

import com.linelong.item.mapper.CategoryMapper;
import com.linelong.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父类目的pid查询子类目
     * @param pid
     * @return
     */
    public List<Category> queryCategoriesByPid(Long pid){
        Category category = new Category();
        category.setParentId(pid);
        return categoryMapper.select(category);
    }
}
