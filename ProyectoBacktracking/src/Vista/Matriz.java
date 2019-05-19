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
    ArrayList<Pregunta> list;
    Evaluacion ev;
    CrearPreguntas cp;
    static int fila;
    static int columna;
    static int numPreguntas;
    int[][] matriz;
    Pregunta pre;

    public Matriz() {
        initComponents();

//        fila = Integer.parseInt(txtFila.getText());
//        columna = Integer.parseInt(txtColumna.getText());
//        numPreguntas = Integer.parseInt(txtNumPreguntas.getText());
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            pre = new Pregunta(i + "", i, i, i, "");
            list.add(pre);
        }
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
        btnCrearSalon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCrearExamen = new javax.swing.JButton();
        LblTotal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtPregunta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCrearPregunta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPreguntas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotalBanco = new javax.swing.JLabel();
        btnCrearXPreguntas = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDiagSuperIz = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDiagSupDere = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtIzquier = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtSuperior = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtDiagInfeIzquier = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtAbajo = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtDiagInfeDere = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtDerecha = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtExamenActual = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblExamenes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dimensión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese el tamaño de la fila:");

        jLabel2.setText("Ingrese el tamaño de la columna:");

        jLabel3.setText("Numero de preguntas");

        btnCrearSalon.setText("Crear Salon");
        btnCrearSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearSalonActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad de preguntas que debe crear:");

        btnCrearExamen.setText("Crear examenes");
        btnCrearExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearExamenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(LblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFila, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCrearSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCrearExamen))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearSalon)
                    .addComponent(btnCrearExamen)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addComponent(LblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pregunta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ingrese la pregunta:");

        btnCrearPregunta.setText("Crear Pregunta");
        btnCrearPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPreguntaActionPerformed(evt);
            }
        });

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

        btnCrearXPreguntas.setText("Crear x Preguntas");
        btnCrearXPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearXPreguntasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPregunta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearPregunta)
                        .addGap(50, 50, 50)
                        .addComponent(btnCrearXPreguntas)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearPregunta)
                    .addComponent(btnCrearXPreguntas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtDiagSuperIz.setColumns(20);
        txtDiagSuperIz.setRows(5);
        jScrollPane5.setViewportView(txtDiagSuperIz);

        txtDiagSupDere.setColumns(20);
        txtDiagSupDere.setRows(5);
        jScrollPane6.setViewportView(txtDiagSupDere);

        txtIzquier.setColumns(20);
        txtIzquier.setRows(5);
        jScrollPane7.setViewportView(txtIzquier);

        txtSuperior.setColumns(20);
        txtSuperior.setRows(5);
        jScrollPane8.setViewportView(txtSuperior);

        txtDiagInfeIzquier.setColumns(20);
        txtDiagInfeIzquier.setRows(5);
        jScrollPane9.setViewportView(txtDiagInfeIzquier);

        txtAbajo.setColumns(20);
        txtAbajo.setRows(5);
        jScrollPane10.setViewportView(txtAbajo);

        txtDiagInfeDere.setColumns(20);
        txtDiagInfeDere.setRows(5);
        jScrollPane11.setViewportView(txtDiagInfeDere);

        txtDerecha.setColumns(20);
        txtDerecha.setRows(5);
        jScrollPane12.setViewportView(txtDerecha);

        txtExamenActual.setColumns(20);
        txtExamenActual.setRows(5);
        jScrollPane13.setViewportView(txtExamenActual);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane9))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    int suma = (fila * columna) + numPreguntas;
                    LblTotal.setText("(Recomendado)  " + suma);
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

    private void btnCrearPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPreguntaActionPerformed
        String pregunta = txtPregunta.getText();
//        list.add(pregunta);

        lblTotalBanco.setText(list.size() + "");
        txtPregunta.setText("");
        listarPreguntas();
    }//GEN-LAST:event_btnCrearPreguntaActionPerformed

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
        txtDiagSuperIz.setText("");
        txtSuperior.setText("");
        txtDiagSupDere.setText("");
        txtIzquier.setText("");
        txtDerecha.setText("");
        txtDiagInfeIzquier.setText("");
        txtAbajo.setText("");
        txtDiagInfeDere.setText("");
        int iRow = tblExamenes.rowAtPoint(evt.getPoint());
        int iCol = tblExamenes.columnAtPoint(evt.getPoint());

//        ev.mostrarAlrededor(iRow, iCol, numPreguntas);
    }//GEN-LAST:event_tblExamenesMouseClicked

    private void btnCrearXPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearXPreguntasActionPerformed
        // TODO add your handling code here:        
        cp = new CrearPreguntas(list);
        cp.SolicitudListarArrayList();
        listarPreguntas();
        lblTotalBanco.setText(list.size() + "");
    }//GEN-LAST:event_btnCrearXPreguntasActionPerformed

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
    private javax.swing.JLabel LblTotal;
    private javax.swing.JButton btnCrearExamen;
    private javax.swing.JButton btnCrearPregunta;
    private javax.swing.JButton btnCrearSalon;
    private javax.swing.JButton btnCrearXPreguntas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblTotalBanco;
    public static javax.swing.JTable tblExamenes;
    private javax.swing.JTable tblPreguntas;
    public static javax.swing.JTextArea txtAbajo;
    private javax.swing.JTextField txtColumna;
    public static javax.swing.JTextArea txtDerecha;
    public static javax.swing.JTextArea txtDiagInfeDere;
    public static javax.swing.JTextArea txtDiagInfeIzquier;
    public static javax.swing.JTextArea txtDiagSupDere;
    public static javax.swing.JTextArea txtDiagSuperIz;
    public static javax.swing.JTextArea txtExamenActual;
    private javax.swing.JTextField txtFila;
    public static javax.swing.JTextArea txtIzquier;
    private javax.swing.JTextField txtNumPreguntas;
    private javax.swing.JTextField txtPregunta;
    public static javax.swing.JTextArea txtSuperior;
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
