package com.jade.showcase.eat.ybb.entity;

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
 * @since 2019-03-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class YbbMontherChange extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String content;

    private String phyChange;

    private String symChange;

    private String psyChange;

    private String prmChange;

    private String bodyChange;

    private String momArticle;

    private Integer id ;


}
