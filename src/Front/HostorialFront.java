
package Front;

import Entidad.Ciudad;
import Entidad.Historial;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

 
public class HostorialFront extends javax.swing.JFrame {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicaPU");
    public HostorialFront() {
                                     super("Centrar JFrame");	
                                    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                                    int height = pantalla.height;
                                    int width = pantalla.width;
                                    setSize(width/2, height/2);		
                                    setLocationRelativeTo(null);		
                                    setVisible(true);      
        
        
        initComponents();
        mostrarCiudades();
        columnas();
    }


    
    
    void mostrarCiudades(){
          EntityManager em = emf.createEntityManager();
        Historial historial = null;
        Query q = em.createQuery("SELECT DISTINCT u.h_nombre_ciudad FROM Historial u" );
        for (int i = 0; i < q.getResultList().size(); i++) {    
            ciudad.addItem((String) q.getResultList().get(i));
        }
          
        
    }
    
    
       void ConsultaDatosCiudad(){
       DefaultTableModel model = new DefaultTableModel();
         model.addColumn("NOMBRE CIUDAD");
       model.addColumn("IDENTIFICACION");
       model.addColumn("NOMBRE TURISTA");
     
       model.addColumn("FECHA INGRESO");
       jTable1.setModel(model);
        EntityManager em = emf.createEntityManager();
        Historial historial = null;
        Query q = em.createQuery("SELECT u FROM Historial u WHERE u.h_nombre_ciudad LIKE :nombre" )
                 .setParameter("nombre", ciudad.getSelectedItem().toString());
        
        String[] datos = new String[5];
        for (int i = 0; i < q.getResultList().size(); i++) {
                historial = (Historial) q.getResultList().get(i);
                datos[0] = historial.getH_nombre_ciudad();
                datos[2] = historial.getH_nombre_turista();
                datos[1] = historial.getH_id_turista();
                datos[3] = historial.getFecha_ingreso().toString();
               
                model.addRow(datos);      
       }
        jTable1.setModel(model);

   }
   
       void columnas(){
            DefaultTableModel model = new DefaultTableModel();
       model.addColumn("NOMBRE CIUDAD");
       model.addColumn("IDENTIFICACION");
       model.addColumn("NOMBRE TURISTA");
       model.addColumn("FECHA INGRESO");
       jTable1.setModel(model);
       }
       
       void ConsultaDatosTurista(){
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("NOMBRE CIUDAD");
        model.addColumn("NOMBRE TURISTA");
       model.addColumn("IDENTIFICACION");
      
       model.addColumn("FECHA INGRESO");
       jTable1.setModel(model);
        EntityManager em = emf.createEntityManager();
        Historial historial = null;
        Query q = em.createQuery("SELECT u FROM Historial u WHERE u.h_id_turista LIKE :identificacion" )
                 .setParameter("identificacion", id_tu.getText());
        
        String[] datos = new String[5];
        for (int i = 0; i < q.getResultList().size(); i++) {
                historial = (Historial) q.getResultList().get(i);
                datos[0] = historial.getH_nombre_ciudad();
                datos[1] = historial.getH_nombre_turista();
                datos[2] = historial.getH_id_turista();
                datos[3] = historial.getFecha_ingreso().toString();
               
                model.addRow(datos);      
       }
        jTable1.setModel(model);

   }

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ciudad = new javax.swing.JComboBox<>();
        buscar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        id_tu = new javax.swing.JTextField();
        buscar2 = new javax.swing.JButton();
        atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadActionPerformed(evt);
            }
        });

        buscar1.setText("Buscar");
        buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        buscar2.setText("Buscar");
        buscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar2ActionPerformed(evt);
            }
        });

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_tu)
                            .addComponent(ciudad, 0, 111, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buscar2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(buscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(atras)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ciudad)
                            .addComponent(buscar1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buscar2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(id_tu))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        new TuristaFront().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadActionPerformed

    private void buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar1ActionPerformed
        ConsultaDatosCiudad();
    }//GEN-LAST:event_buscar1ActionPerformed

    private void buscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar2ActionPerformed
        ConsultaDatosTurista();
    }//GEN-LAST:event_buscar2ActionPerformed

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
            java.util.logging.Logger.getLogger(HostorialFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HostorialFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HostorialFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HostorialFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HostorialFront().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton buscar1;
    private javax.swing.JButton buscar2;
    private javax.swing.JComboBox<String> ciudad;
    private javax.swing.JTextField id_tu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
