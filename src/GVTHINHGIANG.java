import java.io.Serializable;
import java.util.Scanner;

public class GVTHINHGIANG extends NGUOI implements Serializable {
    private String donvidd;
    private String nhommon;

  /*  public GVTHINHGIANG(String magv,String tengv,String ngaysinh,float hsl,double dmtt,String donvidd,String nhommon){
        super(magv, tengv, ngaysinh, hsl, dmtt);
        this.setDonvidd(donvidd);
        this.setNhommon(nhommon);
    }*/

    public void setDonvidd(String donvidd) {
        if (donvidd.length() > 0) {
            this.donvidd = donvidd;
        }
    }

    public String getDonvidd() {
        return this.donvidd;
    }

    public void setNhommon(String nhommon) {
        if (nhommon.length() > 0) {
            this.nhommon = nhommon;
        }
    }

    public String getNhommon() {
        return this.nhommon;
    }


    @Override
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        super.nhapThongTin();
        System.out.print("\nNhập đơn vị giáo dục:");
        this.setDonvidd(scanner.nextLine());
        System.out.print("\nNhập nhóm môn:");
        this.setNhommon(scanner.nextLine());
    }

    @Override
    public void hienThongTin() {

        super.hienThongTin();
        System.out.printf("%-20s|%-20s|%-20s|%-25s", this.getDonvidd(), this.getNhommon(), this.tienTe(this.tinhLuong()), "GV Thỉnh giảng");
    }

    @Override
    public double tinhLuong() {
        double tl = this.getHsl() * this.getDmtt();
        return tl;
    }
}

