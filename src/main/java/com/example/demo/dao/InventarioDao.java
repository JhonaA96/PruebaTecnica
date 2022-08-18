package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Inventario;

@Repository
public interface InventarioDao extends JpaRepository<Inventario, Long> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM public.inventarios i where i.defectuoso = 1?")
    List<Inventario> findDefectuoso(boolean defectuoso);
}
