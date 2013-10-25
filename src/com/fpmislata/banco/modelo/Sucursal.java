/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Sucursal {
    
    private int idSucursalBancaria;
    private String codigoSucursal;
    private String nombre;
    private EntidadBancaria entidadBancaria;
    private List<CuentaBancaria> cuentasBan=new ArrayList<>();

  

    public Sucursal(int idSucursalBancaria, String codigoSucursal, String nombre, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.codigoSucursal = codigoSucursal;
        this.nombre = nombre;
        this.entidadBancaria = entidadBancaria;
    }

    public Sucursal() {
        
    }


    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }
      public List<CuentaBancaria> getCuentasBan() {
        return cuentasBan;
    }

    public void setCuentasBan(List<CuentaBancaria> cuentasBan) {
        this.cuentasBan = cuentasBan;
    }


    
    
    
    
}
