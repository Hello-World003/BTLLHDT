import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DSMH {
    ArrayList<MONHOC> mh = new ArrayList<MONHOC>();

    public void nhapMon() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập số lượng môn học:");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Vui lòng kiểm tra lại điều kiện nhập");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } while (n <= 0);
        for (int i = 0; i < n; i++) {
            MONHOC a = new MONHOC();
            a.nhapMH();
            mh.add(a);
        }
    }

    public void xuatMon() {
        System.out.printf("%-10s|%-25s|%-4s\n", "MaMH", "TenMH", "Sotc");
        for (MONHOC sb : mh) {
            sb.xuatMH();
            System.out.println();
        }
        System.out.println();
        System.out.println("==>TỔNG SỐ LƯỢNG MÔN HỌC:" + mh.size());
        int tong = 0;
        for (int i = 0; i < mh.size(); i++) {
            tong += mh.get(i).getSotc();
        }
        System.out.println("==>TỔNG SỐ TÍN CHỈ:" + tong);
    }

    public void xoaMH() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học cần xóa:");
        String mhx = scanner.nextLine();
        for (int i = 0; i < mh.size(); i++) {
            if (mhx.equalsIgnoreCase(mh.get(i).getMamon())) {
                mh.remove(i);
                break;
            } else {
                System.out.println("Không có môn học như trên");
            }
        }
        System.out.println("\tDanh sách môn học sau khi xóa là:");
        System.out.printf("%-10s|%-25s|%-4s\n", "MaMH", "TenMH", "Sotc");
        for (MONHOC sb : mh) {
            sb.xuatMH();
            System.out.println();
        }
    }

    public void themMH() {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.println("Nhập số lượng môn học bạn muốn thêm:");
            n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Không thỏa mãn điều kiện");
            }
        } while (n < 0);
        for (int i = 0; i < n; i++) {
            MONHOC a = new MONHOC();
            mh.add(a);
        }
    }

    public void ghiFile() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("DSMH.dat");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(mh);
        out.close();
        file.close();
    }

    public ArrayList<MONHOC> docFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<MONHOC> kq = new ArrayList<MONHOC>();
        FileInputStream file = new FileInputStream("DSMH.dat");
        ObjectInputStream in = new ObjectInputStream(file);
        kq = (ArrayList<MONHOC>) in.readObject();
        in.close();
        file.close();
        return kq;
    }

    public void xuatFile(ArrayList<MONHOC> kq) {
        System.out.println("Danh sách sau khi xuất:");
        System.out.printf("%-10s|%-25s|%-4s\n", "MaMH", "TenMH", "Sotc");
        for (MONHOC x : kq) {
            x.xuatMH();
            System.out.println();
        }
    }

    public MONHOC timKiemMH(String mamon) {
        try {
            mh = docFile();
            for (MONHOC sb : mh) {
                if (mamon.equalsIgnoreCase(sb.getMamon())) {
                    return sb;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
