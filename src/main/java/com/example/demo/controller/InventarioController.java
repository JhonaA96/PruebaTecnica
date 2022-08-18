package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Inventario;
import com.example.demo.service.InventarioService;


@RestController
@RequestMapping("/inventario")
@CrossOrigin("*")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/all")
    public List<Inventario> getAll(){
        List<Inventario> inventarios = StreamSupport.stream(inventarioService.findAll().spliterator(), false).collect(Collectors.toList());
        return inventarios;
    }
    
    @GetMapping("/inventario/{id}")
    public ResponseEntity <?> find(@PathVariable(value="id") Long inventarioId){
        Optional<Inventario> oInventario = inventarioService.findById(inventarioId);

        if(!oInventario.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oInventario);
        }
    }
    
    @PostMapping("/save")
    public ResponseEntity <?> save(@RequestBody Inventario inventario){
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.save(inventario));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <?> update(@PathVariable(value = "id") Long inventarioId, @RequestBody Inventario inventario){

        Optional<Inventario> oInventario = inventarioService.findById(inventarioId);
        if(!oInventario.isPresent()){
            return ResponseEntity.notFound().build();
        }

        oInventario.get().setCodigo(inventario.getCodigo());
        oInventario.get().setCantidad(inventario.getCantidad());
        oInventario.get().setDefectuoso(inventario.isDefectuoso());
        oInventario.get().setDescripcion(inventario.getDescripcion());
        oInventario.get().setFechaRegistro(inventario.getFechaRegistro());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(inventarioService.save(oInventario.get()));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> delete(@PathVariable(value = "id") Long inventarioId){
        Optional<Inventario> oInventario = inventarioService.findById(inventarioId);

        if(!oInventario.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oInventario);
        }
    }

    @GetMapping("/defectuoso/{defectuoso}")
    public ResponseEntity <?> findDefectuoso(@PathVariable(value="defectuoso") Boolean defectuoso){
        List<Inventario> inventarioDefectuoso = inventarioService.findDefectuoso(defectuoso);

        if(inventarioDefectuoso.size() == 0){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(inventarioDefectuoso);
        }
    }

}
