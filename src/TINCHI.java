import java.io.Serializable;
import java.util.Scanner;

public class TINCHI implements Serializable {
    private String malop;
    private String tenphong;
    private String cahoc;
    private String ngayhoc;
    private int sosv;
    private MONHOC TTMonHoc;
    private NGUOI TTGiangVien;



    public void setMalop(String malop){
        if(malop.length()>0){
            this.malop=malop;
        }
    }
    public String getMalop(){
        return this.malop;
    }

    public void setTenphong(String tenphong){
        if(tenphong.length()>0){
            this.tenphong=tenphong;
        }
    }
    public String getTenphong(){
        return this.tenphong;
    }

    public void setCahoc(String cahoc){
        if(cahoc.length()>0){
            this.cahoc=cahoc;
        }
    }
    public String getCahoc(){
        return this.cahoc;
    }

    public void setNgayhoc(String ngayhoc){
        if(ngayhoc.length()>0 && ngayhoc.length()<11){
            this.ngayhoc=ngayhoc;
        }
    }
    public String getNgayhoc(){
        return this.ngayhoc;
    }

    public void setSosv(int sosv){
        if(sosv>0 && sosv<200){
            this.sosv=sosv;
        }
    }
    public int getSosv(){
        return this.sosv;
    }

    public void setTTMonHoc(MONHOC TTMonHoc){
        this.TTMonHoc=TTMonHoc;
    }
    public String getTTMonHoc(){
        return this.TTMonHoc.getTenmon();
    }

    public void setTTGiangVien(NGUOI TTGiangVien){
        this.TTGiangVien=TTGiangVien;
    }
    public String getTTGiangVien(){
        return this.TTGiangVien.getTengv();
    }

    public void nhapTC(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("\nNhập mã lớp:");
        this.setMalop(scanner.nextLine());
        System.out.print("\nNhập tên phòng:");
        this.setTenphong(scanner.nextLine());
        System.out.print("\nNhập ca học:");
        this.setCahoc(scanner.nextLine());
        System.out.print("\nNhập ngày học:");
        this.setNgayhoc(scanner.nextLine());
        System.out.print("\nNhập số sinh viên:");
        this.setSosv(scanner.nextInt());
        scanner.nextLine();
        System.out.println("\nNhập mã môn học:");
        String t=scanner.nextLine();
        DSMH dsmh=new DSMH();
        MONHOC a=dsmh.timKiemMH(t);
        if(a!=null){
            this.setTTMonHoc(a);
        }
        else{
            this.setTTMonHoc(null);
        }
        System.out.println("\nNhập mã giảng viên:");
        String magv=scanner.nextLine();
        DSGV dsgv=new DSGV();
        NGUOI gv=dsgv.timKiem(magv);
        if(gv!=null){

            this.setTTGiangVien(gv);
        }
        else{
            this.setTTGiangVien(null);
        }
    }

    public void xuatTC(){
        System.out.printf("%-10s|%-10s|%-10s|%-10s|%-4d|%-20s|%-20s",this.getMalop(),this.getTenphong(),this.getCahoc(),this.getNgayhoc(),this.getSosv(),this.getTTMonHoc(),this.getTTGiangVien());
    }
}
