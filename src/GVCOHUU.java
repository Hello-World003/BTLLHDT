import java.io.Serializable;
import java.util.Scanner;

public class GVCOHUU extends NGUOI implements Serializable {
    private String nhommon;
    private float hspc;
    private int sotietnv;

   /* public GVCOHUU(String magv,String tengv, String ngaysinh, float hsl, double dmtt, String nhommon,float hspc,int sotietnv){
        super(magv, tengv, ngaysinh, hsl, dmtt);
        this.setNhommon(nhommon);
        this.setHspc(hspc);
        this.setSotietnv(sotietnv);
    }*/


    public void setNhommon(String nhommon) {
        if (nhommon.length() > 0) {
            this.nhommon = nhommon;
        }
    }

    public String getNhommon() {
        return this.nhommon;
    }

    public void setHspc(float hspc) {
        if (hspc > 0) {
            this.hspc = hspc;
        }
    }

    public float getHspc() {
        return this.hspc;
    }

    public void setSotietnv(int sotietnv) {
        if (sotietnv >= 0) {
            this.sotietnv = sotietnv;
        }
    }

    public int getSotietnv() {
        return this.sotietnv;
    }

    @Override
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        super.nhapThongTin();
        System.out.print("\nNhập nhóm môn:");
        this.setNhommon(scanner.nextLine());
        System.out.print("\nNhập hệ số phụ cấp:");
        this.setHspc(scanner.nextFloat());
        System.out.print("\nNhập số tiết nghĩa vụ:");
        this.setSotietnv(scanner.nextInt());
    }

    @Override
    public void hienThongTin() {
        super.hienThongTin();
        System.out.printf("%-20s|%-20s|%-20s|%-25s|%-10.2f","0",this.getNhommon(),this.tienTe(this.tinhLuong()),"GV Cơ hữu",this.getHspc());
    }

    @Override
    public double tinhLuong() {
        double tl = this.getHsl() * this.getDmtt() + this.getHsl() * this.getDmtt() * this.getHspc();
        return tl;
    }


}

