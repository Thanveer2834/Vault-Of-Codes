import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Student Grade Tracker!");
        
        System.out.println("Enter maximum number of students: ");
        int maxStudents = scanner.nextInt();

        String[] students = new String[maxStudents];
        int[] grades = new int[maxStudents];

        int numberOfStudents = 0;

        while (true) {
            System.out.println("**********Student Grade Tracker Menu**********");
            System.out.println("1. Add new student and grade");
            System.out.println("2. View list of students and their grades");
            System.out.println("3. Calculate and display the average grade of all students.");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the student's name: ");
                    String studentName = scanner.next();

                    System.out.print("Enter student's grade between 0 and 100: ");
                    int studentGrade = scanner.nextInt();

                    if(!(studentGrade >=0 && studentGrade <= 100)){
                        System.out.println("Addition of Student and Grade failed!");
                        System.out.println("Please enter a valid Grade to add successfully!");
                        continue;
                    }
                    
                    students[numberOfStudents] = studentName;
                    grades[numberOfStudents] = studentGrade;
                    numberOfStudents++;
                    System.out.println("Student and grade added successfully!");
                    break;

                case 2:
                    if(numberOfStudents == 0){
                        System.out.println("No students added!");
                    }
                    else{
                        System.out.println("List of students and their grades:");
                        for (int i = 0; i < numberOfStudents; i++) {
                            System.out.println(students[i] + ": " + grades[i]);
                        }
                    }
                   
                    break;

                case 3:
                    int total = 0;
                    for (int i = 0; i < numberOfStudents; i++) {
                        total += grades[i];
                    }
                    double average = (double) total / numberOfStudents;
                    System.out.println("Average grade: " + average);
                    break;

                case 4:
                    System.out.println("Exiting Student Grade Tracker...");
                    System.exit(0);
                    scanner.close();
                    break;

                default:
                    System.out.println("Please enter a valid choice!");
                    break;
            }
        }
    }
}
