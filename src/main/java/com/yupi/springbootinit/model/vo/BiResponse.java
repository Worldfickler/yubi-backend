package com.yupi.springbootinit.model.vo;

import lombok.Data;

/**
 * Bi 的返回结果
 * @author Fickler
 * @date 2023/11/22 11:25
 */

@Data
public class BiResponse {

    private String genChart;

    private String genResult;

    /**
     * 新生成的图标id
     */
    private Long chartId;

}
