import com.opencsv.exceptions.CsvValidationException;

import javax.swing.JOptionPane;

public class VentanaAsignarCama extends javax.swing.JFrame {
    private Controlador controlador;
    public VentanaAsignarCama(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rutPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        general = new javax.swing.JRadioButton();
        intermedia = new javax.swing.JRadioButton();
        intensiva = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Asignar cama");

        jLabel2.setText("Rut paciente: ");

        jLabel3.setText("Gravedad:");

        jButton1.setText("Asignar");
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

        general.setText("General");

        intermedia.setText("Intermedia");
        intermedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intermediaActionPerformed(evt);
            }
        });

        intensiva.setText("Intensiva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(163, 163, 163))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(general)
                            .addComponent(intermedia)
                            .addComponent(intensiva)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(general))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intermedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intensiva)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(54, Short.MAX_VALUE))
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
                    botones.add(general);
                    botones.add(intensiva);
                    botones.add(intermedia);
                    for(int i = 0;i<controlador.getListaCamas().size();i++) {
                        if (controlador.getListaCamas().get(i).getPacienteAsignado() != null) {
                            if (rut.equalsIgnoreCase(controlador.getListaCamas().get(i).getPacienteAsignado())) {
                                JOptionPane.showMessageDialog(this, "El paciente ya se encuentra asignado a una cama.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                                controlador.mostrarVentanaAsignarCama();
                                this.dispose();
                                return;
                            }
                        }
                    }
                    String numero;
                    if(general.isSelected()){
                        if (controlador.asignarCama(rut, 1)){
                            numero = String.valueOf(controlador.buscarCama(rut).getNumCama());
                            JOptionPane.showMessageDialog(this, "El paciente ha sido asignado a una cama de tipo general.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                            controlador.eliminarDato(controlador.getDirectorio("cama"),numero);
                            controlador.grabarDato(controlador.getDirectorio("cama"),controlador.buscarCama(rut).getNumCama()+";"+controlador.buscarCama(rut).getTipo()+";"+controlador.buscarCama(rut).getDisponible()+";"+controlador.buscarCama(rut).getPacienteAsignado());
                            controlador.mostrarVentanaPrincipal();
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "No hay camas disponibles de tipo general, el paciente se encuentra en lista de espera.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    if(intermedia.isSelected()){
                        if(controlador.asignarCama(rut, 2)){
                            numero = String.valueOf(controlador.buscarCama(rut).getNumCama());
                            JOptionPane.showMessageDialog(this, "El paciente ha sido asignado a una cama de tipo intermedia.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                            controlador.eliminarDato(controlador.getDirectorio("cama"),numero);
                            controlador.grabarDato(controlador.getDirectorio("cama"),controlador.buscarCama(rut).getNumCama()+";"+controlador.buscarCama(rut).getTipo()+";"+controlador.buscarCama(rut).getDisponible()+";"+controlador.buscarCama(rut).getPacienteAsignado());
                            controlador.mostrarVentanaPrincipal();
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "No hay camas disponibles de tipo intermedia, el paciente se encuentra en lista de espera.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    if(intensiva.isSelected()){
                        if(controlador.asignarCama(rut, 3)){
                            numero = String.valueOf(controlador.buscarCama(rut).getNumCama());
                            JOptionPane.showMessageDialog(this, "El paciente ha sido asignado a una cama de tipo intensiva.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                            controlador.eliminarDato(controlador.getDirectorio("cama"),numero);
                            controlador.grabarDato(controlador.getDirectorio("cama"),controlador.buscarCama(rut).getNumCama()+";"+controlador.buscarCama(rut).getTipo()+";"+controlador.buscarCama(rut).getDisponible()+";"+controlador.buscarCama(rut).getPacienteAsignado());
                            controlador.mostrarVentanaPrincipal();
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "No hay camas disponibles de tipo intensiva, el paciente tiene prioridad, será atendido lo antes posible.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Paciente no registrado.", "ALERTA", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }catch(RutInvalidoException e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error de RUT", JOptionPane.ERROR_MESSAGE);
    } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void intermediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intermediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intermediaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup botones;
    private javax.swing.JRadioButton general;
    private javax.swing.JRadioButton intensiva;
    private javax.swing.JRadioButton intermedia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField rutPaciente;
    // End of variables declaration//GEN-END:variables
}
