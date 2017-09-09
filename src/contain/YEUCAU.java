package contain;

/*
    GIOI HAN CUA CHUONG TRINH,
        +CHAP NHAN TOI DA 10 QUYEN SACH KHAC NHAU(THEO TEN SACH);
        +MOI QUYEN SACH CO NHIEU NHAT 5 TAC GIA KHAC NHAU(THEO TEN TAC GIA);
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.String;

public class YEUCAU {
//HAM MAIN() THUC HIEN CAC YEU CAU;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        SACH[] mangSACH = new SACH[10];
        int soSACH;
        SACH[] muaSACH = new SACH[10];
        int soSACHMUA;
        TACGIA[] mangTACGIA = new TACGIA[50];
        int tongTACGIA = 0;
        int[] mangSOLUONG = new int[10];
        double thanhTIEN = 0;
        for (int i = 0; i < 50; i++) {
            mangTACGIA[i] = new TACGIA();
        }
        //**************YEU CAU 1: NHAP VAO MOT MANG SACH?**************;
        //NHAP VAO SO LUONG SACH KHAC NHAU;
        while (true) {
            try {
                System.out.println("CO TAT CA BAO NHIEU QUYEN SACH?");
                soSACH = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                continue;
            } finally {
                keyboard.nextLine();
            }
            break;
        }
        //RANG BUOC BAN DAU VE SO QUYEN SACH CO THE NHAP;
        if (soSACH > 0 && soSACH <= 10) {
            //KHOI TAO BAN DAU CHO TUNG QUYEN SACH;
            for (int i = 0; i < soSACH; i++) {
                mangSACH[i] = new SACH();
            }
            //NHAP THONG TIN LAN LUOT CHO MOI QUYEN SACH;
            boolean bool;
            for (int i = 0; i < soSACH; i++) {
                System.out.println("THONG TIN QUYEN SACH THU " + (i + 1) + ":");
                //NHAP THONG TIN QUYEN SACH DAU TIEN;
                if (i == 0) {
                    mangSACH[0].nhapTEN();
                } //NHAP THONG TIN CAC QUYEN SACH CON LAI;
                else {
                    bool = true;
                    //KIEM TRA XEM QUYEN SACH DA DUOC NHAP CHUA(TRUNG TEN SACH?);
                    while (bool) {
                        mangSACH[i].nhapTEN();
                        for (int j = 0; j < i; j++) {
                            if (bool = mangSACH[j].getNAME().equals(mangSACH[i].getNAME())) {
                                System.out.println("QUYEN SACH NAY DA DUOC NHAP;");
                                break;
                            }
                        }
                        if (!bool) {
                            break;
                        }
                    }
                }
                //NHAP TAC GIA CHO SACH;
                tongTACGIA = mangSACH[i].nhapTACGIA(mangTACGIA, tongTACGIA);
                //NHAP CHI TIET SO LUONG VA GIA CUA SACH;
                mangSACH[i].nhapCHITIET();
            }
            //HIEN THI DANH SACH CAC QUYEN SACH DA DUOC NHAP;
            System.out.println();
            for (int i = 0; i < soSACH; i++) {
                mangSACH[i].hienTHI(i + 1);
            }
            //LUU TRU SO LUONG MOI QUYEN SACH VAO MANG TRUNG GIAN: mangSOLUONG[];
            for (int i = 0; i < soSACH; i++) {
                mangSOLUONG[i] = mangSACH[i].getSOLUONG();
            }
            //**************YEU CAU 2: MO PHONG MOT NGUOI DUNG MUA TU CHUONG TRINH**************;
            //NHAN GIA TRI SO QUYEN SACH CAN MUA;
            System.out.println("\nHAY CHO BIET SO QUYEN SACH MUON MUA\n(KHAC NHAU THEO TEN CO TRONG DANH SACH)");
            while (true) {
                //XU LY NGOAI LE;
                try {
                    System.out.println("CO TAT CA BAO NHIEU QUYEN SACH?");
                    soSACHMUA = keyboard.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                    continue;
                } finally {
                    keyboard.nextLine();
                }
                //KIEM SOAT SO LUONG SACH(KHAU NHAU) CO THE MUA;
                if (soSACHMUA <= 0 || soSACHMUA > soSACH) {
                    System.out.println("CHO PHEP MUA TOI DA " + soSACH + " QUYEN SACH;");
                    continue;
                }
                break;
            }
            //NHAP TEN CAC QUYEN SACH CAN MUA;
            System.out.println("CHO BIET TEN CAC QUYEN SACH CAN MUA\n-----------------------------------");
            for (int i = 0; i < soSACHMUA; i++) {
                muaSACH[i] = new SACH();
                bool = false;
                System.out.print("TEN QUYEN THU " + (i + 1) + ": ");
                muaSACH[i].setNAME(keyboard.nextLine());
                //KIEM TRA XEM CO SACH DE BAN HAY KHONG?
                for (int j = 0; j < soSACH; j++) {
                    if (bool = muaSACH[i].getNAME().equals(mangSACH[j].getNAME())) {
                        //CO DUNG QUYEN SACH CAN MUA
                        muaSACH[i].setNAME(mangSACH[j].getNAME());
                        muaSACH[i].setGIA(mangSACH[j].getGIA());
                        muaSACH[i].setTACGIA(mangSACH[j].getTACGIA());
                        //CHO BIET SO LUONG, MUON MUA BAO NHIEU QUYEN LOAI NAY?
                        while (true) {
                            try {
                                System.out.print("CAN MUA BAO NHIEU QUYEN SACH NAY: ");
                                muaSACH[i].setSOLUONG(keyboard.nextInt());
                            } catch (InputMismatchException e) {
                                System.out.println("KHONG HOP LE, MOI NHAP LAI;");
                                continue;
                            } finally {
                                keyboard.nextLine();
                            }
                            //RANG BUOC SO LUONG SACH CO THE BAN; 
                            if (muaSACH[i].getSOLUONG() < 0 || muaSACH[i].getSOLUONG() > mangSACH[j].getSOLUONG()) {
                                System.out.println("CHO PHEP MUA TOI DA " + mangSACH[j].getSOLUONG() + " QUYEN NAY;");
                                continue;
                            }
                            break;
                        }
                        //LAY SO LUONG CON LAI CUA QUYEN SACH TREN; 
                        mangSOLUONG[j] -= muaSACH[i].getSOLUONG();
                        System.out.println();
                        break;
                    }
                }
                //KHI KHONG CO DUNG QUYEN SACH CAN MUA;
                if (!bool) {
                    System.out.println("XIN LOI, CHUNG TOI KHONG CO QUYEN SACH NAY;");
                    i--;
                    System.out.println("CHUNG TOI SE BAN CHO BAN CHI " + (--soSACHMUA) + " QUYEN SACH;\n");
                }
            }
            //CAP NHAT LAI SO LUONG CAC QUYEN SACH CO TRONG mangSACH[] SAU KHI MUA BAN;
            for (int i = 0; i < soSACH; i++) {
                mangSACH[i].setSOLUONG(mangSOLUONG[i]);
            }
            //IN HOA DON MUA SACH CHO NGUOI DUNG;
            System.out.println("\n-------HOA DON MUA SACH-------");
            int j = 0;
            for (int i = 0; i < soSACHMUA; i++) {
                muaSACH[i].hienTHI(++j);
                thanhTIEN += muaSACH[i].getSOLUONG() * muaSACH[i].getGIA();
            }
            //TINH TONG TIEN PHAI TRA;
            System.out.println("TONG TIEN LA: " + thanhTIEN + ".\n************CAM ON************");
        } //KHI SO QUYEN SACH CAN NHAP > 10;
        else {
            System.out.println("DAU VAO CUA TONG SO SACH GAP VAN DE.\nTHE END!");
        }
    }
}
