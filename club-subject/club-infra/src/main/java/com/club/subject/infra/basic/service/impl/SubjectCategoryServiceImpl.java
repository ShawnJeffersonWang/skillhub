package com.club.subject.infra.basic.service.impl;

import com.club.subject.infra.basic.entity.SubjectCategory;
import com.club.subject.infra.basic.mapper.SubjectCategoryDao;
import com.club.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 题目分类表(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2023-12-17 18:13:59
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {

    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    @Override
    public SubjectCategory queryById(Long id) {
        return this.subjectCategoryDao.queryById(id);
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory update(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.update(subjectCategory);
        return this.queryById(subjectCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectCategoryDao.deleteById(id) > 0;
    }
}