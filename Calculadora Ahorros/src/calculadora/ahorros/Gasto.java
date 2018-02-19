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
public class Gasto extends RegistroGastos{

    public Gasto(String desc, double mon, int tip, String tipDesc, int fre, String freDesc) {
        this.descripcion = desc;
        this.monto = mon;
        this.tipo = tip;
        this.tipoDesc = tipDesc;
        this.frecuencia = fre;
        this.frecuenciaDesc = freDesc;
    }    
    
}
