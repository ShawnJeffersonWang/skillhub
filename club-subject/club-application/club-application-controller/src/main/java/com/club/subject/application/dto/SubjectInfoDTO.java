package com.club.subject.application.dto;

import com.club.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目dto
 *
 * @author makejava
 * @since 2023-10-05 21:28:57
 */
@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目难度
     */
    private Integer subjectDifficult;

    /**
     * 出题人名
     */
    private String settleName;

    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;

    /**
     * 题目分数
     */
    private Integer subjectScore;

    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 分类id
     */
    private List<Integer> categoryIds;

    /**
     * 分类id
     */
    private List<Integer> labelIds;

    /**
     * 答案选项
     */
    private List<SubjectAnswerDTO> optionList;

    private Long categoryId;

    private Long labelId;
}

