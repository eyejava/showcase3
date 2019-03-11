package com.jade.showcase.eat.eat.entity;

import com.jade.showcase.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jade
 * @since 2019-03-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CanEat extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String catTitle;

    private String cat;

    private String title;

    private String alias;

    private String keyInfo;

    private String proposalTitle;

    private Integer canUse;

    private String content;

    private String babyStage;

    private String cfKey;

    private String cfProposalTitle;

    private Integer cfCanUse;

    private String cfContent;

    private String cfBabyStage;

    private String brqKey;

    private String brqProposalTitle;

    private Integer brqCanUse;

    private String brqContent;

    private String brqBabyStage;


    private String bbKey;

    private String bbProposalTitle;

    private Integer bbCanUse;

    private String bbContent;

    private String bbBabyStage;


    private String features;

    private String buyTips;

    private String useTips;

    private String picUrl;

    private Integer id ;


}
