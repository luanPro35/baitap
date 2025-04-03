package baitap.bai3;

public class ViDuStarvation {
    public static void main(String[] args) {
        Thread luongUuTienCao = new Thread(new NhiemVuUuTienCao(), "Luong-UuTien-Cao");
        Thread luongUuTienThap = new Thread(new NhiemVuUuTienThap(), "Luong-UuTien-Thap");

        luongUuTienCao.setPriority(Thread.MAX_PRIORITY);
        luongUuTienThap.setPriority(Thread.MIN_PRIORITY);

        luongUuTienCao.start();
        luongUuTienThap.start();
    }

}
