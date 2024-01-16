package com.club.subject.application.controller;

import com.alibaba.fastjson2.JSON;
import com.club.subject.application.convert.SubjectAnswerDTOConverter;
import com.club.subject.application.convert.SubjectInfoDTOConverter;
import com.club.subject.application.dto.SubjectInfoDTO;
import com.club.subject.common.entity.PageResult;
import com.club.subject.common.entity.Result;
import com.club.subject.domain.entity.SubjectAnswerBO;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.service.SubjectInfoDomainService;
import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 刷题controller
 *
 * @author: Shawn
 * @date: 2023/12/9
 */
@RestController
@Slf4j
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 新增题目
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),
                    "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),
                    "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),
                    "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds())
                    , "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds())
                    , "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS =
                    SubjectAnswerDTOConverter.INSTANCE.convertListDTOToBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectController.add.error{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }
    }

    /**
     * 查询题目列表
     */
//    @PostMapping("/getSubjectPage")
//    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
//        try {
//            if (log.isInfoEnabled()) {
//                log.info("SubjectController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
//            }
//
//            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(),
//                    "分类id不能为空");
//            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(),
//                    "标签id不能为空");
//
//            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
//            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
//            return Result.ok(boPageResult);
//        } catch (Exception e) {
//            log.error("SubjectController.getSubjectPage.error{}", e.getMessage(), e);
//            return Result.fail("新增题目失败");
//        }
//    }

    /**
     * 查询题目信息
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

            Preconditions.checkNotNull(subjectInfoDTO.getId(),
                    "题目id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(),
                    "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(),
                    "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            SubjectInfoBO boResult=subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO dto=SubjectInfoDTOConverter.INSTANCE.convertBOToDTO(boResult);
            return Result.ok(dto);
        } catch (Exception e) {
            log.error("SubjectController.querySubjectInfo.error{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }
    }
}
