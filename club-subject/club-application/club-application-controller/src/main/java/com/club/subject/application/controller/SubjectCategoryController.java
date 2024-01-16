package com.club.subject.application.controller;


import com.alibaba.fastjson2.JSON;
import com.club.subject.application.convert.SubjectCategoryDTOConverter;
import com.club.subject.application.dto.SubjectCategoryDTO;
import com.club.subject.common.entity.Result;
import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.domain.service.SubjectCategoryDomainService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//快速写注解

/**
 * 刷题分类Controller
 *
 * @author: shawn
 * @date: 2023/12/19
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }


//    @PostMapping("/queryPrimaryCategory")
//    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
//        try {
//            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
//                    convertDtoToCategoryBO(subjectCategoryDTO);
//            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
//            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
//                    convertBoToCategoryDTOList(subjectCategoryBOList);
//            return Result.ok(subjectCategoryDTOList);
//        } catch (Exception e) {
//            log.error("SubjectCategoryController.queryPrimaryCategory.error{}", e.getMessage(), e);
//            return Result.fail("查询失败");
//        }
//    }

//    @PostMapping("/queryCategoryByPrimary")
//    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
//        try {
//            if (log.isInfoEnabled()) {
//                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}"
//                        , JSON.toJSONString(subjectCategoryDTO));
//            }
//            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类id不能为空");
//            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
//                    convertDtoToCategoryBO(subjectCategoryDTO);
//            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
//            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
//                    convertBoToCategoryDTOList(subjectCategoryBOList);
//            return Result.ok(subjectCategoryDTOList);
//        } catch (Exception e) {
//            log.error("SubjectCategoryController.queryCategoryByPrimary.error{}", e.getMessage(), e);
//            return Result.fail("查询失败");
//        }
//    }

    /**
     * 更新分类
     */
    @PostMapping("/update")
    public Result<Boolean> update(SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.error{}", e.getMessage(), e);
            return Result.fail("更新分类失败");
        }
    }

    /**
     * 删除分类
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error{}", e.getMessage(), e);
            return Result.fail("删除分类失败");
        }
    }
}