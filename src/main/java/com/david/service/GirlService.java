package com.david.service;

import com.david.domain.Girl;
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
}
