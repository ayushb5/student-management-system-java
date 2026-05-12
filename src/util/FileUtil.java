package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.InvalidMarksException;

import java.util.List;

import model.Student;

public class FileUtil {
	public static void saveStudents(List<Student> students) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("students.txt"));
			
			for(Student s: students) {
				bw.write(
						s.getId()+","+
						s.getName()+","+
						s.getAge()+","+
						s.getMarks()
					);
				bw.newLine();
			}
			 bw.close();

			 System.out.println("\nData Saved");
		}catch(IOException e) {
			System.out.println("File Error");
		}
	}
	
	public static ArrayList<Student> loadStudents() {

    ArrayList<Student> students = new ArrayList<>();

    try {

        BufferedReader br =
            new BufferedReader(
                new FileReader("students.txt"));

        String line;

        while((line = br.readLine()) != null) {

            String data[] = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int age = Integer.parseInt(data[2]);
            double marks = Double.parseDouble(data[3]);

            Student s =
                new Student(id, name, age, marks);

            students.add(s);
        }

        br.close();

    } catch(Exception e) {

        System.out.println("File Error");
    }

    return students;
}
}
