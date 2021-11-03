import java.util.Scanner;

public class MAIN {

    public static void Menu() {
        System.out.println("\t\t1.Quản lý thông tin giảng viên");
        System.out.println("\t\t2.Quản lý thông tin môn học");
        System.out.println("\t\t3.Quản lý thông tin lớp tín chỉ");
        System.out.println("\t\t4.Thoát");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QUANLY ds = new QUANLY();
        System.out.println();
        System.out.println("======================== QUAN LY GIANG DAY CUA GIANG VIEN TAI KHOA CHUYEN MON TRUONG DAI HOC ======================");
        while (true) {
            System.out.println();
            Menu();
            System.out.print("Trả lời:");
            int n = scanner.nextInt();
            if (n == 1) {
                ds.QLGiangVien();
            } else if (n == 2) {
                ds.QLMonHoc();
            } else if (n == 3) {
                ds.QLTinChi();
            } else if (n == 4) {
                System.exit(0);
            } else {
                System.out.println("Vui lòng chọn câu trả lời trong khoảng 1->4");
            }
        }
    }
}
