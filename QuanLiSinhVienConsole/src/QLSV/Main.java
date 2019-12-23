package QLSV;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import QLSV.SinhVien;

public class Main {

	private static Scanner sc;
	private static ArrayList<SinhVien> data;

	public static void main(String[] args) {
		data = new ArrayList<>();
		sc = new Scanner(System.in);
		int option;
		String YON = null;
		do {
			System.out.println("-------Moi nhap lua chon:-------");
			System.out.println("+------------------------------+");
			System.out.println("|    1. Them sinh vien         |");
			System.out.println("+------------------------------+");
			System.out.println("|    2. Xoa sinh vien          |");
			System.out.println("+------------------------------+");
			System.out.println("|    3. Xem danh sach          |");
			System.out.println("+------------------------------+");
			System.out.println("|    4. Sap xep theo ten       |");
			System.out.println("+------------------------------+");
			System.out.println("|    5.Sap xep theo diem       |");
			System.out.println("+------------------------------+");
			System.out.println("|    6.Sua thong tin           |");
			System.out.println("+------------------------------+");
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
			case 1:
				ThemSinhVien();
				break;
			case 2:
				XoaSinhVien();
				break;
			case 3:
				XemSinhVien();
				break;
			case 4:
				SapXepTheoTen();
				break;
			case 5:
				SapXepTheoDiem();
				break;
			case 6:
				SuaSinhVien();
				break;
			default:
				System.out.println("Nhap sai!");
			}
			System.out.println("Ban co muon tiep tuc? yes/no \n");
			YON = sc.nextLine();
			
			
		} while (YON.contentEquals("yes"));
	}
private static void SapXepTheoDiem() {
		
		try {
			FileInputStream fis = new FileInputStream("output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			data.clear();
			List<SinhVien> data1 = (List<SinhVien>)ois.readObject();
			data.addAll(data1);
			
			for (int i = data.size()-2;i >= 0;i--) {
				for (int j = 0;j <= i;j++) {
					if (data.get(j).getPoint() > data.get(j+1).getPoint()) {
						SinhVien tem = data.get(j);
						data.set(j, data.get(j+1));
						data.set(j+1,tem);
					}
				}
			}
			
			FileOutputStream fos = new FileOutputStream("output.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
			fis.close();
			ois.close();
			System.out.println(" sap xep xong");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi1");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi2");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi3");
			e.printStackTrace();
		}
		
		
	}
	private static void SapXepTheoTen() {
		
		try {
			FileInputStream fis = new FileInputStream("output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			data.clear();
			List<SinhVien> data1 = (List<SinhVien>)ois.readObject();
			data.addAll(data1);
			
			for (int i = data.size()-2;i >= 0;i--) {
				for (int j = 0;j <= i;j++) {
					if (data.get(j).getFullName().compareTo(data.get(j+1).getFullName()) > 0) {
						SinhVien tem = data.get(j);
						data.set(j, data.get(j+1));
						data.set(j+1,tem);
					}
				}
			}
			
			FileOutputStream fos = new FileOutputStream("output.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
			fis.close();
			ois.close();
			System.out.println(" sap xep xong");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi1");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi2");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi3");
			e.printStackTrace();
		}
		
		
	}
	private static void SuaSinhVien() {
		System.out.println("Nhap ten:");
		String tenBanDau = sc.nextLine();
		System.out.println("Ban muon doi ten thanh?(nhap '.' để bỏ qua:");
		String tenSua = sc.nextLine();
		System.out.println("Ban muon doi tuoi thanh?(nhap '-1' để bỏ qua:");
		int tuoi2 = sc.nextInt();
		sc.nextLine();
		System.out.println("Ban muon gioi tinh thanh?(nhap '.' để bỏ qua:");
		String gioiTinh = sc.nextLine();
		System.out.println("Ban muon doi diem thanh?(nhap '-1' để bỏ qua:");
		int diem2 = sc.nextInt();
		try {
			FileInputStream fis = new FileInputStream("output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<SinhVien> data1 = (List<SinhVien>)ois.readObject();
			data = new ArrayList<SinhVien>(data1.size());
			data.addAll(data1);
			for (int i = 0;i < data.size();i++) {
				if (data.get(i).getFullName().contentEquals(tenBanDau)) {
					if (tenSua != ".") {
						data.get(i).setFullName(tenSua);
					}
					if (gioiTinh != ".") {
						data.get(i).setSex(gioiTinh);
					}
					if (tuoi2 != -1) {
						data.get(i).setAge(tuoi2);
					}
					if (diem2 != -1) {
						data.get(i).setPoint(diem2);
					}
				}
			}
			FileOutputStream fos = new FileOutputStream("output.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			fis.close();
			ois.close();
			oos.close();
			fos.close();
			System.out.println("Sua thong tin thanh cong!!");
			sc.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static void ThemSinhVien() {
		
		String ten,gt;
		int tuoi,diem;
		System.out.println("Nhap ten: ");
		ten = sc.nextLine();
		System.out.println("Nhap tuoi:");
		tuoi = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap gioi tinh: ");
		gt = sc.nextLine();
		System.out.println("Nhap diem:");
		diem = sc.nextInt();
		sc.nextLine();
		try {
			FileInputStream fis = new FileInputStream("output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			data.clear();
			data.addAll((List<SinhVien>)ois.readObject());
			
			SinhVien tem = new SinhVien(ten,tuoi,gt,diem);
			data.add(tem);
			FileOutputStream fos = new FileOutputStream("output.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
			ois.close();
			fis.close();
			
			System.out.println("Them thanh cong!!");
		} catch(Exception e) {
			System.out.println("Them that bai!!");
		}
		
		
	}
	private static void XemSinhVien() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<SinhVien> data1 = (List<SinhVien>)ois.readObject();
			data = new ArrayList<SinhVien>(data1.size());
			data.addAll(data1);
			for (SinhVien sv : data) {
				sv.show();
				System.out.println("____________________________________");
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void XoaSinhVien() {
		System.out.println("Nhap ten can xoa:");
		String ten = sc.nextLine();
		try {
			FileInputStream fis = new FileInputStream("output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<SinhVien> data1 = (List<SinhVien>)ois.readObject();
			data = new ArrayList<SinhVien>(data1.size());
			data.addAll(data1);
			for (int i = 0;i < data.size();i++) {
				if (data.get(i).getFullName().contentEquals(ten)) {
					data.remove(i);
					i--;
				}
			}
			ois.close();
			fis.close();
			FileOutputStream fos = new FileOutputStream("output.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
			System.out.println("Xoa thanh cong!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Da xay ra loi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Da xay ra loi");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Da xay ra loi");
		}
		
		
	}
	

}
