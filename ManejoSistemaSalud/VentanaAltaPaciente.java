import com.opencsv.exceptions.CsvValidationException;

import javax.swing.JOptionPane;

public class VentanaAltaPaciente extends javax.swing.JFrame {
    private Controlador controlador;
    public VentanaAltaPaciente(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rutPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Dar alta a paciente");

        jButton1.setText("Dar alta");
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

        jLabel2.setText("Rut paciente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(rutPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rutPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Este boton tiene como objetivo dar de alta al paciente
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
                    if(controlador.getPaciente(rut).getGravedad()==0){
                        JOptionPane.showMessageDialog(this, "Paciente ya se encuentra dado de Alta.", "NOTIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        controlador.darAltaPaciente(rut);
                        controlador.eliminarDato(controlador.getDirectorio("pacientes"),rut);
                        controlador.grabarDato(controlador.getDirectorio("pacientes"),rut);
                        JOptionPane.showMessageDialog(this, "Paciente dado de alta.", "NOTIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                        controlador.mostrarVentanaPrincipal();
                        this.dispose();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Paciente no se encuentra registrado.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }            
        }
    }catch(RutInvalidoException e){
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error de RUT", JOptionPane.ERROR_MESSAGE);
    } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    //Sale de la ventana actual y regresa a la ventana principal
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField rutPaciente;
    // End of variables declaration//GEN-END:variables
}
