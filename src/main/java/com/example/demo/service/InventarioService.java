package com.example.demo.service;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Inventario;

@Service
public interface InventarioService {
    
    public Iterable<Inventario> findAll();
    public Optional<Inventario> findById(Long Id);
    public Inventario save(Inventario inventario);
    public void delete(Long id);
    public List<Inventario> findDefectuoso(boolean defectuoso);
    
}
