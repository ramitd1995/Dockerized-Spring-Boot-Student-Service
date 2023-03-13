package com.startbuild.microservice.buildservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api")
public class BasicMicroService {

    /**
     * http://localhost:8090/v1/api/addition/4/5
     * @param a
     * @param b
     * @return
     */
    @GetMapping("/addition/{a}/{b}")
    public int add(@PathVariable int a, @PathVariable int b)
    {
        System.out.println("Adding");
        return a+b;
    }

    /**
     * http://localhost:8090/v1/api/id?id=ramit
     * @param id
     * @return
     */
    @GetMapping("/id")
    public String getId(@RequestParam("id") String id) {

        return "ID: " + id;
    }


}
