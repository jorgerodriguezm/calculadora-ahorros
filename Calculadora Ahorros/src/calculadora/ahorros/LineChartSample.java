package calculadora.ahorros;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
 
public class LineChartSample extends Application {
 
    @Override public void start(Stage stage) {
        JFrame frame = new JFrame("Años");
        int años = Integer.valueOf(JOptionPane.showInputDialog(frame, "¿Cuántos años deseas visualizar?"));
        ConectorDB DB = new ConectorDB();
        DB.connect();
        stage.setTitle("Proyección");
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mes");
        yAxis.setLabel("Ahorro Proyectado");
        //creating the chart
        final LineChart<String,Number> lineChart = 
                new LineChart<>(xAxis,yAxis);
                
        lineChart.setTitle("Proyección Mensual");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Ahorro Proyectado");
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Ahorro Máximo");
        
        Calendar cal = Calendar.getInstance();
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int año = cal.get(Calendar.YEAR);
        ArrayList<String> meses = new ArrayList<>();
        for (int i=año; i<=año+años; i++){
            meses.add(dia+"/Ene/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Feb/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Mar/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Abr/"+String.valueOf(i).substring(2));
            meses.add(dia+"/May/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Jun/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Jul/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Ago/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Sep/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Oct/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Nov/"+String.valueOf(i).substring(2));
            meses.add(dia+"/Dic/"+String.valueOf(i).substring(2));
        }
        
        //populating the series with data
        double ingresos = DB.obtenerSueldo()+DB.obtenerOtros();
        double gastos = DB.obtenerTotalGastos();
        double diferencia = ingresos - gastos;
        int j=0;
        for (int i=mes; i<=mes+12*años; i++){
            series.getData().add(new XYChart.Data(meses.get(i), DB.obtenerAhorros()+diferencia*j));
            j++;
        }
        j=0;
        for (int i=mes; i<=mes+6*años; i++){
            series2.getData().add(new XYChart.Data(meses.get(i), DB.obtenerAhorros()+ingresos*j));
            j++;
        }
                
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series, series2);
       
        
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

        private Label createDataThresholdLabel(int priorValue, int value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }