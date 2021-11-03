import java.io.Serializable;
import java.util.Scanner;

public class MONHOC implements Serializable {
    private String mamon;
    private String tenmon;
    private int sotc;

    public void setMamon(String mamon){
        if(mamon.length()>0){
            this.mamon=mamon;
        }
    }
    public String getMamon(){
        return this.mamon;
    }

    public void setTenmon(String tenmon){
        if(tenmon.length()>0){
            this.tenmon=tenmon;
        }
    }
    public String getTenmon(){
        return this.tenmon;
    }

    public void setSotc(int sotc){
        if(sotc>0){
            this.sotc=sotc;
        }
    }
    public int getSotc(){
        return this.sotc;
    }

    public void nhapMH(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("\nNhập mã môn học:");
        this.setMamon(scanner.nextLine());
        System.out.print("\nNhập tên môn học:");
        this.setTenmon(scanner.nextLine());
        System.out.print("\nNhập số tín chỉ:");
        this.setSotc(scanner.nextInt());
    }

    public void xuatMH(){
        System.out.printf("%-10s|%-25s|%-4d",this.getMamon(),this.getTenmon(),this.getSotc());
    }
}
