/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.util.Random;
/**
 *
 * @author Kevin Eduardo Gonzalez Sosa
 *          9959-22-2702
 */
public class Campeonatos extends javax.swing.JFrame {

    private String[] equipos;
    private int[][] resultados;
    
    public Campeonatos() {
        initComponents();
        equipos = new String[6];
        resultados = new int[6][6];
    }
    
    private int generarNumeroAleatorio(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private void simularPartidos() {
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                int golesEquipoLocal = generarNumeroAleatorio(0, 10);
                int golesEquipoVisitante = generarNumeroAleatorio(0, 10);
                resultados[i][j] = golesEquipoLocal;
                resultados[j][i] = golesEquipoVisitante;
            }
        }
    }

    private int[] calcularPuntos() {
        int[] puntos = new int[equipos.length];
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++) {
                if (i != j) {
                    if (resultados[i][j] != -1 || resultados[j][i] != -1) {
                        if (resultados[i][j] > resultados[j][i]) {
                            puntos[i] += 3; // Equipo i gana
                        } else if (resultados[i][j] < resultados[j][i]) {
                            puntos[j] += 3; // Equipo j gana
                        } else {
                            puntos[i] += 1; // Empate
                            puntos[j] += 1;
                        }
                    }
                }
            }
        }
        return puntos;
    }

    private void mostrarTabla() {
        int[] puntos = calcularPuntos();
        String tabla = "Tabla de Posiciones:\n";
        tabla += "Equipo\tPartidos\tGanados\tEmpatados\tPerdidos\tPuntos\n";
        for (int i = 0; i < equipos.length; i++) {
            int partidosJugados = 0;
            int partidosGanados = 0;
            int partidosEmpatados = 0;
            int partidosPerdidos = 0;
            for (int j = 0; j < equipos.length; j++) {
                if (i != j) {
                    if (resultados[i][j] != -1 || resultados[j][i] != -1) {
                        partidosJugados++;
                        if (resultados[i][j] > resultados[j][i]) {
                            partidosGanados++;
                        } else if (resultados[i][j] < resultados[j][i]) {
                            partidosPerdidos++;
                        } else {
                            partidosEmpatados++;
                        }
                    }
                }
            }
            tabla += equipos[i] + "\t" + partidosJugados + "\t\t" + partidosGanados + "\t"
                    + partidosEmpatados + "\t\t" + partidosPerdidos + "\t\t" + puntos[i] + "\n";
        }
        System.out.println(tabla);
    }
    
    private void borrarEquipos() {
        for (int i = 0; i < equipos.length; i++) {
            equipos[i] = null;
        }
        for (int i = 0; i < resultados.length; i++) {
            for (int j = 0; j < resultados[i].length; j++) {
                resultados[i][j] = 0;
            }
        }
        System.out.println("Se han borrado todos los equipos.");
    }

    private String equipoGanador() {
        int[] puntos = calcularPuntos();
        int maxPuntos = 0;
        int indiceEquipo = 0;
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] > maxPuntos) {
                maxPuntos = puntos[i];
                indiceEquipo = i;
            }
        }
        return equipos[indiceEquipo];
    }

    private String equipoBaja() {
        int[] puntos = calcularPuntos();
        int minPuntos = puntos[0];
        int indiceEquipo = 0;
        for (int i = 1; i < puntos.length; i++) {
            if (puntos[i] < minPuntos) {
                minPuntos = puntos[i];
                indiceEquipo = i;
            }
        }
        return equipos[indiceEquipo];
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Equipos de un campeonato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel1)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(326, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Campeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Campeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Campeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Campeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Campeonatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
