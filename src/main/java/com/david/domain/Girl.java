package com.david.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by zhanghewei on 17/9/3.
 */


@Entity
@Data
public class Girl {

    @Id
    @GeneratedValue//自增
    private Integer id;

    private String cupSize;

    @Min(value = 18, message = "年龄小于18")
    @Max(value = 20, message = "年龄大于20")
    private Integer age;

    @NotNull(message = "金额不能为空")
    private Double money;


    public Girl() {
    }

}
