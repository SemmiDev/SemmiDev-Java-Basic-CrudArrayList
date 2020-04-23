// package program;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList buah = new ArrayList();
    static  boolean isRunning = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    static void showMenu() throws IOException{
        System.out.println("========= MENU =========");
        System.out.println("[1]  Show all buah");
        System.out.println("[2]  Insert Buah");
        System.out.println("[3]  Edit Buah");
        System.out.println("[4]  Deleter Buah");
        System.out.println("[5]  Exit");
        System.out.println("PILIH MENU> ");

        int selectedMenu = Integer.valueOf(input.readLine());
        switch (selectedMenu){
            case 1:
                showAllBuah();
                break;
            case 2:
                insertBuah();
                break;
            case 3:
                editBuah();
            case 4:
                deleteBuah();
            case 5:
                System.exit(0);
                break;
            default:
                System.err.println("Pilihan Anda Salah!");
        }
    }

    static void showAllBuah(){
        if(buah.isEmpty()){
            System.out.println("BUAH BELUM ADA, SILAHKAN TAMBAH TERLEBIH DAHULU");
        }else{
            for(int i = 0; i < buah.size(); i++){
                System.out.print("\t\t\t\t\t\t");
                System.out.println(String.format("[%d] %s",i,buah.get(i)));
            }
        }
    }
     static void insertBuah() throws IOException{

         boolean lanjut = true;
         while(lanjut){
             System.out.print("Nama Buah : ");
             String namaBuah = input.readLine();
             buah.add(namaBuah);
             lanjut = getYesorNo("");
         }
     }
    static boolean getYesorNo(String message) throws IOException{
        System.out.print("Apakah anda ingin menambah buah lagi? (y/n)");
        String question = input.readLine();
        System.out.print("\n" + message);

        while (!question.equalsIgnoreCase("y") && !question.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n" + message);
            question = input.readLine();
        }
        return question.equalsIgnoreCase("y");
    }

     static void editBuah() throws IOException{
        showAllBuah();
        System.out.print("Masukkan nomor buah yang akan diedit : ");
        int nomorBuah = Integer.valueOf(input.readLine());
        System.out.print("Masukkan nama buah yang baru : ");
        String buahBaru = input.readLine();

        buah.set(nomorBuah,buahBaru);
        showMenu();
     }

     static void deleteBuah() throws IOException {
        showAllBuah();
         System.out.print("Masukkan no buah yang ingin dihapus : ");
         int nomorHapusBuah = Integer.valueOf(input.readLine());
         buah.remove(nomorHapusBuah);
         showMenu();
     }

    public static void main(String[] args)throws IOException {
        do{
            showMenu();
        }while(isRunning);
    }

}
