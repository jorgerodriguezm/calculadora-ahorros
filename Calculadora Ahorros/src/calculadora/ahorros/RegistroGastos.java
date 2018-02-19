package calculadora.ahorros;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author leonardo.manrique
 */
public class RegistroGastos extends javax.swing.JFrame {
    //Atributos
    String[] args;
    ConectorDB DB = new ConectorDB();
    
        
    public String descripcion;
    public double monto;
    public int tipo;
    public String tipoDesc;
    public int frecuencia;
    public String frecuenciaDesc;
    //Métodos
    public RegistroGastos() {
        initComponents();
        DB.connect();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        descripcionField = new javax.swing.JTextField();
        montoField = new javax.swing.JTextField();
        tipoBox = new javax.swing.JComboBox<>();
        frecuenciaBox = new javax.swing.JComboBox<>();
        agregarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        visualizarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Registro de Gastos"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        descripcionField.setToolTipText("");
        descripcionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        montoField.setToolTipText("");
        montoField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        montoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoFieldActionPerformed(evt);
            }
        });

        tipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Gasto...", "Comida", "Transporte", "Educación", "Hogar", "Familia", "Entretenimiento", "Otros Gastos" }));
        tipoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBoxActionPerformed(evt);
            }
        });

        frecuenciaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Frecuencia...", "Diario", "Semanal", "Quincenal", "Mensual", "Bimestral", "Trimestral", "Semestral", "Anual" }));
        frecuenciaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frecuenciaBoxActionPerformed(evt);
            }
        });

        agregarButton.setLabel("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        limpiarButton.setLabel("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        visualizarButton.setActionCommand("visualizarGastos");
        visualizarButton.setLabel("Visualizar Gastos");
        visualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarGastos(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Descripción");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Monto");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("REGISTRO DE GASTOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(visualizarButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregarButton)
                                .addGap(271, 271, 271))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcionField))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addComponent(frecuenciaBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montoField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frecuenciaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton)
                    .addComponent(visualizarButton)
                    .addComponent(limpiarButton)
                    .addComponent(agregarButton))
                .addGap(24, 24, 24))
        );

        descripcionField.getAccessibleContext().setAccessibleName("");
        montoField.getAccessibleContext().setAccessibleName("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public String getDescripcion(){
        descripcion = descripcionField.getText();
        return descripcion;
    }
    public double getMonto(){
        monto = Double.parseDouble(montoField.getText());
        return monto;
    }
    public int getTipo(){
        tipo = tipoBox.getSelectedIndex();
        return tipo;
    }
    public String getTipoDesc(){
        tipoDesc = (String) tipoBox.getSelectedItem();
        return tipoDesc;
    }
    public double getFrecuencia(){
        frecuencia = frecuenciaBox.getSelectedIndex();
        return frecuencia;
    }
    public String getFrecuenciaDesc(){
        frecuenciaDesc = (String) frecuenciaBox.getSelectedItem();
        return frecuenciaDesc;
    }
    
    //Getter de la tabla/////////////////////
    public JTextField getDescripcionField() {
        return descripcionField;
    }
    public JComboBox<String> getFrecuenciaBox() {
        return frecuenciaBox;
    }
    public JTextField getMontoField() {
        return montoField;
    }
    public JComboBox<String> getTipoBox() {
        return tipoBox;
    }
    /////////////////////////////////////////
    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        try
            {
                if (!getDescripcion().equals("") && getTipo() != 0 &&
                    getFrecuencia() != 0 && getMonto()>0){
                
                getDescripcion();
                getMonto();
                getTipo();
                getTipoDesc();
                getFrecuencia();
                getFrecuenciaDesc();
                Gasto Gasto = new Gasto(descripcion, monto, tipo, tipoDesc, frecuencia, frecuenciaDesc);
                DB.enviarGastos(Gasto);
                limpiarButtonActionPerformed(evt);
            }
            }
        catch(NumberFormatException nfe)
            {
                System.err.println("Not a double");
            }


    }//GEN-LAST:event_agregarButtonActionPerformed

    private void frecuenciaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frecuenciaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_frecuenciaBoxActionPerformed

    private void tipoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoBoxActionPerformed

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        descripcionField.setText("");
        montoField.setText("");
        tipoBox.setSelectedIndex(0);
        frecuenciaBox.setSelectedIndex(0);
    }//GEN-LAST:event_limpiarButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        DB.close();
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    private void montoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoFieldActionPerformed

    private void visualizarGastos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarGastos
        
        PieChartSample chart = new PieChartSample();
        PieChartSample.main(args);
    }//GEN-LAST:event_visualizarGastos

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegistroGastos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JTextField descripcionField;
    private javax.swing.JComboBox<String> frecuenciaBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JTextField montoField;
    private javax.swing.JButton salirButton;
    private javax.swing.JComboBox<String> tipoBox;
    private javax.swing.JButton visualizarButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}