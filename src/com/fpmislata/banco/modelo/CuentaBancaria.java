/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class CuentaBancaria {
    
    private int idCuentaBancaria;
    private Sucursal sucursalBancaria;
    private String numeroCuenta;
    private String dc;
    private BigDecimal saldo;
    private String cif;
    private List<MovimientoBancario> movimientoBancario=new ArrayList<>();

    public CuentaBancaria(int idCuentaBancaria, Sucursal sucursalBancaria, String numeroCuenta, String dc, BigDecimal saldo, String cif) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.sucursalBancaria = sucursalBancaria;
        this.numeroCuenta = numeroCuenta;
        this.dc = dc;
        this.saldo = saldo;
        this.cif = cif;
    }
    
    public CuentaBancaria(){
        
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public Sucursal getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(Sucursal sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }


    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<MovimientoBancario> getMovimientoBancario() {
        return movimientoBancario;
    }

    public void setMovimientoBan(List<MovimientoBancario> movBan) {
        this.movimientoBancario = movimientoBancario;
    }
    
    
}
