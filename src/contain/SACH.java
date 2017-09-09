package contain;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.String;

public class SACH {

    private String name = new String();
    private TACGIA[] tacGIA = new TACGIA[5];
    private double gia;
    private int soLUONG;
    private int soTACGIA;
    Scanner keyboard = new Scanner(System.in);

    //HAM XAY DUNG MAC NHIEN;
    public SACH() {
        this.name = "unknown";
        for (int i = 0; i < 5; i++) {
            this.tacGIA[i] = new TACGIA();
        }
        gia = 0;
        soLUONG = 0;
    }

    //HAM XAY DUNG DAY DU THAM SO;
    public SACH(String name, TACGIA[] tacGIA, double gia, int soLUONG) {
        this.name = name;
        this.tacGIA = tacGIA;
        this.gia = gia;
        this.soLUONG = soLUONG;
    }

    //CAC HAM GET;
    public String getNAME() {
        return name;
    }

    public TACGIA[] getTACGIA() {
        return tacGIA;
    }

    public double getGIA() {
        return gia;
    }

    public int getSOLUONG() {
        return soLUONG;
    }

    public int getSOTACGIA() {
        return soTACGIA;
    }

    //CAC HAM SET;
    public void setNAME(String name) {
        this.name = name;
    }

    public void setTACGIA(TACGIA[] tacGIA) {
        this.tacGIA = tacGIA;
    }

    public void setGIA(double gia) {
        this.gia = gia;
    }

    public void setSOLUONG(int soLUONG) {
        this.soLUONG = soLUONG;
    }

    //HAM NHAP TEN MOT QUYEN SACH;
    public void nhapTEN() {
        System.out.print("TEN SACH: ");
        name = keyboard.nextLine();
    }

    //HAM NHAP THONG TIN TAC GIA CHO MOI QUYEN SACH;
    public int nhapTACGIA(TACGIA mangTACGIA[], int tongTACGIA) {
        //NHAP TEN TAC GIA;
        while (true) {
            //XU LY NGOAI LE;
            try {
                System.out.print("QUYEN SACH NAY CO BAO NHIEU TAC GIA? ");
                soTACGIA = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                continue;
            } finally {
                keyboard.nextLine();
            }
            //KIEM SOAT SO LUONG TAC GIA CUA MOT QUYEN SACH;
            if (soTACGIA > 5 || soTACGIA == 0) {
                System.out.println("CHO PHEP MOI QUYEN SACH NHIEU NHAT CHI 5 TAC GIA;");
                continue;
            }
            break;
        }
        //KHOI TAO TUNG TAC GIA;
        for (int j = 0; j < soTACGIA; j++) {
            tacGIA[j] = new TACGIA();
        }
        //NHAP TAC GIA;
        boolean bool;
        for (int j = 0; j < soTACGIA; j++) {
            bool = true;
            //NHAP TEN TAC GIA DAU TIEN CO TRONG QUYEN SACH;
            if (j == 0) {
                tacGIA[0] = tacGIA[0].nhapTEN(0 + 1, tacGIA[0]);
            } else {
                //NHAP TEN CAC TAC GIA CON LAI VA LOAI TAC GIA TRUNG TEN; 
                while (bool) {
                    tacGIA[j] = tacGIA[j].nhapTEN(j + 1, tacGIA[j]);
                    for (int k = 0; k < j; k++) {
                        if (bool = tacGIA[j].getNAME().equals(tacGIA[k].getNAME())) {
                            System.out.println("NHAP LAI, VI TRUNG TEN TAC GIA;");
                            break;
                        }
                    }
                    if (!bool) {
                        break;
                    }
                }
            }
            //LAY THONG TIN(NEU CO) TAC GIA TU mangTACGIA[] DA DUOC LUU TRUOC DO;
            bool = false;
            for (int t = 0; t < tongTACGIA; t++) {
                if (bool = mangTACGIA[t].getNAME().equals(tacGIA[j].getNAME())) {
                    System.out.println("THONG TIN TAC GIA DA CO;");
                    tacGIA[j].setEMAIL(mangTACGIA[t].getEMAIL());
                    tacGIA[j].setGIOITINH(mangTACGIA[t].getGIOITINH());
                    break;
                }
            }
            //NHAP CHI TIET THONG TIN MOI TAC GIA;
            if (!bool) {
                tacGIA[j] = tacGIA[j].nhapCHITIET(tacGIA[j]);
                mangTACGIA[tongTACGIA++] = tacGIA[j];
            }
        }
        //TRA VE SO LUONG TAC GIA DA DUOC LUU TRU TRONG mangTACGIA[];
        return tongTACGIA;
    }

    //NHAP CHI TIET THONG QUYEN SACH;
    public void nhapCHITIET() {
        //NHAP GIA SACH;
        while (true) {
            //XU LY NGOAI LE;
            try {
                System.out.print("GIA SACH LA: ");
                gia = keyboard.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                continue;
            } finally {
                keyboard.nextLine();
            }
            //DIEU KIEN GIA SACH;
            if (gia < 0) {
                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                continue;
            }
            break;
        }
        //NHAP SO LUONG MOI QUYEN SACH;
        while (true) {
            //XU LY NGOAI LE;
            try {
                System.out.print("SO LUONG QUYEN SACH NAY: ");
                soLUONG = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                continue;
            } finally {
                keyboard.nextLine();
            }
            //DIEU KIEN SO LUONG CUA MOT QUYEN SACH;
            if (soLUONG <= 0) {
                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                continue;
            }
            break;
        }
        System.out.println();
    }

    //HAM HIEN THI THONG TIN CUA QUYEN SACH THU i;
    public void hienTHI(int i) {
        System.out.println("QUYEN SACH THU " + i + ":");
        System.out.println("TEN SACH: " + name);
        System.out.println("TAC GIA:");
        for (int j = 0; j < soTACGIA; j++) {
            tacGIA[j].hienTHI();
        }
        System.out.println("*\nGIA: " + gia);
        System.out.println("SO LUONG: " + soLUONG);
        System.out.println("------------------------------");
    }
}
