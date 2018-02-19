/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.ahorros;

/**
 *
 * @author Jorge
 */
public class Registro {
    //Atributos
    private int cod;
    private String descripcion;
    private double monto;
    private String tipo;
    private String frecuencia;  
    //Cosntructor
    public Registro(int cod, String descripcion, String tipo, String frecuencia, double monto) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.frecuencia = frecuencia;
        this.monto = monto;
    }

    //Getter and setters
    public int getCod() {
        return cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

}
