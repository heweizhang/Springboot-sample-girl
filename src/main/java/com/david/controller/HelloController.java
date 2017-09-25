package com.david.controller;

import com.david.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhanghewei on 17/9/2.
 */
@RestController
public class HelloController {

   /* @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;*/

   @Autowired
   private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello","/h"}, method = RequestMethod.GET)
    public String say() {
//        return cupSize + "  age:" + age;
//        return content;
//        return girlProperties.getCupSize();
        return "index";
    }


}
