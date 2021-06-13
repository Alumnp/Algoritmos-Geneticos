/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import herramientas.Grafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HilosJFrame extends javax.swing.JFrame 
{        
    private int Menu;
    
    
    public HilosJFrame() 
    {
        initComponents();
               
        buttonGroup1.add(jRadioButton_BI);
        buttonGroup1.add(TSP);
        buttonGroup1.add(jRadioButton_NR);
        buttonGroup1.add(jRadioButton_BO);
        
        jRadioButton_BI.addItemListener(new ListenerHilo(this));
        TSP.addItemListener(new ListenerHilo(this));
        jRadioButton_NR.addItemListener(new ListenerHilo(this));
        jRadioButton_BO.addItemListener(new ListenerHilo(this));
        
        jRadioButton_BI.setSelected(true);
        //pruebaGrafica();
        
        this.jButtonIniciar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                activarHilo();
            }
        });
    }
    
    public void activarHilo()
    {
        switch (getMenu())
        {
            case 1:
            {
                HiloBinario h = new HiloBinario(this);
                h.start();
                break;
            }
            case 2:
            {
                HiloNReinas h = new HiloNReinas(this);
                h.start();
                break;
            }
            case 3:
            {
                HiloTSP h = new HiloTSP(this);
                h.start();
                break;
            }
            case 4:
            {
                HiloSAT h = new HiloSAT(this);
                h.start();
                break;
            }
        }
    }
    
    public void pruebaGrafica()
    {
        int datops[] = new int[10];
        
        for(int x = 0; x < 10; x++)
        {
            datops[x] = x; 
        }
        
        Grafica grafica = new Grafica("Generacion","Fitness","Algoritmo Genetico");
        grafica.agregarSerie("Generaciones", datops);
        grafica.crearGrafica();
    }
    
    public void actualizarGrafica(ArrayList<Integer> datops)
    {
        Grafica grafica = new Grafica("Generacion","Fitness","Algoritmo Genetico");
        grafica.agregarSerie("Generaciones", datops);
        grafica.crearGrafica();
        grafica.muestraGrafica();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton_BI = new javax.swing.JRadioButton();
        jRadioButton_NR = new javax.swing.JRadioButton();
        TSP = new javax.swing.JRadioButton();
        jRadioButton_BO = new javax.swing.JRadioButton();
        jPanel_Aux = new javax.swing.JPanel();
        jLabelAux = new javax.swing.JLabel();
        jSpinnerAux = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerTP = new javax.swing.JSpinner();
        jSpinnerNG = new javax.swing.JSpinner();
        jSpinnerPM = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jButtonIniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jRadioButton_BI.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jRadioButton_BI.setText("Binario");

        jRadioButton_NR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jRadioButton_NR.setText("N Reinas");

        TSP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TSP.setText("TSP");

        jRadioButton_BO.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jRadioButton_BO.setText("SAT");

        jLabelAux.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelAux.setText("Tamaño Poblacion");

        jSpinnerAux.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel_AuxLayout = new javax.swing.GroupLayout(jPanel_Aux);
        jPanel_Aux.setLayout(jPanel_AuxLayout);
        jPanel_AuxLayout.setHorizontalGroup(
            jPanel_AuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AuxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAux)
                .addGap(18, 18, 18)
                .addComponent(jSpinnerAux, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_AuxLayout.setVerticalGroup(
            jPanel_AuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AuxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_AuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAux)
                    .addComponent(jSpinnerAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton_BO, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton_BI, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton_NR, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TSP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addComponent(jPanel_Aux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton_BI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton_NR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TSP))
                    .addComponent(jPanel_Aux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton_BO)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Tamaño Poblacion");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Numero de generaciones");

        jSpinnerTP.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jSpinnerNG.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jSpinnerPM.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Probabilidad de Muta");

        jButtonIniciar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jButtonIniciar.setText("Iniciar");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSpinnerNG, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jSpinnerTP)
                            .addComponent(jSpinnerPM))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerNG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Interfaz de Hilos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(135, 135, 135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HilosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HilosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HilosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HilosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HilosJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton TSP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAux;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Aux;
    private javax.swing.JRadioButton jRadioButton_BI;
    private javax.swing.JRadioButton jRadioButton_BO;
    private javax.swing.JRadioButton jRadioButton_NR;
    private javax.swing.JSpinner jSpinnerAux;
    private javax.swing.JSpinner jSpinnerNG;
    private javax.swing.JSpinner jSpinnerPM;
    private javax.swing.JSpinner jSpinnerTP;
    // End of variables declaration//GEN-END:variables

    
    public javax.swing.JSpinner getjSpinnerAux() {
        return jSpinnerAux;
    }


    public javax.swing.JSpinner getjSpinnerNG() {
        return jSpinnerNG;
    }

    
    public javax.swing.JSpinner getjSpinnerPM() {
        return jSpinnerPM;
    }

  
    public javax.swing.JSpinner getjSpinnerTP() {
        return jSpinnerTP;
    }

   
    public javax.swing.JLabel getjLabelAux() {
        return jLabelAux;
    }

   
    public javax.swing.JPanel getjPanel_Aux() {
        return jPanel_Aux;
    }

  
    public int getMenu() {
        return Menu;
    }

    
    public void setMenu(int menu) {
        this.Menu = menu;
    }

}
