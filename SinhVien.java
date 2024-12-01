public class SinhVien {
    private String maSV;
    private String tenSV;
    private double diemTB;

    public SinhVien(String maSV, String tenSV, double diemTB) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        if (diemTB < 0 || diemTB > 10) {
            throw new IllegalArgumentException("Diem trung binh phai nam trong khoang tu 0 đen 10.");
        }
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        if (diemTB < 0 || diemTB > 10) {
            throw new IllegalArgumentException("Diem trung binh phai nam trong khoang tu 0 đen 10.");
        }
        this.diemTB = diemTB;
    }

    public String convertToRank() {
        if (diemTB >= 0 && diemTB <= 5) {
            return "Fail";
        } else if (diemTB < 6.5) {
            return "Medium";
        } else if (diemTB < 7.5) {
            return "Good";
        } else if (diemTB < 9) {
            return "Very Good";
        } else if (diemTB <= 10) {
            return "Excellent";
        } else {
            return "Invalid";
        }
    }

    @Override
    public String toString() {
        return "MaSV: " + maSV + ", TenSV: " + tenSV + ", DiemTB: " + diemTB + ", Xep Loai: " + convertToRank();
    }
}
