import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class QuanLySinhVien {
    private ArrayList<SinhVien> danhSachSV = new ArrayList<>();
    private String filePath;

    public QuanLySinhVien(String filePath) {
        this.filePath = filePath;
        docDuLieuTuCSV(); // Đọc dữ liệu từ CSV khi khởi tạo
    }

    // Đọc dữ liệu từ file CSV
    public void docDuLieuTuCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // Bỏ qua dòng đầu tiên (header)
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String maSV = parts[0].trim();
                    String tenSV = parts[1].trim();
                    double diemTB = Double.parseDouble(parts[2].trim());
                    danhSachSV.add(new SinhVien(maSV, tenSV, diemTB));
                }
            }
            System.out.println("Doc du lieu tu file CSV thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file CSV: " + e.getMessage());
        }
    }

    // Ghi danh sách sinh viên ra file CSV
    public void ghiDanhSachRaCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("MaSV,TenSV,DiemTB");
            bw.newLine();
            for (SinhVien sv : danhSachSV) {
                bw.write(sv.getMaSV() + "," + sv.getTenSV() + "," + sv.getDiemTB());
                bw.newLine();
            }
            System.out.println("Luu danh sach sinh vien vao file CSV thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file CSV: " + e.getMessage());
        }
    }

    // Thêm sinh viên mới
    public void themSinhVien(SinhVien sv) {
        danhSachSV.add(sv);
        ghiDanhSachRaCSV();
        System.out.println("Them sinh vien thanh cong.");
    }

    // Sửa thông tin sinh viên
    public void suaSinhVien(String maSV, String tenMoi, double diemMoi) {
        for (SinhVien sv : danhSachSV) {
            if (sv.getMaSV().equals(maSV)) {
                sv.setTenSV(tenMoi);
                sv.setDiemTB(diemMoi);
                ghiDanhSachRaCSV();
                System.out.println("Sua thong tin sinh viên thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien can sua.");
    }

    // Xóa sinh viên theo mã
    public void xoaSinhVien(String maSV) {
        if (danhSachSV.removeIf(sv -> sv.getMaSV().equals(maSV))) {
            ghiDanhSachRaCSV();
            System.out.println("Xoa sinh vien thanh cong.");
        } else {
            System.out.println("Khong tim thay sinh vien can xoa.");
        }
    }

    // Hiển thị danh sách sinh viên
    public void hienThiSinhVien() {
        if (danhSachSV.isEmpty()) {
            System.out.println("Danh sach sinh vien trong.");
        } else {
            for (SinhVien sv : danhSachSV) {
                System.out.println(sv);
            }
        }
    }

    // Tìm kiếm sinh viên theo mã
    public SinhVien timKiemSinhVienTheoMa(String maSV) {
        for (SinhVien sv : danhSachSV) {
            if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }
        return null; // Không tìm thấy
    }
    // Sắp xếp sinh viên theo điểm trung bình
    public void sapXepTheoDiem() {
    if (danhSachSV.isEmpty()) {
        System.out.println("Danh sach sinh vien trong. Khong the sap xep.");
        return;
    }
    danhSachSV.sort(Comparator.comparingDouble(SinhVien::getDiemTB));
    System.out.println("Danh sach sinh vien da duoc sap xep theo diem trung binh (tang dan):");
    hienThiSinhVien();
    }

    // Sắp xếp sinh viên theo tên
    public void sapXepTheoTen() {
    if (danhSachSV.isEmpty()) {
        System.out.println("Danh sach sinh vien trong. Khong the sap xep.");
        return;
    }
    danhSachSV.sort(Comparator.comparing(SinhVien::getTenSV));
    System.out.println("Danh sach sinh vien da duoc sap xep theo ten (a-z):");
    hienThiSinhVien();
    }
    
}
