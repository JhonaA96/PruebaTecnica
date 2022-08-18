package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="inventarios")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
	private String codigo;

    @Column
	private String descripcion;

    @Column
    private boolean defectuoso;

    @Column
    private Long cantidad;

    @Column(name = "fecha_registro")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaRegistro;

    public Inventario() {
    }

    public Inventario(String codigo, String descripcion, boolean defectuoso, Date fechaRegistro, Long cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.defectuoso = defectuoso;
        this.fechaRegistro = fechaRegistro;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDefectuoso() {
        return defectuoso;
    }

    public void setDefectuoso(boolean defectuoso) {
        this.defectuoso = defectuoso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
