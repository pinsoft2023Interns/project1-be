package com.pinsoft.project1.be.servis;

import com.pinsoft.project1.be.entity.Kategori;
import com.pinsoft.project1.be.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriServis {

    @Autowired
    KategoriRepository kategoriRepository;
    public List<Kategori> list() {
        return kategoriRepository.findAll();
    }
}
