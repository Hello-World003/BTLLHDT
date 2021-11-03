import java.io.*;
import java.util.*;

public class DSGV {
    ArrayList<NGUOI> arr = new ArrayList<NGUOI>();

    public void nhapGv() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhập số lượng giảng viên:");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Không thỏa mãn điều kiện, Vui lòng nhập lại");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (n <= 0);
        int i = 0;
        while (i < n) {
            System.out.println("Bạn muốn nhập thông tin cho giảng viên nào:");
            System.out.println("\t\t1.Giảng viên Cơ Hữu");
            System.out.println("\t\t2.Giảng viên Thỉnh Giảng");
            System.out.print("==>Trả lời:");
            int tl = scanner.nextInt();
            if (tl == 1) {
                NGUOI ch = new GVCOHUU();
                ch.nhapThongTin();
                arr.add(ch);
                i++;
            } else if (tl == 2) {
                NGUOI tg = new GVTHINHGIANG();
                tg.nhapThongTin();
                arr.add(tg);
                i++;
            } else {
                System.out.println("Câu trả lời không hợp lệ");
            }
        }
    }

    public void xuatGv() {
        System.out.printf("%-10s|%-25s|%-10s|%-5s|%-10s|%-20s|%-20s|%-20s|%-25s|%-10s\n\n", " Mã GV", "  Tên GV", "Ngày sinh", "HSL", "DMTT", "Đơn vị giáo dục", "Nhóm môn", "Lương", "Chức vụ", "Hspc");
        for (NGUOI pe : arr) {
            pe.hienThongTin();
            System.out.println();
        }
    }

    public void sapXeptheoTen() {
        System.out.println("\tThông tin sắp xếp theo tên giảng viên:");
        Collections.sort(arr, new Comparator<NGUOI>() {
            @Override
            public int compare(NGUOI nguoi, NGUOI t1) {
                return nguoi.layTen().compareTo(t1.layTen());
            }
        });
        for (NGUOI pe : arr) {
            pe.hienThongTin();
            System.out.println();
        }
    }

    public void xoaGv() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã giảng viên cần xóa:");
        String ma = scanner.nextLine();
        for (int i = 0; i < arr.size(); i++) {
            if (ma.equalsIgnoreCase(arr.get(i).getMagv())) {
                arr.remove(i);
                break;
            }
        }
        for(NGUOI x:arr){
            x.hienThongTin();
        }
        System.out.println();
    }

    public void themGv() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn nhập thông tin cho giảng viên nào:");
        System.out.println("\t\t1.Giảng viên Cơ Hữu");
        System.out.println("\t\t2.Giảng viên Thỉnh Giảng");
        System.out.print("==>Trả lời:");
        int tl = scanner.nextInt();
        if (tl == 1) {
            NGUOI ch = new GVCOHUU();
            ch.nhapThongTin();
            arr.add(ch);

        } else if (tl == 2) {
            NGUOI tg = new GVTHINHGIANG();
            tg.nhapThongTin();
            arr.add(tg);
        } else {
            System.out.println("Câu trả lời không hợp lệ");
        }
    }

    public void ghifile() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("DSGV1.dat");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(arr);
        out.close();
        file.close();
    }


    public ArrayList<NGUOI> docFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<NGUOI> kq = new ArrayList<NGUOI>();
        FileInputStream file = new FileInputStream("DSGV1.dat");
        ObjectInputStream in = new ObjectInputStream(file);
        kq = (ArrayList<NGUOI>) in.readObject();
        in.close();
        file.close();
        return kq;
    }

    public void xuatFile(ArrayList<NGUOI> kq) {
        for (NGUOI pe : kq) {
            pe.hienThongTin();
            System.out.println();
        }
    }

    public NGUOI timKiem(String magv) {
        try {
            arr = docFile();
            for (NGUOI pe : arr) {
                if (pe.getMagv().equalsIgnoreCase(magv)==true) {
                    return pe;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
