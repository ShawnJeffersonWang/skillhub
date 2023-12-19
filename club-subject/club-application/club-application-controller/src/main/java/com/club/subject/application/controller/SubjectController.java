package com.club.subject.application.controller;

import com.club.subject.infra.basic.entity.SubjectCategory;
import com.club.subject.infra.basic.service.SubjectCategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 刷题controller
 *
 * @author: Shawn
 * @date: 2023/12/9
 */
@RestController
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    // 注意这里不要少/
    @GetMapping("/test")
    public String test() {
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        return subjectCategory.getCategoryName();
    }
}
