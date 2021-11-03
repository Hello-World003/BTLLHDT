import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DSTC implements Serializable {

    ArrayList<TINCHI> tc = new ArrayList<TINCHI>();


    public void nhapDSTC() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("\nNhập số lượng lớp tín chỉ:");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Vui lòng nhập lại");
            }
        } while (n <= 0);
        for (int i = 0; i < n; i++) {
            TINCHI a = new TINCHI();
            a.nhapTC();
            tc.add(a);
        }
    }

    public void xuatDSTC() {
        System.out.printf("%-10s|%-10s|%-10s|%-10s|%-4s|%-20s|%-20s\n", "MaLop", "TenPG", "Cahoc", "Ngayhoc", "Sosv", "TTmonhcoc", "TTgv");
        for (TINCHI x : tc) {
            x.xuatTC();
            System.out.println();
        }
        System.out.println("\nTổng số lớp tín chỉ là:" + tc.size());
        System.out.print("Tổng số sinh viên tham gia các lớp tín chỉ là:");
        int tong = 0;
        for (TINCHI x : tc) {
            tong += x.getSosv();
        }
        System.out.println(tong);
    }

    public void timKiemTC() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.print("\nNhập mã lớp tín chỉ cần tìm:");
        String t = scanner.nextLine();
        System.out.printf("%-10s|%-10s|%-10s|%-10s|%-4s|%-20s|%-20s\n", "MaLop", "TenPG", "Cahoc", "Ngayhoc", "Sosv", "TTmonhcoc", "TTgv");
        for (int i = 0; i < tc.size(); i++) {
            if (tc.get(i).getMalop().equalsIgnoreCase(t)) {
                tc.get(i).xuatTC();
                System.out.println();
            }
        }
    }

    public void sxTC() {
        System.out.println("Danh sách lớp tín chỉ được sắp xếp theo thứ tự tăng dần số sinh viên là:");
        for (int i = 0; i < tc.size() - 1; i++) {
            for (int j = i + 1; j < tc.size(); j++) {
                if (tc.get(i).getSosv() > tc.get(j).getSosv()) {
                    TINCHI a = new TINCHI();
                    TINCHI b = new TINCHI();
                    a = tc.get(i);
                    b = tc.get(j);
                    TINCHI c = new TINCHI();
                    c = a;
                    a = b;
                    b = c;
                }
            }
        }
        System.out.printf("%-10s|%-10s|%-10s|%-10s|%-4s|%-20s|%-20s\n", "MaLop", "TenPG", "Cahoc", "Ngayhoc", "Sosv", "TTmonhcoc", "TTgv");
        for (int i = 0; i < tc.size(); i++) {
            tc.get(i).xuatTC();
            System.out.println("\n----------------------");
        }
    }

    public void ghiFile() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("DSTC.dat");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(tc);
        out.close();
        file.close();
    }

    public ArrayList<TINCHI> docFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<TINCHI> kq = new ArrayList<TINCHI>();
        FileInputStream file = new FileInputStream("DSTC.dat");
        ObjectInputStream in = new ObjectInputStream(file);
        kq = (ArrayList<TINCHI>) in.readObject();
        in.close();
        file.close();

        return kq;
    }

    public void xuatFile(ArrayList<TINCHI> kq) throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("Danh sách lớp tín chỉ sau khi xuất file:");
        System.out.printf("%-10s|%-10s|%-10s|%-10s|%-4s|%-20s|%-20s\n", "MaLop", "TenPG", "Cahoc", "Ngayhoc", "Sosv", "TTmonhcoc", "TTgv");
        for (TINCHI x : kq) {
            x.xuatTC();
            System.out.println();
        }
    }
}
