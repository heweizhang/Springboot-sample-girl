package com.david;

import com.david.domain.Girl;
import com.david.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhanghewei on 17/10/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    /**
     * service 单元测试
     */
    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(48);
        Assert.assertEquals(new Integer(14),girl.getAge());
    }
}
