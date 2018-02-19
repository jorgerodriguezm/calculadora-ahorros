package calculadora.ahorros;

/**
 *
 * @author Jorge
 */
import static java.lang.Integer.parseInt;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
 
public class Tabla extends Application {
    
            
    ConectorDB DB = new ConectorDB();
    
    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        
        DB.connect();
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(540);
        stage.setHeight(540);
 
        final Label label = new Label("Gastos");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        //Columna #1
        TableColumn <Registro,Integer> numCol = new TableColumn("#");
        numCol.setMinWidth(100);
        numCol.setCellValueFactory(new PropertyValueFactory <>("cod"));
        //Columna #2
        TableColumn <Registro, String> descripcionCol = new TableColumn("Descripción");
        descripcionCol.setMinWidth(100);
        descripcionCol.setCellValueFactory(new PropertyValueFactory <>("descripcion"));
       //Columna #3
        TableColumn <Registro,Double> montoCol = new TableColumn("Monto");
        montoCol.setMinWidth(100);
        montoCol.setCellValueFactory(new PropertyValueFactory <>("monto"));
        //Columna #4
        TableColumn <Registro,String> tipoCol = new TableColumn("Tipo");
        tipoCol.setMinWidth(100);
        tipoCol.setCellValueFactory(new PropertyValueFactory <>("tipo"));
        //Columna #5
        TableColumn <Registro,String> frecuenciaCol = new TableColumn("Frecuencia");
        frecuenciaCol.setMinWidth(100);
        frecuenciaCol.setCellValueFactory(new PropertyValueFactory <>("frecuencia"));
        
        //Boton
        Button borrar = new Button ("Borrar");
        //Accion de boton de borrar
        borrar.setOnAction(e -> BotonBorrarClick());
        
        //Cajas de botones
        //Inicializando caja de botones
        HBox cajabotones = new HBox();
        cajabotones.setPadding(new Insets(10,10,10,442));
        cajabotones.setSpacing(10);
        //Agregando campos a la caja
        cajabotones.getChildren().addAll(borrar);
        
        //Inicializar tabla
        table = new TableView<>();                
        table.getColumns().addAll(numCol, descripcionCol, tipoCol, frecuenciaCol, montoCol);
        table.setItems(getGastos());
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, table,cajabotones);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
    //Obtener todos los gastos a manera de arreglo
    @SuppressWarnings("empty-statement")
    public ObservableList <Registro>  getGastos(){
        ObservableList<Registro> listagastos = FXCollections.observableArrayList();
        
        ResultSet gastos = DB.obtenerGastos();
        int confirmacion = crearArchivo();
        System.out.println(confirmacion);
        try {
            if (confirmacion == 0){
                File ca = new File("D:\\Lista_de_Gastos.txt");;
                FileWriter fw = new FileWriter(ca, false);
                BufferedWriter bw = new BufferedWriter(fw);
            
                while (gastos.next()) {
                    int codigo = gastos.getInt("codigo");
                    String descripcion = gastos.getString("descripción");
                    String tipo = gastos.getString("tipodesc");
                    String frecuencia = gastos.getString("frecuenciadesc");
                    double monto = gastos.getDouble("monto");
                    
                    listagastos.add(new Registro(codigo,descripcion,tipo,frecuencia,monto));
                    
                    bw.write("#: " + codigo);
                    bw.newLine();
                    bw.write("Descripción: " + descripcion);
                    bw.newLine();
                    bw.write("Tipo: " + tipo);
                    bw.newLine();
                    bw.write("Frecuenca: " + frecuencia);
                    bw.newLine();
                    bw.write("Monto: " + String.valueOf(monto));
                    bw.newLine();
                    
                }
                bw.flush();
                bw.close();
            } else {
                while (gastos.next()) {
                    int codigo = gastos.getInt("codigo");
                    String descripcion = gastos.getString("descripción");
                    String tipo = gastos.getString("tipodesc");
                    String frecuencia = gastos.getString("frecuenciadesc");
                    double monto = gastos.getDouble("monto");
                    
                    listagastos.add(new Registro(codigo,descripcion,tipo,frecuencia,monto));
                }
            }
            } catch (Exception ex ) {
                    Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
             }

        return listagastos;
    }
    
    public void BotonBorrarClick(){
        DB.connect();
        //Para borrar un gasto seleccionado
        ObservableList<Registro> gastoElegido;
        ObservableList<Registro> todosLosGastos;
        todosLosGastos = table.getItems();
        gastoElegido = table.getSelectionModel().getSelectedItems();
        //Obtenemos el # del gasto a borrar
        String selection = table.getSelectionModel().getSelectedCells().toString();
        int coma = selection.indexOf(',');
        int index = parseInt(selection.substring(22, coma));
        //System.out.println(index);
        //Borrado de gasto escogido por usuario de todos los gastos mostrados en tabla
        gastoElegido.forEach(todosLosGastos::remove);
        
        //Borrado del gasto en la base de datos
        try {
            DB.eliminarGasto(index);
        } catch (SQLException ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int crearArchivo(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea crear un archivo de texto?", "Creación de archivo txt", dialogButton);
        return dialogResult;
    }
}