
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "student.csv";
        QuanLySinhVien qlsv = new QuanLySinhVien(filePath);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=== QUAN LY SINH VIEN ===");
            System.out.println("1. Hien thi danh sach sinh vien");
            System.out.println("2. Them sinh vien");
            System.out.println("3. Sua sinh vien");
            System.out.println("4. Xoa sinh vien");
            System.out.println("5. Tim kiem sinh vien theo ma");
            System.out.println("6. Sap xep sinh vien theo diem hoac ten");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    qlsv.hienThiSinhVien();
                break;

                case 2:
                    System.out.print("Nhap ma sinh vien: ");
                    String maSV = scanner.nextLine();
                    System.out.print("Nhap ten sinh vien: ");
                    String tenSV = scanner.nextLine();
                    double diemTB = 0;

                    while (true) {
                        try {
                            System.out.print("Nhap diem trung binh (0 - 10): ");
                            diemTB = Double.parseDouble(scanner.nextLine());
                            if (diemTB < 0 || diemTB > 10) {
                                throw new IllegalArgumentException("Diem trung binh phai nam trong khoang tu 0 đen 10.");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Loi: " + e.getMessage());
                        }
                    }
                    qlsv.themSinhVien(new SinhVien(maSV, tenSV, diemTB));
                    break;

                case 3:
                    System.out.print("Nhap ma sinh vien can sua: ");
                    maSV = scanner.nextLine();
                    System.out.print("Nhap ten moi: ");
                    tenSV = scanner.nextLine();

                    while (true) {
                        try {
                            System.out.print("Nhap diem trung binh moi (0 - 10): ");
                            diemTB = Double.parseDouble(scanner.nextLine());
                            if (diemTB < 0 || diemTB > 10) {
                                throw new IllegalArgumentException("Diem trung binh phai nam trong khoang tu 0 đen 10.");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Loi: " + e.getMessage());
                        }
                    }
                    qlsv.suaSinhVien(maSV, tenSV, diemTB);
                    break;

                case 4:
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    maSV = scanner.nextLine();
                    qlsv.xoaSinhVien(maSV);
                    break;

                case 5:
                    System.out.print("Nhap ma sinh vien can tim: ");
                    maSV = scanner.nextLine();
                    SinhVien sinhVienTimThay = qlsv.timKiemSinhVienTheoMa(maSV);
                    if (sinhVienTimThay != null) {
                        System.out.println("Thong tin sinh vien:");
                        System.out.println(sinhVienTimThay);
                    } else {
                        System.out.println("Khong tim thay sinh vien co ma: " + maSV);
                    }
                    break;

                case 6:
                    System.out.println("\n=== SAP XEP SINH VIEN ===");
                    System.out.println("1. Sap xep theo diem");
                    System.out.println("2. Sap xep theo ten");
                    System.out.print("Chon kieu sap xep: ");
                    int sapXepChoice = Integer.parseInt(scanner.nextLine());
                    if (sapXepChoice == 1) {
                        qlsv.sapXepTheoDiem();
                    } else if (sapXepChoice == 2) {
                        qlsv.sapXepTheoTen();
                    } else {
                    System.out.println("Lua chon khong hop le.");
                    }
                    break;


                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");

                
            }
        } while (choice != 0);
    }
}
