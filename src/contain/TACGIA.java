package contain;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.String;

public class TACGIA {

    private String name = new String();
    private String email = new String();
    private char gioiTINH;
    Scanner keyboard = new Scanner(System.in);

    //HAM XAY DUNG MAC NHIEN;
    public TACGIA() {
        name = "unknow";
        email = "unknow";
        gioiTINH = 'F';
    }

    //HAM XAY DUNG DAY DU THAM SO;
    public TACGIA(String name, String email, char gioiTINH) {
        this.name = name;
        this.email = email;
        this.gioiTINH = gioiTINH;
    }

    //CAC HAM GET;
    public String getNAME() {
        return name;
    }

    public String getEMAIL() {
        return email;
    }

    public char getGIOITINH() {
        return gioiTINH;
    }

    //CAC HAM SET;
    public void setNAME(String name) {
        this.name = name;
    }

    public void setEMAIL(String email) {
        this.email = email;
    }

    public void setGIOITINH(char gioiTINH) {
        this.gioiTINH = gioiTINH;
    }

    //HAM NHAP TEN TAC GIA THU i CO TRONG MOT QUYEN SACH;
    public TACGIA nhapTEN(int i, TACGIA tacGIA) {
        System.out.println("NHAP VAO THONG TIN TAC GIA THU " + i + ":");
        System.out.print("TEN: ");
        this.name = keyboard.nextLine();
        tacGIA.name = this.name;
        return tacGIA;
    }

    //HAM NHAP CHI TIET THONG TIN TAC GIA THU i CO TRONG MOT QUYEN SACH;
    public TACGIA nhapCHITIET(TACGIA tacGIA) {
        //NHAP EMAIL TAC GIA;
        System.out.print("EMAIL: ");
        this.email = keyboard.nextLine();
        //NHAP GIOI TIH TAC GIA;
        int gioiTINHSO;
        while (true) {
            try {
                System.out.println("GIOI TINH:\tNAM- 1\tNU- 0");
                gioiTINHSO = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                continue;
            } finally {
                keyboard.nextLine();
            }
            if (gioiTINHSO == 0) {
                this.gioiTINH = 'F';
                break;
            } else if (gioiTINHSO == 1) {
                this.gioiTINH = 'M';
                break;
            } else {
                System.out.println("NHAP VAO 1 HOAC 0 THEO YEU CAU;");
            }
        }
        //LUU THONG TIN TAC GIA;
        tacGIA.email = this.email;
        tacGIA.gioiTINH = this.gioiTINH;
        return tacGIA;
    }

    //HAM HIEN THI THONG TIN TAC GIA CUA MOT QUYEN SACH;
    public void hienTHI() {
        System.out.println("*\n" + name);
        System.out.println("EMAIL: " + email);
        System.out.println("GIOITINH: " + gioiTINH);
    }
}
