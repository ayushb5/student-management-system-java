package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Student;
import util.FileUtil;

public class StudentService {
	List<Student> students=FileUtil.loadStudents();
	
	public void addStudent(Student student) {
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getId()==student.getId()) {
				System.out.println("Student with ID "+student.getId()+" already exists");
				return;
			}
		}
		
		students.add(student);
	    FileUtil.saveStudents(students);
		System.out.print("Record Added Successfully");
	}
	
	public void displayStudents() {
		if(students.isEmpty()) {

		        System.out.println(
		            "No Records Found");

		        return;
		   }
		 
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public int searchStudent(int id) {
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getId()==id) {
				return i;
			}
		}
		
		return -1;
	}
	public Student getStudent(int index) {
		return students.get(index);
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void updateStudent(int index, Student updatedStudent) {
		students.set(index, updatedStudent);
	    FileUtil.saveStudents(students);
	    System.out.print("Student Updated Successfully");
	}
	
	public void deleteStudent(int id) {
		int index=searchStudent(id);
		
		if(index!=-1) {
			students.remove(index);
	        FileUtil.saveStudents(students);
			System.out.print("Record Deleted Successfully");
		}else {
			System.out.print("Student not Found");
		}
	}
	
	public void sortByMarks() {
		Collections.sort(students);
		System.out.println("Students sorted by Marks.");
	}
	
	public void sortByName() {
		Collections.sort(students,Comparator.comparing(Student::getName));
		System.out.println("Students sorted by Name.");		
	}
	
	public void showTopper() {
		Student topper=students.stream()
				.max(Comparator.comparing(Student::getMarks))
				.orElse(null);
		
		if(topper != null) {

	        System.out.println("Topper Details:");
	        System.out.println(topper);

	    } else {

	        System.out.println("No Records Found");
	    }
	}
	
	public void studentsAbove80() {
		students.stream()
				.filter(s->s.getMarks()>80)
				.forEach(System.out::println);
	}
	
	public void avgMarks() {
		double avg=
				students.stream()
						.mapToDouble(Student::getMarks)
						.average()
						.orElse(0);
		
		System.out.println("Average Marks: "+avg);
	}
	
	public void countStudents() {
		long count= students.stream().count();
		
		System.out.println("Total Students: "+count);
	}
	
	public void failedStudents() {
		students.stream()
				.filter(s->s.getMarks()<40)
				.forEach(System.out::println);
						
	}
}
