package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.InventarioDao;
import com.example.demo.model.Inventario;

@Service
public class InventarioServiceImpl implements InventarioService{

    @Autowired
    private InventarioDao inventarioDao;

    @Override
    public Iterable<Inventario> findAll(){
        return inventarioDao.findAll();
    }
    
    @Override
    public Optional<Inventario> findById(Long id){
        return inventarioDao.findById(id);
    }

    @Override
    public Inventario save(Inventario inventario){
        return inventarioDao.save(inventario);
    }

    @Override
    public void delete(Long id){
        inventarioDao.deleteById(id);
    }

    @Override
    public List<Inventario> findDefectuoso(boolean defectuoso){
        
        return inventarioDao.findDefectuoso(defectuoso);
    }
}
