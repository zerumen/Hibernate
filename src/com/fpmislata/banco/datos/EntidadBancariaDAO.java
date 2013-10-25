/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.modelo.EntidadBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaDAO  extends GenericDAO<EntidadBancaria, Integer>{
    

    List<EntidadBancaria> findByCodigo(String codigo) throws  Exception;
    List<EntidadBancaria> findByNombre(String nombre) throws  Exception;
}
