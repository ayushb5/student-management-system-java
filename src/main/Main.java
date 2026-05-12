package main;

import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;
import util.FileUtil;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentService service=new StudentService();
		int ch;
		
		do{
			System.out.println("\n1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");	
			System.out.println("5. Search Student");				
			System.out.println("6. Sort by Marks");				
			System.out.println("7. Sort by Name");	
			System.out.println("8. Show Topper");				
			System.out.println("9. Students Above 80");				
			System.out.println("10. Average Marks");				
			System.out.println("11. Total Students Count");				
			System.out.println("12. Failed Students");				
			System.out.println("13. Exit");
			System.out.print("Enter your choice: ");
			
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				try {
					System.out.print("Enter ID: ");
					int id=sc.nextInt();
					System.out.print("Enter Name:");
					sc.nextLine();
					String name=sc.nextLine();
					
					System.out.print("Enter Age:");
					int age=sc.nextInt();
					
					System.out.print("Enter Total Marks out of 100: ");
					double marks=sc.nextDouble();
					Student s=new Student(id,name,age,marks);
					service.addStudent(s);
				}catch(Exception e) {
					System.out.println("Invalid Input! Please enter correct data.");
			        sc.nextLine(); 
				}
				break;
				
			case 2:
				service.displayStudents();
				break;
				
			case 3:
				System.out.print("Enter Student ID to update details: ");
				int updateId=sc.nextInt();
				
				int res=service.searchStudent(updateId);
				
				if(res!=-1) {
					
					try {
					System.out.print("Enter New Name:");
					String newName=sc.next();
					
					System.out.print("Enter New Age:");
					int newAge=sc.nextInt();
					
					System.out.print("Enter New Total Marks out of 100: ");
					double newMarks=sc.nextDouble();
					
					Student updatedStudent=new Student(updateId,newName,newAge,newMarks);
					service.updateStudent(res,updatedStudent);
					
					}catch(Exception e) {
						System.out.println("Invalid Input! Please enter correct data.");
				        sc.nextLine(); 
					}
				} else {

				    System.out.println("Student ID Not Found");
				}
				
				break;
				
			case 4:
				try {
				System.out.print("Enter Student ID to Delete record: ");
				int deleteId=sc.nextInt();
				service.deleteStudent(deleteId);
				}catch(Exception e) {
					System.out.println("Invalid Input! Please enter correct data.");
			        sc.nextLine(); 
				}
				break;
				
			case 5:
				try {
					System.out.print("Enter Student Id to Search record: ");
					int searchId=sc.nextInt();
					int index=service.searchStudent(searchId);
					if(index!=-1) {
						System.out.println("Student Found");
						System.out.println(service.getStudent(index));
					}else {
						System.out.println("Student Not Found");
					
					}
				}catch(Exception e) {
					System.out.println("Invalid Input! Please enter correct data.");
			        sc.nextLine(); 
				}
				break;
				
			case 6:
				service.sortByMarks();
				service.displayStudents();
				break;
				
			case 7:
				service.sortByName();
				service.displayStudents();
				break;
				
			case 8:
				service.showTopper();
				break;
				
			case 9:
				service.studentsAbove80();
				break;
				
			case 10:
				service.avgMarks();
				break;
				
			case 11:
				service.countStudents();
				break;
				
			case 12:
				service.failedStudents();
				break;
				
			case 13:
				System.out.println("Thank You...");
				break;
			
			default:
				System.out.println("Invalid Choice");
			}
		}while(ch!=13);
		
		
	}
}
