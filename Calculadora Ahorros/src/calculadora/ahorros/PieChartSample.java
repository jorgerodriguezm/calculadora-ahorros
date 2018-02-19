package calculadora.ahorros;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
 
public class PieChartSample extends Application {
    
    @Override public void start(Stage stage) {
        ConectorDB DB = new ConectorDB();
        DB.connect();
        Scene scene = new Scene(new Group());
        stage.setTitle("Gastos");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Comida", DB.obtenerSumaGastos(1)),
                new PieChart.Data("Transporte", DB.obtenerSumaGastos(2)),
                new PieChart.Data("Educación", DB.obtenerSumaGastos(3)),
                new PieChart.Data("Hogar", DB.obtenerSumaGastos(4)),
                new PieChart.Data("Familia", DB.obtenerSumaGastos(5)),
                new PieChart.Data("Entretenimiento", DB.obtenerSumaGastos(6)),
                new PieChart.Data("Otros Gastos", DB.obtenerSumaGastos(7)));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Gastos Distribuidos");
        
//        chart.setLabelLineLength(10);
//        chart.setLegendSide(Side.LEFT);

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        
        launch(args);
    }
}