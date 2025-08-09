package com.Sairam.demo.sairam.service;

import com.Sairam.demo.sairam.entity.Dmart;

import java.util.List;
import java.util.Optional;

public interface DmartService {
 public   Dmart saveDmart(Dmart dmart);

   public  List<Dmart> findAllDmart();


  public  Dmart getDmartFindById(Integer id);
}
