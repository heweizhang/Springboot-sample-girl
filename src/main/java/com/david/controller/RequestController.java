package com.david.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by zhanghewei on 17/9/3.
 */

@RestController
@RequestMapping("/request")
public class RequestController {

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/printParams", method = RequestMethod.GET)
    public String printParams(@RequestParam("id") Integer id) {
        return "id:" + id;
    }


    /**
     * url:http://127.0.0.1:8080/girl/request/printParams2?id=233
     * required = false ，允许传入空
     * defaultValue 默认值，字符类型
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/printParams2")
    public String printParams2(@RequestParam(value = "id", required = false, defaultValue = "101") Integer id) {
        return "id:" + id;
    }

    /**
     * http://127.0.0.1:8080/girl/request/printParams3/233
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/printParams3/{id}")
    public String pringParams3(@PathVariable(value = "id") Integer id) {
        return "id:" + id;
    }
}
