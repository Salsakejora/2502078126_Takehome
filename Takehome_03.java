/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package takehome_03;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

/**
 *
 * @author ASUS
 */
public class Takehome_03 extends javax.swing.JFrame {
    
    private DefaultTableModel Tabel;
    private JLabel Penyimpanan;
    private double availableCapacity = 100.0;
    /**
     * Creates new form Takehome_03
     */
   private Takehome_03() {
        setTitle("");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Tabel = new DefaultTableModel();
        Tabel.addColumn("Filename");
        Tabel.addColumn("Extension");
        Tabel.addColumn("Size (GB)");

        
        JTable table = new JTable(Tabel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JTextField filenameField = new JTextField(15);
        JTextField extensionField = new JTextField(5);
        JTextField sizeField = new JTextField(5);
        JButton saveButton = new JButton("Save");

        Penyimpanan = new JLabel("Available Disk Capacity: " + formatCapacity(availableCapacity) + " GB");
        inputPanel.add(new JLabel("Filename: "));
        inputPanel.add(filenameField);
        inputPanel.add(new JLabel("Extension: "));
        inputPanel.add(extensionField);
        inputPanel.add(new JLabel("Size (GB): "));
        inputPanel.add(sizeField);
        inputPanel.add(saveButton);
        inputPanel.add(Penyimpanan);

        add(inputPanel, BorderLayout.SOUTH);

        saveButton.addActionListener((ActionEvent e) -> {
            String filename = filenameField.getText().trim();
            String extension = extensionField.getText().trim();
            String sizeText = sizeField.getText().trim();
            
            if (filename.isEmpty() || extension.isEmpty() || sizeText.isEmpty()) {
                JOptionPane.showMessageDialog(Takehome_03.this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                double size = Double.parseDouble(sizeText);
                if (size <= 0) {
                    throw new NumberFormatException();
                }
                
                if (size > availableCapacity) {
                    JOptionPane.showMessageDialog(Takehome_03.this, "Penyimpanan Tidak Cukup!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Tabel.addRow(new Object[]{filename, extension, size});
                availableCapacity -= size;
                Penyimpanan.setText("Available Disk Capacity: " + formatCapacity(availableCapacity) + " GB");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Takehome_03.this, "Invalid size value!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private String formatCapacity(double capacity) {
        DecimalFormat format = new DecimalFormat("#.##");
        return format.format(capacity);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Takehome_03 app = new Takehome_03();
            app.setVisible(true);
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
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

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
