package QLSV;

import java.io.Serializable;

public class SinhVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fullName;
	private int age;
	private String sex;
	private int point;
	public SinhVien(String fullName, int age, String sex, int point) {
		this.fullName = fullName;
		this.age = age;
		this.sex = sex;
		this.point = point;
	}
	public void show() {
		System.out.println("Ho va ten: " + this.fullName);
		System.out.println("Tuoi: " + this.age);
		System.out.println("Gioi tinh: " + this.sex);
		System.out.println("Diem thi: " + point);
		
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
