import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class VentanaFiltrarCamas extends javax.swing.JFrame {
    Controlador controlador;
    public VentanaFiltrarCamas(Controlador controlador){
        this.controlador = controlador;       
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        general = new javax.swing.JCheckBox();
        intermedia = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        intensiva = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        disponible = new javax.swing.JCheckBox();
        ocupada = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Filtrar camas");

        general.setText("General");

        intermedia.setText("Intermedia");

        jLabel2.setText("Filtrar por tipo:");

        intensiva.setText("Intensiva");

        jLabel3.setText("Filtrar por disponibilidad:");

        disponible.setText("Disponible");

        ocupada.setText("Ocupada");

        jButton1.setText("Filtrar");
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
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disponible)
                            .addComponent(general)
                            .addComponent(intermedia)
                            .addComponent(intensiva)
                            .addComponent(ocupada)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(general)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intermedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intensiva)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(disponible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ocupada)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Limpiar la tabla actual
    String[] columnNames = {"Número", "Tipo", "Disponibilidad"};
    DefaultTableModel modeloTabla = new DefaultTableModel(columnNames, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Hacer que la tabla no sea editable
        }
    };
    JTable tablaCamas = new JTable(modeloTabla);
    tablaCamas.setFillsViewportHeight(true);
    JScrollPane scrollPane = new JScrollPane(tablaCamas);

    TableColumnModel columnModel = tablaCamas.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(50);  // Numero
    columnModel.getColumn(1).setPreferredWidth(100); // Tipo
    columnModel.getColumn(2).setPreferredWidth(100); // Disponibilidad
    modeloTabla.setRowCount(0);

    List<Cama> listaCamas = controlador.getListaCamas();
    List<String> tiposSeleccionados = new ArrayList<>();
    List<String> disponibilidadSeleccionada = new ArrayList<>();

    if (general.isSelected()) tiposSeleccionados.add("general");
    if (intermedia.isSelected()) tiposSeleccionados.add("intermedia");
    if (intensiva.isSelected()) tiposSeleccionados.add("intensiva");

    if (disponible.isSelected()) disponibilidadSeleccionada.add("disponible");
    if (ocupada.isSelected()) disponibilidadSeleccionada.add("ocupada");

    // Construir el mensaje para JOptionPane
    StringBuilder mensaje = new StringBuilder("Camas filtradas:\n");

    // Filtrar y agregar las camas a la tabla
    for (Cama cama : listaCamas) {
        boolean cumpleTipo = tiposSeleccionados.isEmpty() || 
                            tiposSeleccionados.contains(cama.getTipo());
        boolean cumpleDisponibilidad = disponibilidadSeleccionada.isEmpty() || 
            (cama.getDisponible() && disponibilidadSeleccionada.contains("disponible")) ||
            (!cama.getDisponible() && disponibilidadSeleccionada.contains("ocupada"));

        if (cumpleTipo && cumpleDisponibilidad) {
            modeloTabla.addRow(new Object[]{
                cama.getNumCama(),
                cama.getTipo(),
                cama.getDisponible() ? "Disponible" : "Ocupada"
            });
            // Añadir información de la cama al mensaje
            mensaje.append("Número: ").append(cama.getNumCama())
                   .append(", Tipo: ").append(cama.getTipo())
                   .append(", Disponibilidad: ").append(cama.getDisponible() ? "Disponible" : "Ocupada")
                   .append("\n");
        }
    }

    if (modeloTabla.getRowCount() == 0) {
        modeloTabla.addRow(new Object[]{"No se encontraron camas", "", ""});
        mensaje.append("No se encontraron camas con los filtros seleccionados.");
    }

    // Mostrar el mensaje en un JOptionPane
    JOptionPane.showMessageDialog(this, mensaje.toString(), "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox disponible;
    private javax.swing.JCheckBox general;
    private javax.swing.JCheckBox intensiva;
    private javax.swing.JCheckBox intermedia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox ocupada;
    // End of variables declaration//GEN-END:variables
}
