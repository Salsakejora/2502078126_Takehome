/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penjualan;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
abstract class Penjualan {
    protected String orderId;
    protected String type;
    protected double totalHarga;

    public Penjualan(String type, double totalHarga) {
        this.orderId = generateOrderId();
        this.type = type;
        this.totalHarga = totalHarga;
    }

    protected String generateOrderId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder orderIdBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            orderIdBuilder.append(characters.charAt(index));
        }
        return orderIdBuilder.toString();
    }

    public abstract double hitungBiayaLayanan();
}

class PenjualanFisik extends Penjualan {
    public PenjualanFisik(double totalHarga) {
        super("fisik", totalHarga);
    }

    @Override
    public double hitungBiayaLayanan() {
        if(totalHarga > 1000000){
            return 5000;
        }
        return 0.005 * totalHarga;
    }
}

class PenjualanJasa extends Penjualan {
    public PenjualanJasa(double totalHarga) {
        super("jasa", totalHarga);
    }

    @Override
    public double hitungBiayaLayanan() {
        
        return 2000;
    }
}

class PenjualanDigital extends Penjualan {
    public PenjualanDigital(double totalHarga) {
        super("digital", totalHarga);
    }

    @Override
    public double hitungBiayaLayanan() {
        if(totalHarga > 1000000){
            return 3000;
        }
        return 0.001 * totalHarga + 2000;
    }
}

public class Takehome_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Penjualan> daftarPenjualan = new ArrayList<>();

          boolean run = true;
          Scanner input = new Scanner(System.in);
          
//          System.out.print("/n");
          while(run){
            System.out.print("Ingin Input Data Penjualan [Y / T]: ");
            String D = input.nextLine(); 
                    if(D.equalsIgnoreCase("T")){
                      run = false;
                      System.out.println("Data Penjualan:");
                        for (int i = 0; i < daftarPenjualan.size(); i++) {
                            Penjualan penjualan = daftarPenjualan.get(i);
                            double biayaLayanan = penjualan.hitungBiayaLayanan();
                            System.out.println((i + 1) + ". " + penjualan.orderId + " - " + penjualan.type + " - " +
                               penjualan.totalHarga + " - " + biayaLayanan);
                        }
                  }
                    if(D.equalsIgnoreCase("Y")){
                        System.out.print("Type Penjualan [Jasa / Fisik / Digital]: ");
                        String T = input.nextLine();
                        System.out.print("Harga: ");
                        double H = input.nextDouble();
                        if(T.equalsIgnoreCase("jasa")){
                            daftarPenjualan.add(new PenjualanJasa(H));
                        }else if (T.equalsIgnoreCase("fisik")){
                            daftarPenjualan.add(new PenjualanFisik(H));
                        }else if (T.equalsIgnoreCase("digital")){
                            daftarPenjualan.add(new PenjualanDigital(H));
                        }else{
                            System.out.print("Tidak termasuk dalam pilihan type penjualan ");
                        }                 
                    }
          }
    }
}
