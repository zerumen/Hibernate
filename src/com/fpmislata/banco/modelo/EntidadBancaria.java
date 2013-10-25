/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancaria implements Serializable {
    
    private int idEntidadBancaria;
    private String codigoEntidad;
    private String nombre;
    private String cif;
    private TipoentidadBancaria entidad;

  
    private List<Sucursal> sucursalesBancarias=new ArrayList<>();
    
    public EntidadBancaria(int idEntidad,String codigoEntidad,String nombre,String cif, TipoentidadBancaria entidad){
        this.idEntidadBancaria=idEntidad;
        this.codigoEntidad=codigoEntidad;
        this.nombre=nombre;
        this.cif=cif;
        this.entidad=entidad;
        
    }
    
    public EntidadBancaria(){
        
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public TipoentidadBancaria getEntidad() {
        return entidad;
    }

    public void setEntidad(TipoentidadBancaria entidad) {
        this.entidad = entidad;
    }
    
      public List<Sucursal> getSucursalesBancarias() {
        return sucursalesBancarias;
    }

    public void setSucursalesBancarias(List<Sucursal> sucursalesBancarias) {
        this.sucursalesBancarias = sucursalesBancarias;
    }
   
   
}
