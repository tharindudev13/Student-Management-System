
public class Student extends Person {
    String Grades;
    String Course;

    Student(String name, int age, String id, String Email, String Grades, String Course) {
        super(name, age, id, Email);
        this.Grades = Grades;
        this.Course = Course;
    }
    @Override
    void showDetails(){
        super.showDetails();
        System.out.println("Course: " + Course);

    }

    @Override
    void show(){
        super.show();
        System.out.print(Course+"\t");   
        System.out.println();

    }

    static Person addPerson(int count){

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: "); 
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String Id = "S" + String.valueOf(count + 1);

        System.out.print("Email: ");
        String Email = scanner.nextLine();

        System.out.print("Grades: ");
        String Grades = scanner.nextLine();

        System.out.print("Course: ");
        String Course = scanner.nextLine();

        Student student = new Student(name, age, Id, Email, Grades, Course);

        
        return student;

    }

    void updateStudent(String id){
        if (this.Id.equals(id)) {

            System.out.print("Enter new Course: ");
            this.Course = scanner.nextLine();

            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }

    }
}

