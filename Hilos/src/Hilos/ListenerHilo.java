/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;

/**
 *
 * @author vazqu
 */
public class ListenerHilo implements ItemListener {

    private HilosJFrame panel;

    public ListenerHilo(HilosJFrame panel) {
        this.panel = panel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();

        switch (button.getText()) {
            case "Binario": {
                panel.getjLabelAux().setText("Numero de Bits");
                panel.getjPanel_Aux().setVisible(true);
                panel.setMenu(1);
                break;
            }
            case "N Reinas": {
                panel.getjLabelAux().setText("Tamaño de tablero");
                panel.getjPanel_Aux().setVisible(true);
                panel.setMenu(2);
                break;
            }
            case "TSP": {
                panel.getjLabelAux().setText("Ciudad inicial");
                panel.getjPanel_Aux().setVisible(true);
                panel.setMenu(3);
                break;
            }
            case "SAT": {
                panel.getjPanel_Aux().setVisible(false);
                panel.setMenu(4);
                break;
            }
        }

    }

}
