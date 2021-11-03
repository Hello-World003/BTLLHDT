import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class NGUOI implements Serializable {
    private String magv;
    private String tengv;
    private String ngaysinh;
    private float hsl;
    private double dmtt;

   /* public NGUOI(String magv,String tengv,String ngaysinh,float hsl,double dmtt){
        this.setMagv(magv);
        this.setTengv(tengv);
        this.setNgaysinh(ngaysinh);
        this.setHsl(hsl);
        this.setDmtt(dmtt);
    }*/

    public void setMagv(String magv) {
        if (magv.length() > 0 && magv.length() < 50) {
            this.magv = magv;
        }
    }

    public String getMagv() {
        return this.magv;
    }

    public void setTengv(String tengv) {
        if (tengv.length() > 0 && tengv.length() < 100) {
            this.tengv = tengv;
        }
    }

    public String getTengv() {
        return this.tengv;
    }

    public void setNgaysinh(String ngaysinh) {
        if (ngaysinh.length() > 0 && ngaysinh.length() < 11) {
            this.ngaysinh = ngaysinh;
        }
    }

    public String getNgaysinh() {
        return this.ngaysinh;
    }

    public void setHsl(float hsl) {
        if (hsl > 0) {
            this.hsl = hsl;
        }
    }

    public float getHsl() {
        return this.hsl;
    }

    public void setDmtt(double dmtt) {
        if (dmtt > 0) {
            this.dmtt = dmtt;
        }
    }

    public double getDmtt() {
        return this.dmtt;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã giảng viên:");
        this.setMagv(scanner.nextLine());
        System.out.print("\nNhập tên giảng viên:");
        this.setTengv(scanner.nextLine());
        System.out.print("\nNhập ngày sinh:");
        this.setNgaysinh(scanner.nextLine());
        System.out.print("\nNhập hệ số lương:");
        this.setHsl(scanner.nextFloat());
        System.out.print("\nNhập định mức thanh toán:");
        this.setDmtt(scanner.nextDouble());
    }

    public void hienThongTin() {
        System.out.printf("%-10s|%-25s|%-10s|%-5.2f|%-10s|", this.getMagv(), this.getTengv(), this.getNgaysinh(), this.getHsl(), this.tienTe(this.getDmtt()));
    }

    public String tienTe(double tien) {
        DecimalFormat dcf = new DecimalFormat("#,###");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
        dfs.setGroupingSeparator(',');
        dcf.setDecimalFormatSymbols(dfs);
        return "" + dcf.format(tien);
    }

    public double tinhLuong() {
        return 0;
    }

    public String layTen(){
        String ten="";
        String t=" ";
        int n=this.getTengv().lastIndexOf(t);// cho biết vị trí xuất hiện dấu cách cuối cùng
        for(int i=n;i<this.getTengv().length();i++){
            ten+=this.getTengv().charAt(i);
        }
        return ten;
    }
}

