package CRUD_Operation_Demo_S7.CRUD_operation_Demo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Student_Record")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
  int id;
  String name;
  String branch;
  double cgpa;
  public String getBranch() {
	return branch;
}
  public void setBranch(String branch) {
	this.branch = branch;
  }
  public double getCgpa() {
	return cgpa;
  }
  public void setCgpa(double cgpa) {
	this.cgpa = cgpa;
  }
  String address;
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getAddress() {
	return address;
  }
  public void setAddress(String address) {
	this.address = address;
  }
  

}
