package com.linelong.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linelong.item.mapper.BrandMapper;
import com.linelong.item.pojo.Brand;
import com.lzx.common.pojo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;


    /**
     * 分页查询品牌
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        //初始化Example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        //添加模糊查询
        if(StringUtils.isNotBlank(key)){
            criteria.andLike("name","%"+key+"%").orEqualTo("letter",key);
        }
        //添加分页  page是页码
        PageHelper.startPage(page,rows);
        //添加排序
        if(StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause(sortBy+(desc ?" desc":" asc"));
        }

        List<Brand> brands = brandMapper.selectByExample(example);

        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);


        return new PageResult<>(brandPageInfo.getTotal(),brandPageInfo.getList());
    }
}
