package com.david.controller;

import com.david.domain.Girl;
import com.david.domain.Result;
import com.david.enums.ResultEnum;
import com.david.reponsitory.GirlRepository;
import com.david.service.GirlService;
import com.david.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhanghewei on 17/9/4.
 */
@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }


    /**
     * 插入一条数据
     *
     * @return Valid : 表单验证
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
           return ResultUtils.error(ResultEnum.ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }else{
           return ResultUtils.success(girlRepository.save(girl));
        }
    }

    /**
     * 通过id 查询一个女生
     *
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 通过age 查询一个女生
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 更新一条记录
     *
     * @param id
     * @param cupSize
     * @param age
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateOne(@PathVariable("id") Integer id,
                          @RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除一条记录
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteOne(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @Autowired
    private GirlService girlService;

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.inserTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public Girl getAge(@PathVariable("id") Integer id) throws Exception {
        return girlService.getAge(id);
    }
}
