package com.david.service;

import com.david.domain.Girl;
import com.david.enums.ResultEnum;
import com.david.exception.GirlException;
import com.david.reponsitory.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by zhanghewei on 17/9/5.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 数据库事物操作
     */
    @Transactional
    public void inserTwo() {

        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public Girl getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age  < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOl);
        }else if(age > 10 && age < 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOl);
        }
        return girl;
    }

    /**
     * 通过id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
