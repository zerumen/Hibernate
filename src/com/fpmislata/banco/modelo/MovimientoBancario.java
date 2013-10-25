/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class MovimientoBancario {
    
    private int idMovimientoBancario;
    private TipoMovimientoBancario movimiento;
    private BigDecimal importe;
    private Date fecha;
    private BigDecimal saldo;
    private String concepto;
    private CuentaBancaria cuentaBancaria;

    public MovimientoBancario(int idMovimientoBancario, TipoMovimientoBancario movimiento, BigDecimal importe, Date fecha, BigDecimal saldo, String concepto, CuentaBancaria cuentaBancaria) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.movimiento = movimiento;
        this.importe = importe;
        this.fecha = fecha;
        this.saldo = saldo;
        this.concepto = concepto;
        this.cuentaBancaria=cuentaBancaria;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public MovimientoBancario() {
    }

    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public TipoMovimientoBancario getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(TipoMovimientoBancario movimiento) {
        this.movimiento = movimiento;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    
    
}
