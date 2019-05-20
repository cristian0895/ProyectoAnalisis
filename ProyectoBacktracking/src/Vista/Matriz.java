/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CrearPreguntas;
import Controlador.Evaluacion;
import Modelo.Pregunta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paola
 */
public class Matriz extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    FrmPreguntas p;
    ArrayList<Pregunta> list;
    Evaluacion ev;
    CrearPreguntas cp;
    static int fila;
    static int columna;
    static int numPreguntas;
    int[][] matriz;
    int criterio = 0;

    public Matriz() {
        initComponents();
        p = new FrmPreguntas();
//        fila = Integer.parseInt(txtFila.getText());
//        columna = Integer.parseInt(txtColumna.getText());
//        numPreguntas = Integer.parseInt(txtNumPreguntas.getText());
        list = new ArrayList<>();

        lblTotalBanco.setText(list.size() + "");
        listarPreguntas();

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtFila = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtColumna = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumPreguntas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPreguntas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotalBanco = new javax.swing.JLabel();
        btnCrearXPreguntas = new javax.swing.JButton();
        cbPreguntas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbMetodoOrdenacion = new javax.swing.JComboBox<>();
        cbCriterioOrdenacion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblExamenes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnCrearSalon = new javax.swing.JButton();
        btnCrearExamen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dimensión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese el tamaño de la fila:");

        jLabel2.setText("Ingrese el tamaño de la columna:");

        jLabel3.setText("Numero de preguntas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtFila, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtNumPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pregunta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        tblPreguntas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPreguntas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPreguntas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPreguntas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPreguntasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPreguntas);

        jLabel7.setText("Preguntas en el banco");

        btnCrearXPreguntas.setText("Listar Preguntas");
        btnCrearXPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearXPreguntasActionPerformed(evt);
            }
        });

        cbPreguntas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100", "1000", "10000", "100000" }));

        jLabel6.setText("Metodo de Ordenacion");

        cbMetodoOrdenacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Burbuja", "Burbuja Bidimencional", "Iner Sort", "Merge Sort", "Seleccion", "QuickSort" }));
        cbMetodoOrdenacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMetodoOrdenacionActionPerformed(evt);
            }
        });

        cbCriterioOrdenacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Dificultad", "Tiempo" }));
        cbCriterioOrdenacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCriterioOrdenacionActionPerformed(evt);
            }
        });

        jLabel4.setText("Criterio de ordenacion");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCrearXPreguntas)
                        .addGap(41, 41, 41)
                        .addComponent(cbPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbMetodoOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addComponent(cbCriterioOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearXPreguntas)
                    .addComponent(cbPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbMetodoOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbCriterioOrdenacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Examenes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        tblExamenes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblExamenes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExamenesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblExamenes);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCrearSalon.setText("Crear Salon");
        btnCrearSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSalonActionPerformed(evt);
            }
        });

        btnCrearExamen.setText("Crear examenes");
        btnCrearExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearExamenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearExamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearSalon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnCrearSalon)
                .addGap(28, 28, 28)
                .addComponent(btnCrearExamen)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearSalonActionPerformed
        try {
            if (txtFila.getText().isEmpty() || txtColumna.getText().isEmpty() || txtNumPreguntas.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos a para crear un salon");
            } else {
                fila = Integer.parseInt(txtFila.getText());
                columna = Integer.parseInt(txtColumna.getText());
                numPreguntas = Integer.parseInt(txtNumPreguntas.getText());
                matriz = new int[fila][columna];

                if (fila != 0 && columna != 0 && numPreguntas != 0) {
                    ev = new Evaluacion(fila, columna, numPreguntas, list);
                    JOptionPane.showMessageDialog(null, "Salon creado");
                    txtFila.setText("");
                    txtColumna.setText("");
                    txtNumPreguntas.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar valores mayores a 0");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnCrearSalonActionPerformed

    private void btnCrearExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearExamenActionPerformed

        ev = new Evaluacion(fila, columna, numPreguntas, list);
        listarPreguntas();
        if (ev.asignarExamen(0, 0, 0)) {
            ev.listar();
        } else {
            JOptionPane.showMessageDialog(null, "Imposible realizar examen");
        }


    }//GEN-LAST:event_btnCrearExamenActionPerformed

    private void tblPreguntasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPreguntasMouseClicked
        // TODO add your handling code here:
        int i = tblPreguntas.rowAtPoint(evt.getPoint());
        list.remove(i);
        listarPreguntas();
        lblTotalBanco.setText(list.size() + "");
    }//GEN-LAST:event_tblPreguntasMouseClicked

    private void tblExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExamenesMouseClicked

        p.setLocationRelativeTo(null);
        p.setVisible(true);
        FrmPreguntas.txtDiagSuperIz.setText("");
        FrmPreguntas.txtSuperior.setText("");
        FrmPreguntas.txtDiagSupDere.setText("");
        FrmPreguntas.txtIzquier.setText("");
        FrmPreguntas.txtDerecha.setText("");
        FrmPreguntas.txtDiagInfeIzquier.setText("");
        FrmPreguntas.txtAbajo.setText("");
        FrmPreguntas.txtDiagInfeDere.setText("");
        int iRow = tblExamenes.rowAtPoint(evt.getPoint());
        int iCol = tblExamenes.columnAtPoint(evt.getPoint());

        ev.mostrarAlrededor(iRow, iCol, numPreguntas);
    }//GEN-LAST:event_tblExamenesMouseClicked

    private void btnCrearXPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearXPreguntasActionPerformed
        // TODO add your handling code here:        
        list.clear();
        int preguntas = Integer.parseInt(cbPreguntas.getSelectedItem().toString());
        cp = new CrearPreguntas(list, preguntas);
        cp.SolicitudListarArrayList();
        listarPreguntas();
        lblTotalBanco.setText(list.size() + "");
    }//GEN-LAST:event_btnCrearXPreguntasActionPerformed

    private void cbMetodoOrdenacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMetodoOrdenacionActionPerformed
        // TODO add your handling code here:
        switch (cbMetodoOrdenacion.getSelectedIndex()) {
            case 0:
                listarPreguntas();
                break;
            case 1:
                cp.OrdenarBurbuja(criterio);
                listarPreguntas();
                break;
            case 2:
                cp.OrdenarBurbujaBidireccional(criterio);
                listarPreguntas();
                break;
            case 3:
                cp.insertSort(criterio);
                listarPreguntas();
                break;
            case 4:
                if (criterio == 1) {
                    cp.mergeSort(list);
                    listarPreguntas();
                } else {
                    cp.mergeSort(list);
                    listarPreguntas();
                }

                break;
            case 5:
                cp.selecccion(criterio);
                listarPreguntas();
                break;
            default:
                if (criterio == 1) {
                    cp.ordenarQuicksortDificultad(list, 0, list.size() - 1);
                    listarPreguntas();
                } else {
                    cp.ordenarQuicksortTiempo(list, 0, list.size() - 1);
                    listarPreguntas();
                }

                break;
        }
    }//GEN-LAST:event_cbMetodoOrdenacionActionPerformed

    private void cbCriterioOrdenacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCriterioOrdenacionActionPerformed
        // TODO add your handling code here:
        switch (cbCriterioOrdenacion.getSelectedIndex()) {
            case 0:
                criterio = 0;
                break;
            case 1:
                criterio = 1;
                break;
            default:
                criterio = 2;
                break;
        }
    }//GEN-LAST:event_cbCriterioOrdenacionActionPerformed

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
            java.util.logging.Logger.getLogger(Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matriz().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearExamen;
    private javax.swing.JButton btnCrearSalon;
    private javax.swing.JButton btnCrearXPreguntas;
    private javax.swing.JComboBox<String> cbCriterioOrdenacion;
    private javax.swing.JComboBox<String> cbMetodoOrdenacion;
    private javax.swing.JComboBox<String> cbPreguntas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTotalBanco;
    public static javax.swing.JTable tblExamenes;
    private javax.swing.JTable tblPreguntas;
    private javax.swing.JTextField txtColumna;
    private javax.swing.JTextField txtFila;
    private javax.swing.JTextField txtNumPreguntas;
    // End of variables declaration//GEN-END:variables

    public void listarPreguntas() {
        DefaultTableModel modelTabla;

        String nombreColumnas[] = {"Pregunta", "Dificultad", "Tiempo", "Tema", "Fecha Creacion"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        Object[] fila = new Object[modelTabla.getColumnCount()];
        for (int i = 0; i < list.size(); i++) {
            fila[0] = list.get(i).getTexto();
            fila[1] = list.get(i).getDificultad();
            fila[2] = list.get(i).getTiempo();
            fila[3] = list.get(i).getTema_id();
            fila[4] = list.get(i).getFECHA_CREACION();
            modelTabla.addRow(fila);

        }
        tblPreguntas.setModel(modelTabla);

    }
}
