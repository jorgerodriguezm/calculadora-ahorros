/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.ahorros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jorge
 */
public class ConectorDB {
    //Conexión
    String url = "D:\\RegistroGastos.db";
    Connection connect;
    //Método de conexión a DB
    public void connect(){
     try {
         connect = DriverManager.getConnection("jdbc:sqlite:"+url);
         if (connect!=null) {
             System.out.println("Conectado a la base de datos");
         }
     } catch (SQLException ex) {
         System.err.println("No se ha podido conectar a RegistroGastos.db\n"+ex.getMessage());
     }
    }
    public void close(){
            try {
                System.out.println("La conexion ha terminado");
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConectorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //Enviar gastos a base de datos
    public void enviarGastos(Gasto Gasto){
        try {
            PreparedStatement st = connect.prepareStatement("insert into RegistroGastosTabla (Descripción,Monto,Tipo,TipoDesc,Frecuencia,FrecuenciaDesc) values (?,?,?,?,?,?)");
            st.setString(1,Gasto.descripcion);
            st.setDouble(2,Gasto.monto);
            st.setInt(3,Gasto.tipo);
            st.setString(4,Gasto.tipoDesc);
            st.setInt(5,Gasto.frecuencia);
            st.setString(6,Gasto.frecuenciaDesc);
            st.execute();
            
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    public void eliminarGasto(int rowid) throws SQLException{
        PreparedStatement st = connect.prepareStatement("delete from RegistroGastosTabla where codigo = ? +1");
        st.setString(1,String.valueOf(rowid));
        st.execute();
    }
    public void actualizarSueldo(double sueldo) throws SQLException{
        PreparedStatement st = connect.prepareStatement("update IngresosTabla set monto = ? where codigo = 1");
        st.setDouble(1,sueldo);
        st.execute();
    }
    public void actualizarOtros(double otros) throws SQLException{
        PreparedStatement st = connect.prepareStatement("update IngresosTabla set monto = ? where codigo = 2");
        st.setDouble(1,otros);
        st.execute();
    }
    public void actualizarAhorros(double ahorros) throws SQLException{
        PreparedStatement st = connect.prepareStatement("update IngresosTabla set monto = ? where codigo = 3");
        st.setDouble(1,ahorros);
        st.execute();
    }
    public ResultSet obtenerGastos(){
        try {
            PreparedStatement st = connect.prepareStatement("select codigo,descripción,tipodesc,frecuenciadesc,monto from RegistroGastosTabla");
            ResultSet rs = st.executeQuery();
            return rs;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    public double obtenerSumaGastos(int tipo){
        try {
            PreparedStatement st = connect.prepareStatement("select sum(mensual) suma from RegistroGastosTabla where tipo = ?");
            st.setString(1,Integer.toString(tipo));
            ResultSet rs = st.executeQuery();
            double mensual = rs.getDouble("suma");
            return mensual;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    public double obtenerTotalGastos(){
        try {
            PreparedStatement st = connect.prepareStatement("select sum(mensual) suma from RegistroGastosTabla");
            ResultSet rs = st.executeQuery();
            double mensual = rs.getDouble("suma");
            return mensual;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    public double obtenerSueldo(){
        try {
            PreparedStatement st = connect.prepareStatement("select sum(monto) suma from IngresosTabla where codigo=1");
            ResultSet rs = st.executeQuery();
            double ingreso = rs.getDouble("suma");
            return ingreso;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    public double obtenerOtros(){
        try {
            PreparedStatement st = connect.prepareStatement("select sum(monto) suma from IngresosTabla where codigo=2");
            ResultSet rs = st.executeQuery();
            double ingreso = rs.getDouble("suma");
            return ingreso;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    public double obtenerAhorros(){
        try {
            PreparedStatement st = connect.prepareStatement("select sum(monto) suma from IngresosTabla where codigo=3");
            ResultSet rs = st.executeQuery();
            double ingreso = rs.getDouble("suma");
            return ingreso;
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }

}
