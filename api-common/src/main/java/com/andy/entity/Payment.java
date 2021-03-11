package com.andy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * payment
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String serial;

    private static final long serialVersionUID = 1L;
}