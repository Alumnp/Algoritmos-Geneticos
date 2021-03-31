package reinas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vazqu
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;

import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

public class Graficacion {

    public static void Grafica() throws Exception {
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("8 Reinas", new double[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {0, 0, 2, 0, 0, 2, 0, 0, 2, 2}});

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2));

        JFreeChart chart = ChartFactory.createXYLineChart("Grafica de fitnnes", "Genotipo", "fitness", dataset);
        chart.getXYPlot().getRangeAxis().setRange(0, 8);
        ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#''"));
        chart.getXYPlot().setRenderer(renderer);

        BufferedImage image = chart.createBufferedImage(600, 400);
        ImageIO.write(image, "png", new File("Reinas.png"));
    }
}
