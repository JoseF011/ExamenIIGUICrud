/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.exameniimaquinaria;
import org.bson.Document;
import javax.swing.table.DefaultTableModel;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author LuisaFernanda
 */
public class Maquinaria extends javax.swing.JFrame {
    //Creando la Coleccion de Maquinaria
    MongoCollection<Document> Maquinaria;

    //Creando el modelo de la tabla
    DefaultTableModel modelMaquinaria;
    /**
     * Creates new form Maquinaria
     */
    public Maquinaria() {
        initComponents();
    //Definiendo la coleccion Maquinaria
        this.Maquinaria = main.connMongo.getDB().getCollection("Maquinaria");

    //Definiendo la estructura de la tabla
        this.modelMaquinaria = new DefaultTableModel();
        this.modelMaquinaria.addColumn("Id");
        this.modelMaquinaria.addColumn("Nombre");
        this.modelMaquinaria.addColumn("Marca");
        this.modelMaquinaria.addColumn("Modelo");
        
        this.llenarTabla();
//ocultar el ID de la tabla
        this.tbMaquinaria.getColumnModel().getColumn(0).setMinWidth(0);
        this.tbMaquinaria.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void llenarTabla(){
        this.tbMaquinaria.setModel(this.modelMaquinaria);

        MongoCursor<Document> cursor = main.connMongo.getDocuments(this.Maquinaria).iterator();
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                System.out.println(documento);
                this.agregarRegistrosTabla(documento);
            }
    }

   private void agregarRegistrosTabla(Document fila){
       String id = fila.get("_id").toString();
       String nombre = fila.get("nombre").toString();
       String Marca=fila.get("Marca").toString();
       String Modelo=fila.get("Modelo").toString();
       this.modelMaquinaria.addRow(new Object[]{id,nombre,Marca,Modelo});
 }

    public void insertarDatos(){
       Document datosObj = new Document("_id",new ObjectId())
            .append("nombre",txtNombre.getText())
            .append("Marca",txtMarca.getText())
            .append("Modelo", Integer.parseInt(txtModelo.getText()));
 
       if(main.connMongo.insertDocuments(this.Maquinaria,datosObj)){
           this.limpiarForm();
           this.agregarRegistrosTabla(datosObj);
        }
    }

    public void limpiarForm(){
        txtNombre.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtNombre.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMaquinaria = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel1.setText("Nombre del Vehiculo");

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel2.setText("Año del Vehiculo");

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel3.setText("Marca");

        tbMaquinaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbMaquinaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMaquinariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMaquinaria);

        btnModificar.setText("Actualizar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.insertarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea eliminar el registro seleccionado?", 
                    "Confirmacion de eliminacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, (res==JOptionPane.YES_OPTION && this.deleteTablePersonas())? "Registro eliminado con exito!":"Registro no pudo ser eliminado!");
      
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea actualizar el registro seleccionado?", 
                    "Confirmacion de actualizacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

        int posicion = this.tbMaquinaria.getSelectedRow();
        if(posicion>=0 && res==JOptionPane.YES_OPTION ){
           int nCol = this.modelMaquinaria.getColumnCount();
           String[] dataTabla = new String[nCol];
           for(int i=0;i<nCol;i++){
            dataTabla[i]=this.modelMaquinaria.getValueAt(posicion, i).toString();
           }

           Document datosObj = new Document("nombre",this.txtNombre.getText())
            .append("Marca",this.txtMarca.getText())
            .append("Modelo", Integer.parseInt(this.txtModelo.getText()));
           
           JOptionPane.showMessageDialog(null, main.connMongo.actualizarDocuments(this.Maquinaria,datosObj,dataTabla[0])?"Registro Actualizado con exito":"Registro no pudo ser actualizado");
          
           this.modelMaquinaria.setValueAt(this.txtNombre.getText(), posicion, 1);
           this.modelMaquinaria.setValueAt(this.txtMarca.getText(), posicion, 2);
           this.modelMaquinaria.setValueAt(this.txtModelo.getText(), posicion, 3);
           this.limpiarForm();
           this.tbMaquinaria.clearSelection();
      
        }else{
           JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void tbMaquinariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMaquinariaMouseClicked
        // TODO add your handling code here:
        int posicion = this.tbMaquinaria.getSelectedRow();
        if(posicion>=0){
           int nCol = this.modelMaquinaria.getColumnCount();
           String[] dataTabla = new String[nCol];
           for(int i=0;i<nCol;i++){
            dataTabla[i]=this.modelMaquinaria.getValueAt(posicion, i).toString();
           }

           this.txtNombre.setText(dataTabla[1]);
           this.txtMarca.setText(dataTabla[2]);
           this.txtModelo.setText(dataTabla[3]);

        }else{
           JOptionPane.showMessageDialog(null, "Seleccione otro registro de la tabla");
        }
    }//GEN-LAST:event_tbMaquinariaMouseClicked

public boolean deleteTablePersonas(){
     int posicion = this.tbMaquinaria.getSelectedRow();
     if(posicion>=0){
        String id=this.modelMaquinaria.getValueAt(posicion, 0).toString();     
        this.modelMaquinaria.removeRow(posicion);
        main.connMongo.deleteDocuments(this.Maquinaria,id);
        return true;
     }else{
        return false;
     }
}
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
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maquinaria().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMaquinaria;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
