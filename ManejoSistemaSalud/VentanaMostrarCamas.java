import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaMostrarCamas extends javax.swing.JFrame{
    private Controlador controlador;
    public VentanaMostrarCamas(Controlador controlador){
        this.controlador = controlador;
        initComponents();
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mostrar camas");

        jButton1.setText("Mostrar todas las camas existentes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Filtrar camas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(41, 41, 41)
                .addComponent(jButton3)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try(BufferedReader br = new BufferedReader(new FileReader(controlador.getDirectorio("cama")))){
                List<String[]> datos = new ArrayList<>();
                String linea;
                while ((linea = br.readLine()) != null){
                    String[] columnas = linea.split(";");
                    datos.add(columnas);
                }
                if(!datos.isEmpty()){
                    String[] nombresColumnas = new String[4];
                    nombresColumnas[0] = "Número de cama";
                    nombresColumnas[1] = "Tipo de cama";
                    nombresColumnas[2] = "Disponibilidad";
                    nombresColumnas[3] = "Ocupante";
                    DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
                    for(String[] fila : datos){
                        if(fila.length == 2){
                            fila = Arrays.copyOf(fila, fila.length + 1);
                            fila[2] = "Sin información";
                        }
                        if(fila.length == 3){
                            if(Boolean.parseBoolean(fila[2])){
                                fila[2] = "Disponible";
                            }
                            else{
                                fila[2] = "En uso";
                            }
                            fila = Arrays.copyOf(fila, fila.length + 2);
                            fila[3] = "Sin información";
                        }
                        modeloTabla.addRow(fila);
                    }
                    JTable tabla = new JTable(modeloTabla);
                    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    tabla.setFillsViewportHeight(true);
                    JScrollPane scrollPane = new JScrollPane(tabla);
                    JOptionPane.showMessageDialog(null, scrollPane, "Datos del CSV", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El archivo CSV está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            }catch(IOException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al leer el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        controlador.mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.mostrarVentanaFiltrarCamas();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
