import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PersonaFrm extends javax.swing.JFrame {
    
     //Atributo para cargar el combo
    private DefaultComboBoxModel modeloEstado;
    private DefaultComboBoxModel modeloGenero;
    private DefaultTableModel modeloTabla;
    /**
     * Creates new form PersonaFrm
     */
    public PersonaFrm() {
        modeloEstado = new DefaultComboBoxModel(new String [] {});
        modeloGenero = new DefaultComboBoxModel(new String [] {});
        modeloTabla = new DefaultTableModel(null, getColum());
        
        initComponents();
        
        cargarTabla();
        
        Persona objPersona = new Persona();
        ResultSet estados;
        ResultSet genero;
        estados = objPersona.listaEstados();
        genero = objPersona.cargarTablaGenero();
        
        try {
            while(estados.next()){
                modeloEstado.addElement(new Estado(estados.getInt("id"), estados.getString("nombre")));
            }
            while (genero.next()) {
                modeloGenero.addElement(new Genero(genero.getInt("id"), genero.getString("nombre")));
  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error: "+e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private String[] getColum(){
        String columnas[] = new String[]{"identificacion","nombre","apellido"};
        return columnas;
    }
    
    // Para cargar la tabla
    
    private void cargarTabla(){
        Persona objPersona = new Persona();
        ResultSet Resultado = objPersona.cargarTablaPersona();
        
        try {
            Object dato [] = new Object[3];
            while (Resultado.next()) {
                for (int i=0; i<3; i++) {
                    dato[i] = Resultado.getObject(i+1);
                }
                modeloTabla.addRow(dato);
            }
        } catch (Exception e) {
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPersona = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblIdentificacion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        cboGenero = new javax.swing.JComboBox<>();
        cboEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPersona.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblPersona.setText("PERSONAS");

        jTable1.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTable1);

        lblIdentificacion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblIdentificacion.setText("Identificacion");

        lblNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        lblApellido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblApellido.setText("Apellido");

        lblEdad.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblEdad.setText("Edad");

        lblGenero.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblGenero.setText("Genero");

        lblEstado.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblEstado.setText("Estado");

        cboGenero.setModel(modeloGenero);

        cboEstado.setModel(modeloEstado);

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnActualizar)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblIdentificacion)
                                        .addComponent(lblNombre)
                                        .addComponent(lblApellido)
                                        .addComponent(lblEdad)
                                        .addComponent(lblGenero)
                                        .addComponent(lblEstado))
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEdad)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cboEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE)
                                            .addComponent(cboGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPersona)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(btnEliminar)))
                            .addGap(90, 90, 90)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(btnMenu)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblPersona)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdentificacion)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEdad)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenero)
                            .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir)
                            .addComponent(btnMenu))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Persona per = new Persona();
        
        Estado objEstado = (Estado) cboEstado.getSelectedItem();
        Genero objGenero = (Genero) cboGenero.getSelectedItem();
        String estado = objEstado.getNombre();
        String genero = objGenero.getNombre();
        
        boolean resultado = per.insertarPersona(Integer.parseInt(txtIdentificacion.getText()), 
                txtNombre.getText(), txtApellido.getText(), Integer.parseInt(txtEdad.getText()),genero, 
                estado);
        
        if(resultado==true){
            JOptionPane.showMessageDialog(null, "Los Datos Se Insertaron");
        }else{
            JOptionPane.showMessageDialog(null, "Los Datos No Se Insertaron");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Persona per = new Persona();
        
        Estado objEstado = (Estado) cboEstado.getSelectedItem();
        String estado = objEstado.getNombre();
        Genero objGenero = (Genero) cboGenero.getSelectedItem();
        String genero = objGenero.getNombre();
        
        boolean resultado = per.actualizarPersona(Integer.parseInt(txtIdentificacion.getText()), 
                txtNombre.getText(), txtApellido.getText(), 
                Integer.parseInt(txtEdad.getText()), genero, estado);
        if(resultado==true){
            JOptionPane.showMessageDialog(null, "Los Datos Se Actualizaron");
        }else{
            JOptionPane.showMessageDialog(null, "Los Datos No Actualizaron");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Persona per = new Persona();
        boolean resultado = per.eliminarPersona(Integer.parseInt(txtIdentificacion.getText()));
        
        if(resultado==true){
            JOptionPane.showMessageDialog(null, "Los Datos Se Eliminaron");
        }else{
            JOptionPane.showMessageDialog(null, "Los Datos No Se Insertaron");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        InicioFrm verFormularioInicio = new InicioFrm();
        verFormularioInicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(PersonaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonaFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}