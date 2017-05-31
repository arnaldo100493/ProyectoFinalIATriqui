
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FABAME
 */
public class Triqui extends JFrame {

    private ImageIcon imagenX = new ImageIcon("equis.png");
    private ImageIcon imagen0 = new ImageIcon("cero.png");
    private ImageIcon imagenL = new ImageIcon("limpio.png");

    private static String simboloPC = "0";
    private static String simboloHumano = "X";
    private static String simboloLibre = "_";

    private static TriquiEspacio triqui = new TriquiEspacio(simboloPC, simboloHumano, simboloLibre);
    private static String[] resultado = new String[3];
    private int[] posicionMejor = new int[4];

    //Aleatorio entre 1,3,7,9
    private Random ri = new Random();
    private String ubica = "";
    private int posicion = 0;
    private int jugadas = 0;
    private int postgana = -1;
    private int ganaHumano = -1;

    /**
     * Creates new form Triqui
     */
    public Triqui() {
        //setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        initComponents();
        this.setTitle("Triqui");
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);

    }

    private void colocarImagen(int posicion, ImageIcon img) {
        switch (posicion) {

            case 1:
                this.button1.setIcon(img);
                break;
            case 2:
                this.button2.setIcon(img);
                break;
            case 3:
                this.button3.setIcon(img);
                break;
            case 4:
                this.button4.setIcon(img);
                break;
            case 5:
                this.button5.setIcon(img);
                break;
            case 6:
                this.button6.setIcon(img);
                break;
            case 7:
                this.button7.setIcon(img);
                break;
            case 8:
                this.button8.setIcon(img);
                break;
            case 9:
                this.button9.setIcon(img);
                break;
        }

    }

    private void juegaPC() {
        triqui.buscarLibres();
        this.postgana = -1;
        this.ganaHumano = -1;

        this.postgana = triqui.busquedaVertical(simboloPC);
        if (this.postgana == -1) {
            this.postgana = triqui.busquedaHorizontal(simboloPC);
        }

        if (this.postgana == -1) {
            this.postgana = triqui.busquedaDiagonal(simboloPC);
        }

        triqui.imprimirLibres();
        //Gana humano?
        this.ganaHumano = triqui.busquedaVertical(simboloHumano);
        if (this.ganaHumano == -1) {
            this.ganaHumano = triqui.busquedaHorizontal(simboloHumano);
        }

        if (this.ganaHumano == -1) {
            this.ganaHumano = triqui.busquedaDiagonal(simboloHumano);
        }

        int ubicar = 0;
        this.posicion = 0;

        if (this.postgana > 0) {
            triqui.ubicar(this.postgana, simboloPC);
            ubicar = this.postgana;
            this.posicion = this.postgana;
        } else if (this.ganaHumano > 0) {
            triqui.ubicar(this.ganaHumano, simboloPC);
            ubicar = this.ganaHumano;
            this.posicion = this.ganaHumano;
        } else if ((this.postgana == -1 || this.postgana == 0) || (this.ganaHumano < 0 || this.ganaHumano == 0)) {
            triqui.buscarLibres();
            if (triqui.generarJugada() == -1) {
                this.posicion = this.ri.nextInt(triqui.getLibres()) + 1;
                this.posicion = triqui.getPosicionesLibres(this.posicion - 1);
                triqui.ubicar(this.posicion, simboloPC);
            } else {
                if (this.jugadas == 0) {
                    this.posicionMejor[0] = 2;
                    this.posicionMejor[1] = 4;
                    this.posicionMejor[2] = 6;
                    this.posicionMejor[3] = 8;
                    this.posicion = this.posicionMejor[this.ri.nextInt(4)];
                    triqui.ubicar(posicion, simboloPC);
                } else {
                    this.posicion = triqui.generarJugada();
                    triqui.ubicar(triqui.generarJugada(), simboloPC);
                }
            }
        }

        //if
        this.colocarImagen(this.posicion, this.imagen0);
        /**
         * ********** Imagen ***************
         */
        this.jugadas++;
        triqui.presentar();
        triqui.buscarLibres();

    }

    private void button1() {
        this.colocarImagen(1, this.imagenX);
        triqui.ubicar(1, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button2() {
        this.colocarImagen(2, this.imagenX);
        triqui.ubicar(2, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button3() {
        this.colocarImagen(3, this.imagenX);
        triqui.ubicar(3, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button4() {
        this.colocarImagen(4, this.imagenX);
        triqui.ubicar(4, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button5() {
        this.colocarImagen(5, this.imagenX);
        triqui.ubicar(5, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button6() {
        this.colocarImagen(6, this.imagenX);
        triqui.ubicar(6, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button7() {
        this.colocarImagen(7, this.imagenX);
        triqui.ubicar(7, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button8() {
        this.colocarImagen(8, this.imagenX);
        triqui.ubicar(8, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void button9() {
        this.colocarImagen(9, this.imagenX);
        triqui.ubicar(9, simboloHumano);
        this.jugadas++;
        triqui.presentar();
    }

    private void juegoNuevo() {
        triqui = new TriquiEspacio(simboloPC, simboloHumano, simboloLibre);
        this.jugadas = 0;
        triqui.buscarLibres();
        this.button1.setIcon(imagenL);
        this.button2.setIcon(imagenL);
        this.button3.setIcon(imagenL);
        this.button4.setIcon(imagenL);
        this.button5.setIcon(imagenL);
        this.button6.setIcon(imagenL);
        this.button7.setIcon(imagenL);
        this.button8.setIcon(imagenL);
        this.button9.setIcon(imagenL);
    }

    private void salir() {
        this.dispose();
    }

    /*private void crearIcono() {
        Image imagen = null;

        try {
            imagen = ImageIO.read(getClass().getResource("/imagenes/icono.png"));
        } catch (IOException ex) {
            Logger.getLogger(Triqui.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(imagen);
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        buttonJuegaPC = new javax.swing.JButton();
        buttonNuevoJuego = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Juego Triqui");

        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        buttonJuegaPC.setText("Juega PC");
        buttonJuegaPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJuegaPCActionPerformed(evt);
            }
        });

        buttonNuevoJuego.setText("Nuevo Juego");
        buttonNuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoJuegoActionPerformed(evt);
            }
        });

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonJuegaPC)
                .addGap(18, 18, 18)
                .addComponent(buttonNuevoJuego)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonJuegaPC)
                    .addComponent(buttonNuevoJuego)
                    .addComponent(buttonSalir))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        this.button1();
    }//GEN-LAST:event_button1ActionPerformed

    private void buttonJuegaPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJuegaPCActionPerformed
        // TODO add your handling code here:
        this.juegaPC();
    }//GEN-LAST:event_buttonJuegaPCActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        this.button2();
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        this.button3();
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        this.button4();
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        this.button5();
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        this.button6();
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        this.button7();
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:
        this.button8();
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:
        this.button9();
    }//GEN-LAST:event_button9ActionPerformed

    private void buttonNuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevoJuegoActionPerformed
        // TODO add your handling code here:
        this.juegoNuevo();
    }//GEN-LAST:event_buttonNuevoJuegoActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        // TODO add your handling code here:
        this.salir();
    }//GEN-LAST:event_buttonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Triqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Triqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Triqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Triqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Triqui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonJuegaPC;
    private javax.swing.JButton buttonNuevoJuego;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
