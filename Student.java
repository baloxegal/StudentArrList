import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	String fullname;
    String specialty;
    Float  grade;
	
    public static void main(String[] args) {
    	
    	ArrayList<Student> students = new ArrayList<Student>();
    	
    	students.add(new Student("Frunza Viorel", "economist", 7.8f));
    	students.add(new Student("Prepelita Feofan", "economist", 9.2f));
    	students.add(new Student("Gaina Veniamin", "contabil", 8.6f));
    	students.add(new Student("Groaznic Vasile", "inginer", 7.4f));
    	students.add(new Student("Animala Arnold", "manager", 8.7f));
    	
    	Integer indexOfTheBest = 0;
    	Float maxGrade = 0.0f;
    	
    	for(Student s : students) {
    		if(maxGrade < s.grade) {
    			indexOfTheBest = students.indexOf(s);
    			maxGrade = s.grade;
    		}
    	}
    	
    	System.out.println("Indexul din ArrayList a celui mai bun student este - " + indexOfTheBest);
    	System.out.println("Cel mai bun student are gradul - " + students.get(indexOfTheBest).getGrade());

    	students.get(indexOfTheBest).setGrade(students.get(indexOfTheBest).getGrade() + 0.1f);
    	System.out.printf("Gradul celui mai bun student a fost modificat - %3.1f\n", students.get(indexOfTheBest).getGrade());
     	
    	ArrayList<Student> bestStudents = new ArrayList<Student>();
    	students.forEach(s -> {if(s.grade >= 8.0) bestStudents.add(s);});
    	
    	System.out.println("Lista studentilor:");
    	students.forEach(s->System.out.println(s.toString(s)));
    	System.out.println("Lista studentilor \"The Best\":");
    	bestStudents.forEach(bs -> System.out.println(bs.toString(bs)));
	}
	
	public Student(String fullname, String specialty, Float  grade) {
		this.fullname = fullname;
        this.specialty = specialty;
        setGrade(grade);
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		for(;;) {
			if(grade >= 1) {
				this.grade = grade;
				break;
			}
			else {
				System.out.println("Introduceti gradul corect");
				Scanner in = new Scanner (System.in);
				grade = in.nextFloat();
				in.close();
			}
		}
	}
	public String toString(Student s) {
		return "Nume / Prenume - " + s.fullname + "\n" + "Specialitate - " + s.specialty + "\n" + "Nota - " + s.grade;
	}
}
