import javax.swing.JOptionPane;

public class VentanaReubicarCama extends javax.swing.JFrame {
    private Controlador controlador;
    public VentanaReubicarCama(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rutPaciente = new javax.swing.JTextField();
        gravedad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Reubicar paciente en cama");

        jLabel2.setText("Numero del 1 al 3.");

        jLabel3.setText("Rut paciente:");

        jLabel4.setText("Gravedad:");

        jButton1.setText("Reubicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(105, 105, 105)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(gravedad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2))
                                    .addComponent(rutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gravedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        String rut = rutPaciente.getText().trim();
        if(rut.isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el RUT del paciente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(!controlador.validarRut(rut)){
                throw new RutInvalidoException("El RUT debe tener exactamente 9 dígitos sin puntos ni guión.");
            }
            else{
                if(controlador.existePaciente(rut)){
                    if(!gravedad.getText().isEmpty()){
                        int tipoGravedad = Integer.parseInt(gravedad.getText());
                        if(tipoGravedad == 1){
                            if(controlador.reubicarPaciente(rut, tipoGravedad)) {
                                JOptionPane.showMessageDialog(this, "El paciente fue reubicado en una cama de tipo general.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                controlador.mostrarVentanaPrincipal();
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "No hay camas disponibles para el paciente.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                            }
                        }if(tipoGravedad == 2){
                            if(controlador.reubicarPaciente(rut, tipoGravedad)){
                                JOptionPane.showMessageDialog(this, "El paciente fue reubicado en una cama de tipo intermedia.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                controlador.mostrarVentanaPrincipal();
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "No hay camas disponibles para el paciente.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                            }
                        }if(tipoGravedad == 3){
                            if(controlador.reubicarPaciente(rut, tipoGravedad)){
                                JOptionPane.showMessageDialog(this, "El paciente fue reubicado en una cama de tipo intensiva.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                controlador.mostrarVentanaPrincipal();
                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "No hay camas disponibles para el paciente.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Tipo de gravedad no válido.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Ingrese la gravedad.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "El paciente no está registrado.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }catch(RutInvalidoException e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error de RUT", JOptionPane.ERROR_MESSAGE);
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para la gravedad.", "Error de formato", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField gravedad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField rutPaciente;
    // End of variables declaration//GEN-END:variables
}
