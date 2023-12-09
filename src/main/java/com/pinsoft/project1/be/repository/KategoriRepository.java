package com.pinsoft.project1.be.repository;

import com.pinsoft.project1.be.entity.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KategoriRepository extends JpaRepository<Kategori,Long> {

}
