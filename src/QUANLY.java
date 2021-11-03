import java.io.IOException;
import java.util.Scanner;

public class QUANLY {
    DSGV gv = new DSGV();
    DSMH mh = new DSMH();
    DSTC tc = new DSTC();

    Scanner scanner = new Scanner(System.in);

    public void MenuGv() {
        System.out.println("1.Nhập thông tin giảng viên");
        System.out.println("2.Hiển thị thông tin giảng viên");
        System.out.println("3.Sắp xếp thông tin giảng viên theo tên");
        System.out.println("4.Xóa thông tin giảng viên");
        System.out.println("5.Thêm thông tin giảng viên");
        System.out.println("6.Ghi file thông tin giảng viên");
        System.out.println("7.Đọc file thông tin giảng viên");
        System.out.println("8.Tìm kiếm thông tin giảng viên");
        System.out.println("9.Quay lại");
    }

    public void QLGiangVien() {
        int n;
        do {
            MenuGv();
            System.out.print("==>Trả lời:");
            n = scanner.nextInt();
            if (n == 1) {
                gv.nhapGv();
                System.out.println();
            } else if (n == 2) {
                gv.xuatGv();
            } else if (n == 3) {
                gv.sapXeptheoTen();
            } else if (n == 4) {
                gv.xoaGv();
            } else if (n == 5) {
                gv.themGv();
            } else if (n == 6) {
                try {
                    gv.ghifile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (n == 7) {
                try {
                    gv.xuatFile(gv.docFile());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println();
            } else if (n == 8) {
                scanner.nextLine();
                System.out.print("Nhập mã giảng viên:");
                String ma = scanner.nextLine();
                NGUOI a;
                System.out.println("==>Thông tin giảng viên cần tìm:");
               gv.timKiem(ma).hienThongTin();
                System.out.println();
            } else if (n != 9) {
                System.out.println("Vui lòng chọn trong khoảng từ 1->9");
            }
        } while (n != 9);
    }

    public void MenuMH() {
        System.out.println("1.Nhập thông tin môn học");
        System.out.println("2.Hiển thị thông tin môn học");
        System.out.println("3.Xóa thông tin môn học");
        System.out.println("4.Thêm thông tin môn học");
        System.out.println("5.Ghi file thông tin môn học");
        System.out.println("6.Dọc file thông tin môn học");
        System.out.println("7.Tìm kiếm môn học");
        System.out.println("8.Quay lại");
    }

    public void QLMonHoc() {
        int n;
        do {
            MenuMH();
            System.out.print("==>Trả lời:");
            n = scanner.nextInt();
            if (n == 1) {
                mh.nhapMon();
                System.out.println();
            } else if (n == 2) {
                mh.xuatMon();
                System.out.println();
            } else if (n == 3) {
                mh.xoaMH();
                System.out.println();
            } else if (n == 4) {
                mh.themMH();
                System.out.println();
            } else if (n == 5) {
                try {
                    mh.ghiFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (n == 6) {
                try {
                    mh.xuatFile(mh.docFile());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (n == 7) {
                scanner.nextLine();
                System.out.print("Nhập mã môn học cần tìm:");
                String ma = scanner.nextLine();
                System.out.println("==>Thông tin môn học cần tìm:");
               mh.timKiemMH(ma).xuatMH();
            } else if (n != 8) {
                System.out.println("Vui lòng chọn từ 1->8");
            }
        } while (n != 8);
    }

    public void MenuTC() {
        System.out.println("1.Nhập thông tin lớp tín chỉ");
        System.out.println("2.Xuất thông tin lớp tín chỉ");
        System.out.println("3.Tìm kiếm lớp tín chỉ");
        System.out.println("4.Sắp xếp lớp tín chỉ tăng dần theo số sinh viên");
        System.out.println("5.Ghi file thông tin lớp tín chỉ");
        System.out.println("6.Dọc file thông tin lớp tín chỉ");
        System.out.println("7.Quay lại");
    }

    public void QLTinChi() {
        int n;
        do {
            MenuTC();
            System.out.print("==>Trả lời:");
            n = scanner.nextInt();
            if (n == 1) {
                tc.nhapDSTC();
            } else if (n == 2) {
                tc.xuatDSTC();
            } else if (n == 3) {
                tc.timKiemTC();
            } else if (n == 4) {
                tc.sxTC();
            } else if (n == 5) {
                try {
                    tc.ghiFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (n == 6) {
                try {
                    tc.xuatFile(tc.docFile());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (n != 7) {
                System.out.println("Vui lòng chọn câu trả lời từ 1->7");
            }
        } while (n != 7);
    }
}
