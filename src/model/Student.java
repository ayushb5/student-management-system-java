package model;

import exception.InvalidMarksException;

public class Student implements Comparable<Student> {
	
	private int id;
	private String name;
	private int age;
	private double marks;

	public Student(int id,String name,int age,double marks) throws InvalidMarksException {
		
		if(marks<0 || marks>100) {
			throw new InvalidMarksException("Marks should be between 0 and 100");
		}
		
		this.id=id;
		this.name=name;
		this.age=age;
		this.marks=marks;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks=marks;
	}
	
	@Override
	public String toString() {
		return "ID: "+id+", Name: "+name+", Age: "+age+", Marks: "+marks;
	}
	
	@Override
	public int compareTo(Student s) {
		return Double.compare(this.marks, s.marks);
	}
	
}
