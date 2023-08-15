/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package takehome_02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class Takehome_02 extends javax.swing.JFrame {

    
   public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Reservasi();
            }
        });
    }

    private static void Reservasi() {
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(5, 3,20,10));
        frame.setLocationRelativeTo(null);
        
        JLabel Judul = new JLabel("Form Reservasi");
        JLabel Space = new JLabel("");
        Judul.setBounds(300, 400, 400, 30);
        Judul.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(Judul);
        frame.add(Space);
        
        JLabel Hari = new JLabel("Pilih Hari");
        Hari.setBounds(300, 100, 400, 30);
        frame.add(Hari);
        String[] options = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat","Sabtu", "Minggu"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        frame.add(comboBox);
        
        JLabel Dewasa = new JLabel("Jumlah Orang Dewasa");
        Dewasa.setBounds(300, 100, 400, 30);
        frame.add(Dewasa);
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1); // Nilai awal, nilai minimum, nilai maksimum, langkah
        JSpinner JumlahD = new JSpinner(spinnerModel);
        frame.add(JumlahD);
        
        JLabel Anak = new JLabel("Jumlah anak-anak");
        frame.add(Anak);
        SpinnerModel spinnerModel1 = new SpinnerNumberModel(0, 0, 100, 1); // Nilai awal, nilai minimum, nilai maksimum, langkah
        JSpinner JumlahA = new JSpinner(spinnerModel1);
        frame.add(JumlahA);
        
        JButton Submit = new JButton("Submit");
        frame.add(Submit);
        
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and show a custom dialog using JOptionPane
                    String PilihanHari = (String) comboBox.getSelectedItem();
                    int TotalD = (int) JumlahD.getValue();
                    int TotalA = (int) JumlahA.getValue();
                    int HargaDewasa;
                    int HargaAnak;
                    
                    if(PilihanHari.equals("Senin") || PilihanHari.equals("Selasa")|| PilihanHari.equals("Rabu")|| PilihanHari.equals("Kamis")){
                        HargaDewasa = 150000;
                        HargaAnak = 70000;
                    }else if(PilihanHari.equals("Jumat")){
                        HargaDewasa = 180000;
                        HargaAnak = 90000;
                    }else{
                        HargaDewasa = 250000;
                        HargaAnak = 125000;
                    }
                    
                    
                    int harga = TotalD * HargaDewasa + TotalA * HargaAnak;
                    
                   JOptionPane.showMessageDialog(frame, "Total Harga : " + harga + ", Apakah anda setuju ?", "Alert", JOptionPane.INFORMATION_MESSAGE); 
//                String name = JOptionPane.showInputDialog(frame, "Enter your name:", "Name Dialog", JOptionPane.PLAIN_MESSAGE);
//                if (name != null && !name.isEmpty()) {
//                    JOptionPane.showMessageDialog(frame, "Hello, " + name + "!", "Greeting", JOptionPane.INFORMATION_MESSAGE);
//                }
            }
        });
        
        JButton Clear = new JButton("Clear");
        frame.add(Clear);
        
        Clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and show a custom dialog using JOptionPane
                    JumlahD.setValue(0);
                    JumlahA.setValue(0);
            }
        });
        
        frame.setVisible(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

}
