package com.jade.showcase.crawler.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jade.showcase.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MontherChangeLong extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String content;

}
