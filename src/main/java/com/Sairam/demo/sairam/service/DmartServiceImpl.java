package com.Sairam.demo.sairam.service;

import com.Sairam.demo.sairam.entity.Dmart;
import com.Sairam.demo.sairam.repo.DmartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DmartServiceImpl implements DmartService {
    @Autowired
    DmartRepo dmartRepo;

    @Override
    public Dmart saveDmart(Dmart dmart) {
        return dmartRepo.save(dmart);
    }

    @Override
    public List<Dmart> findAllDmart() {
        return dmartRepo.findAll();
    }

    @Override
    public Dmart getDmartFindById(Integer id) {
       return dmartRepo.findById(id).get();
    }

}
