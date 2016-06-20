
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;

public class InterfazGU extends javax.swing.JFrame {

    javax.swing.JFileChooser jFileChooser1;
    Imagen imagen;
    String path;

    public InterfazGU() {
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuBrillo = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuItemPseudoColor = new javax.swing.JMenuItem();
        jMenuItemSuma = new javax.swing.JMenuItem();
        jMenuItemResta = new javax.swing.JMenuItem();
        jMenuBinarizacionPRomedio = new javax.swing.JMenu();
        jMenuPromBinGlobal = new javax.swing.JMenuItem();
        jMenuPromBinLocal = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItemZoom = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procesamiento Digital de Imagenes");

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar Gris");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Guardar RGB");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Operaciones");

        jMenuItem3.setText("umbral");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("negativo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        menuBrillo.setText("brillo RGB");
        menuBrillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBrilloActionPerformed(evt);
            }
        });
        jMenu2.add(menuBrillo);

        jMenuItem6.setText("brillo Gris");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        menuItemPseudoColor.setText("Pseudocolor");
        menuItemPseudoColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPseudoColorActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemPseudoColor);

        jMenuItemSuma.setText("Suma");
        jMenuItemSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSumaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSuma);

        jMenuItemResta.setText("Resta");
        jMenuItemResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRestaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemResta);

        jMenuBinarizacionPRomedio.setText("Binarizacion - Promedio");

        jMenuPromBinGlobal.setText("Global");
        jMenuPromBinGlobal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPromBinGlobalActionPerformed(evt);
            }
        });
        jMenuBinarizacionPRomedio.add(jMenuPromBinGlobal);

        jMenuPromBinLocal.setText("Local");
        jMenuPromBinLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPromBinLocalActionPerformed(evt);
            }
        });
        jMenuBinarizacionPRomedio.add(jMenuPromBinLocal);

        jMenu2.add(jMenuBinarizacionPRomedio);

        jMenu3.setText("BInarizacion - Hstograma");

        jMenuItem7.setText("Global");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenu2.add(jMenu3);

        jMenu4.setText("Invertir");

        jMenuItem8.setText("Horizontal");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Vertical");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenu2.add(jMenu4);

        jMenuItemZoom.setText("Zoom");
        jMenuItemZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemZoomActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemZoom);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        int valorRetorno = jFileChooser1.showOpenDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {
            File nombreImagen = jFileChooser1.getSelectedFile();
            path = nombreImagen.getAbsolutePath();
            imagen = new Imagen(path);

            try {
                JFrame f = new JFrame("Imagenes");
                f.setResizable(false);
                f.add(imagen);
                f.pack();
                f.setVisible(true);
            } catch (Exception e) {
            }
        } else {
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {
            File archivoImagen = jFileChooser1.getSelectedFile();

            imagen.guardarImagen(imagen.getMatrizImg(), archivoImagen.getAbsolutePath());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        imagen = new Imagen(path);
        int umbral = 150;
        Imagen.ventana(Algoritmos.operadorUmbral(imagen, umbral), "operador umbral");

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:

        imagen = new Imagen(path);
        Imagen.ventana(Algoritmos.operadorInverso(imagen), "operador umbral");

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {
            File archivoImagen = jFileChooser1.getSelectedFile();

            imagen.guardarImagen(imagen.getMatrizImg_R(), imagen.getMatrizImg_G(), imagen.getMatrizImg_B(), archivoImagen.getAbsolutePath());
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menuBrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBrilloActionPerformed
        BrilloGU frame = new BrilloGU();
        frame.setLocationRelativeTo(null);

        if (this.imagen != null) {
            frame.setImage(this.imagen);
            
            try {
                JFrame vistaPrevia = new JFrame("Brillo RGB");
                vistaPrevia.setResizable(false);
                vistaPrevia.add(this.imagen);
                vistaPrevia.pack();
                vistaPrevia.setVisible(true);
                
                frame.setVistaPrevia(vistaPrevia);
                
            } catch (Exception e) {
            }
            frame.setVisible(true);
            
        } else {
            System.out.println("Imagen no cargada");
        }


    }//GEN-LAST:event_menuBrilloActionPerformed

    private void menuItemPseudoColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPseudoColorActionPerformed
        imagen = new Imagen(path);
        Imagen.ventana(Algoritmos.pseudocolor(imagen), "Pseudocolor");
        
    }//GEN-LAST:event_menuItemPseudoColorActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        BrilloGrisGU frame = new BrilloGrisGU();
        frame.setLocationRelativeTo(null);

        if (this.imagen != null) {
            
            // COnvertir  gris
            this.imagen.convertirMatrizAImagen(this.imagen.matrizImg);
            
            frame.setImage(this.imagen);
            
            try {
                JFrame vistaPrevia = new JFrame("Brillo Escala de Grises");
                vistaPrevia.setResizable(false);
                vistaPrevia.add(this.imagen);
                vistaPrevia.pack();
                vistaPrevia.setVisible(true);
                
                frame.setVistaPrevia(vistaPrevia);
                
            } catch (Exception e) {
            }
            frame.setVisible(true);
            
        } else {
            System.out.println("Imagen no cargada");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItemSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSumaActionPerformed
        int valorRetorno = jFileChooser1.showOpenDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {
            File nombreImagen = jFileChooser1.getSelectedFile();
            String path2 = nombreImagen.getAbsolutePath();
            Imagen imagen2 = new Imagen(path2);

            try {
                JFrame f = new JFrame("Imagen 2");
                f.setResizable(false);
                f.add(imagen2);
                f.pack();
                f.setVisible(true);
                
                // Sumar imagenes
                Imagen imagen1 = new Imagen(this.path);
                Imagen imagenSuma = Algoritmos.suma(imagen1, imagen2);
                
                JFrame frameSuma = new JFrame("Suma de imagenes");
                frameSuma.setResizable(false);
                frameSuma.add(imagenSuma);
                frameSuma.pack();
                frameSuma.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        }
    }//GEN-LAST:event_jMenuItemSumaActionPerformed

    private void jMenuItemRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRestaActionPerformed
        int valorRetorno = jFileChooser1.showOpenDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {
            File nombreImagen = jFileChooser1.getSelectedFile();
            String path2 = nombreImagen.getAbsolutePath();
            Imagen imagen2 = new Imagen(path2);

            try {
                JFrame f = new JFrame("Imagen 2");
                f.setResizable(false);
                f.add(imagen2);
                f.pack();
                f.setVisible(true);
                
                // Restar imagenes
                Imagen imagen1 = new Imagen(this.path);
                Imagen imagenResta = Algoritmos.resta(imagen1, imagen2);
                
                JFrame frameSuma = new JFrame("Resta de imagenes");
                frameSuma.setResizable(false);
                frameSuma.add(imagenResta);
                frameSuma.pack();
                frameSuma.setVisible(true);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        }
    }//GEN-LAST:event_jMenuItemRestaActionPerformed

    private void jMenuPromBinGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPromBinGlobalActionPerformed
        Imagen img = new Imagen(this.path);
        
        Imagen.ventana(Algoritmos.binarizacionGrisPromedioGlobal(img), "Binarizacion Promedio - Global");
    }//GEN-LAST:event_jMenuPromBinGlobalActionPerformed

    private void jMenuPromBinLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPromBinLocalActionPerformed
        Imagen img = new Imagen(this.path);
        
        Imagen.ventana(Algoritmos.binarizacionGrisPromedioLocal(img), "Binarizacion Promedio - Local");
    }//GEN-LAST:event_jMenuPromBinLocalActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Imagen img = new Imagen(this.path);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItemZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemZoomActionPerformed
        Imagen img = new Imagen(this.path);

        Imagen.ventana(Algoritmos.escalamiento(img), "Zoom");
    }//GEN-LAST:event_jMenuItemZoomActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Imagen img = new Imagen(path);
        Imagen.ventana(Algoritmos.invertir(img, 'x'), "Invertir Horizontal");
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Imagen img = new Imagen(path);
        Imagen.ventana(Algoritmos.invertir(img, 'y'), "Invertir Vertical");
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuBinarizacionPRomedio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemResta;
    private javax.swing.JMenuItem jMenuItemSuma;
    private javax.swing.JMenuItem jMenuItemZoom;
    private javax.swing.JMenuItem jMenuPromBinGlobal;
    private javax.swing.JMenuItem jMenuPromBinLocal;
    private javax.swing.JMenuItem menuBrillo;
    private javax.swing.JMenuItem menuItemPseudoColor;
    // End of variables declaration//GEN-END:variables

}
