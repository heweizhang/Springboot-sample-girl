package com.david.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

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

    @Min(value = 18 ,message = "年龄小于18")
    private Integer age;


    public Girl() {
    }

}
