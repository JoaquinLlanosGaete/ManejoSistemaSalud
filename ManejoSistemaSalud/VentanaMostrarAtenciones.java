import javax.swing.JOptionPane;

public class VentanaMostrarAtenciones extends javax.swing.JFrame {
    private Controlador controlador;
    public VentanaMostrarAtenciones(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rut = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mostrar atenciones");

        jLabel2.setText("Rut paciente:");

        jButton1.setText("Mostrar atenciones");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(rut, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        if(rut.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un RUT.", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }
        else{
            String rutP = rut.getText().trim();
            if(!controlador.validarRut(rutP)){
                throw new RutInvalidoException("El RUT debe tener exactamente 9 dígitos sin puntos ni guión.");
            }
            if(controlador.existePaciente(rutP)){
                int cantAtenciones = controlador.getCantAtenciones(rutP);
                if(cantAtenciones > 0){
                    for(int i = 0; i < cantAtenciones; i++){
                        String fechaAtencion = controlador.getFechaAtencion(rutP, i);
                        String diagnostico = controlador.getDiagnosticoAtencion(rutP, fechaAtencion);
                        JOptionPane.showMessageDialog(this, "Atención " + (i + 1) + ":\nFecha: " + fechaAtencion + "\nDiagnóstico: " + diagnostico, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    }
                    controlador.mostrarVentanaPrincipal();
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "El paciente no tiene atenciones.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "El paciente no existe.", "ALERTA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }catch(RutInvalidoException e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error de RUT", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField rut;
    // End of variables declaration//GEN-END:variables
}
