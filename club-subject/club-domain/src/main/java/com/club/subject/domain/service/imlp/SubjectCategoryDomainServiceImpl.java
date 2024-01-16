package com.club.subject.domain.service.imlp;

import com.alibaba.fastjson2.JSON;
import com.club.subject.common.enums.IsDeletedFlagEnum;
import com.club.subject.domain.convert.SubjectCategoryConverter;
import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.domain.service.SubjectCategoryDomainService;
import com.club.subject.infra.basic.entity.SubjectCategory;
import com.club.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryServiceBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryServiceBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryServiceBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

//    @Override
//    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
//        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
//                .convertBoToCategory(subjectCategoryBO);
//        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
//        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
//        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE
//                .convertBoToCategory(subjectCategoryList);
//        if (log.isInfoEnabled()) {
//            log.info("SubjectCategoryController.queryCategory.boList:{}",
//                    JSON.toJSONString(boList));
//        }
//        return boList;
//    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }
}
