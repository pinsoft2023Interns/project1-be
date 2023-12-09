package com.pinsoft.project1.be.controller;

import com.pinsoft.project1.be.entity.Kategori;
import com.pinsoft.project1.be.servis.KategoriServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KategoriController {

    @Autowired
    KategoriServis kategoriServis;

    public List<Kategori> list(){
        return kategoriServis.list();
    }


}
