package tsp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vazq
 */
public class grafica {

    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX, ejeY, titulo;

    public grafica(String ejeX, String ejeY, String titulo) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.titulo = titulo;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    public void agregrarSerie(int[] datos, String id) {
        //crear la serie
        XYSeries serie = new XYSeries(id);
        for (int x = 0; x < datos.length; x++) {
            serie.add(x, datos[x]);
        }
        this.series.addSeries(serie);
    }

    public void creaYmuestraGrafica() {
        this.grafica = ChartFactory.createXYLineChart(titulo, 
                                                      ejeX, ejeY, series);
        ChartFrame panel = new ChartFrame(titulo, grafica);
        panel.pack();
        panel.setVisible(true);
    }

}
