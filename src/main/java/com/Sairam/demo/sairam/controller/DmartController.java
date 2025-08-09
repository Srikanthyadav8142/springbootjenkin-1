package com.Sairam.demo.sairam.controller;

import com.Sairam.demo.sairam.entity.Dmart;
import com.Sairam.demo.sairam.service.DmartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DmartController {
    @Autowired
    DmartService dmartService;
    @PostMapping("/d")
    public Dmart saveDmart(@RequestBody Dmart dmart){
        return dmartService.saveDmart(dmart);
    }
    @GetMapping("/get")
    public List<Dmart> findAllDmart(){
        return dmartService.findAllDmart();
    }
    @GetMapping("/get/{id}")
    public Dmart getDmartFindById(@PathVariable ("id") Integer id){
      return  dmartService.getDmartFindById(id);
    }
}
