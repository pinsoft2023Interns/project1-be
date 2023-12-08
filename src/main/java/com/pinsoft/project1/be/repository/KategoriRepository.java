package com.pinsoft.project1.be.repository;

import com.pinsoft.project1.be.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface KategoriRepository extends JpaRepository<Kategori,Long> {
}
