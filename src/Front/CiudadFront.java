/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import DAO.CiudadDAO;
import Entidad.Ciudad;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;



public class CiudadFront extends javax.swing.JFrame {
 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicaPU");
 
    public CiudadFront() {
      super("Centrar JFrame");	
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
      setSize(width/2, height/2);		

      setLocationRelativeTo(null);		
      setVisible(true);
     
        initComponents();
        
        ConsultaDatos();
    }

   
   
   //====================================
    //Consulta datos DB y muestra en la tabla
    //====================================
    
   
   void ConsultaDatos(){
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("ID");
       model.addColumn("NOMBRE");
       model.addColumn("CANTIDAD HABITANTES");
       model.addColumn("SITIO TURISTICO");
       model.addColumn("HOTEL RESERVADO");
       TablaCiudades.setModel(model);
        EntityManager em = emf.createEntityManager();
        Ciudad ciudad = null;
        Query q = em.createQuery("SELECT u FROM Ciudad u" );
        
        String[] datos = new String[5];
        for (int i = 0; i < q.getResultList().size(); i++) {
                ciudad = (Ciudad) q.getResultList().get(i);
                datos[0] = String.valueOf(ciudad.getId_ciudad());
                datos[2] = String.valueOf(ciudad.getCantidad_habitantes());
                datos[1] = ciudad.getNombre_ciudad();
                datos[3] = ciudad.getHotel_reservado();
                datos[4] = ciudad.getSitio_turístico();
                model.addRow(datos);      
       }
        TablaCiudades.setModel(model);

   }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tex_hotelreservado = new javax.swing.JTextField();
        tex_sitioturistico = new javax.swing.JTextField();
        tex_cant_hitantes = new javax.swing.JTextField();
        tex_nombreciudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCiudades = new javax.swing.JTable();
        Buscar = new javax.swing.JButton();
        tex_buscar = new javax.swing.JTextField();
        Agregar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Atras.setText("Atras");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Ciudad");

        jLabel2.setText("Cantidad Habitantes");

        jLabel3.setText("Sitio Más Turistico");

        jLabel4.setText("Hotel Más Reservado");

        tex_hotelreservado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tex_hotelreservadoActionPerformed(evt);
            }
        });

        tex_cant_hitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tex_cant_hitantesActionPerformed(evt);
            }
        });

        TablaCiudades.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaCiudades);

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tex_cant_hitantes)
                            .addComponent(tex_hotelreservado, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(tex_sitioturistico)
                            .addComponent(tex_nombreciudad)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Agregar)
                        .addGap(18, 18, 18)
                        .addComponent(Actualizar)
                        .addGap(18, 18, 18)
                        .addComponent(Eliminar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(Buscar)
                        .addGap(18, 18, 18)
                        .addComponent(tex_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(731, Short.MAX_VALUE)
                .addComponent(Atras)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tex_nombreciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Buscar)
                        .addComponent(tex_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(tex_cant_hitantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tex_sitioturistico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tex_hotelreservado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Agregar)
                            .addComponent(Actualizar)
                            .addComponent(Eliminar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        new Principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AtrasActionPerformed

    private void tex_cant_hitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tex_cant_hitantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tex_cant_hitantesActionPerformed

    private void tex_hotelreservadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tex_hotelreservadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tex_hotelreservadoActionPerformed

    //====================================
    //Inserta una tupla en la DB-CIUDAD
    //====================================
    
    
    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
       Ciudad ciudad = new Ciudad();
       CiudadDAO dao = new CiudadDAO();
       
       ciudad.setNombre_ciudad(tex_nombreciudad.getText());
       ciudad.setCantidad_habitantes(Integer.valueOf(tex_cant_hitantes.getText()));
       ciudad.setHotel_reservado(tex_hotelreservado.getText());
       ciudad.setSitio_turístico(tex_sitioturistico.getText());
       dao.crear(ciudad);
       ConsultaDatos();
       
    }//GEN-LAST:event_AgregarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        Ciudad ciudad = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        CiudadDAO dao = new CiudadDAO();
        ciudad.setNombre_ciudad(tex_buscar.getText());
        ciudad2 = dao.Buscar(ciudad);
        
        tex_nombreciudad.setText(ciudad2.getNombre_ciudad());
        tex_cant_hitantes.setText(String.valueOf(ciudad2.getCantidad_habitantes()));
        tex_hotelreservado.setText(ciudad2.getHotel_reservado());
        tex_sitioturistico.setText(ciudad2.getSitio_turístico());
        ConsultaDatos();
        
    }//GEN-LAST:event_BuscarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        Ciudad ciudad = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        CiudadDAO dao = new CiudadDAO();
        
        ciudad.setNombre_ciudad(tex_nombreciudad.getText());
        ciudad2 = dao.Buscar(ciudad);
        dao.eliminar(ciudad2);
        ConsultaDatos();
    }//GEN-LAST:event_EliminarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        Ciudad ciudad = new Ciudad();
        Ciudad ciudad2 = new Ciudad();
        CiudadDAO dao = new CiudadDAO();
        ciudad.setNombre_ciudad(tex_nombreciudad.getText());
        ciudad2 = dao.Buscar(ciudad);
        ciudad2.setNombre_ciudad(tex_nombreciudad.getText());
        ciudad2.setCantidad_habitantes(Integer.valueOf(tex_cant_hitantes.getText()));
        ciudad2.setHotel_reservado(tex_hotelreservado.getText());
        ciudad2.setSitio_turístico(tex_sitioturistico.getText());

        dao.actualizar(ciudad, ciudad2);
        ConsultaDatos();
    }//GEN-LAST:event_ActualizarActionPerformed

   
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
            java.util.logging.Logger.getLogger(CiudadFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CiudadFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CiudadFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CiudadFront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CiudadFront().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Atras;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTable TablaCiudades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tex_buscar;
    private javax.swing.JTextField tex_cant_hitantes;
    private javax.swing.JTextField tex_hotelreservado;
    private javax.swing.JTextField tex_nombreciudad;
    private javax.swing.JTextField tex_sitioturistico;
    // End of variables declaration//GEN-END:variables
}
