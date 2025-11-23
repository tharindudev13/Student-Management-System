import java.util.Scanner;



public class Main {
    static Student[] students = new Student[100];
    static Teacher[] teachers = new Teacher[100];
    static Staff[] staffs = new Staff[100];

    static int studentCount = 0;
    static int teacherCount = 0;       
    static int staffCount = 0;

    static void viewPersonDetails(String id,String type){ 

        boolean found = false;
        int Count;
        Person arr[] = new Person[100];
        
        if (type.equals("Student")) {
            Count = studentCount;
            arr = students.clone();
                        
        }else if (type.equals("Teacher")) {
            Count = teacherCount;
            arr = teachers.clone();

        } else {
            Count = staffCount;    
            arr = staffs.clone();

        }

        System.out.println("\n"+type+" Details");
        System.out.println("-------------------------------\n");

        

        for (int i = 0; i < Count; i++) {
            if (arr[i].Id.equals(id) && !arr[i].isDeleted) {
                
                arr[i].showDetails();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(type + " not found.");
        }

        System.out.println("-------------------------------\n");
        
    
    }
    
    static void viewAll(String type){
        int Count;
        Person arr[] = new Person[100];
        System.out.println("\n"+type+" Details");
        System.out.println("---------------------\n");
        

        if (type.equals("Student")) {
            Count = studentCount; 
            arr = students.clone();
            System.out.println("StId\tName\t\t\tAge\tCourse");          
        }else if (type.equals("Teacher")) {
            Count = teacherCount;
            arr = teachers.clone();
            System.out.println("TcId\tName\t\tAge\tSubject");           
        } else {
            arr = staffs.clone();
            Count = staffCount;           
            System.out.println("EId\tName\t\tRole");
        }

        for (int i = 0; i < Count; i++) {
            if(!arr[i].isDeleted){
                arr[i].show();
            }
            
            
        }

    }

    static void selectOpt(String type){
        int Count;
        if (type.equals("Student")) {
            Count = studentCount;
                        
        }else if (type.equals("Teacher")) {
            Count = teacherCount;

        } else {
            Count = staffCount;    

        }
        System.out.println("\nSelect a option:");
                System.out.println("1. Add " + type);
                if(Count>0){
                    System.out.println("2. View " + type);
                    System.out.println("3. Update " + type);  
                    System.out.println("4. Delete " + type);
                    System.out.println("5. View All " + type + "s");
                }
                System.out.println("6. Back to Main Menu\n");

    }
    public static void main(String[] args) {

        System.out.println("\t___________________________________________\n");
	    System.out.println("\t-------- STUDENT MANAGEMENT SYSTEM --------");
	    System.out.println("\t___________________________________________\n");


        Scanner scanner = new Scanner(System.in);

        while (true) {

            int choice=0;
            System.out.println("Select a section\n1. Student\n2. Teacher\n3. Staff\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if(choice == 1){
                selectOpt("Student");

                System.out.print("Option: ");
                int studentChoice = scanner.nextInt();
                System.out.println("");

                switch (studentChoice) {
                    case 1:
                        //Add Student   
                        Student newStudent = (Student) Student.addPerson(studentCount);
                        students[studentCount] = newStudent;
                        studentCount++;
                        System.out.println("\nStudent added successfully!\n");

                        break;
                    case 2:
                        //View Student  
                        String viewId;
                        System.out.print("Enter Student ID to view: ");
                        viewId = scanner.next();
                        viewPersonDetails(viewId, "Student");
                        break;
                    case 3: 
                        //Update Student
                        String updateId;
                        System.out.print("Enter Student ID to update: ");
                        updateId = scanner.next();
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].Id.equals(updateId)) {
                                students[i].updateStudent(updateId);
                                break;
                            }
                        }
                        break;          
                    case 4:
                        //Delete Student 
                        String deleteId;
                        System.out.print("Enter Student ID to delete: ");   
                        deleteId = scanner.next();
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].Id.equals(deleteId)) {
                                students[i].deletePerson(deleteId,"Student");
                                break;
                            }
                        }   
                        break;
                    case 5:
                        //View All Students
                        viewAll("Student");
                        System.out.println();
                        break; 
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid Choice..Try again!\n");
                        break;
                }
         }else if(choice == 2){
            //Teacher Section
            selectOpt("Teacher");

            System.out.print("Option: ");
            int teacherChoice = scanner.nextInt();
            System.out.println("");

            switch (teacherChoice) {
                    case 1:
                        //Add a Teacher  
                        Teacher newTeacher = (Teacher) Teacher.addPerson(teacherCount);
                        teachers[teacherCount] = newTeacher;
                        teacherCount++;
                        System.out.println("\nTeacher added successfully!\n");

                        break;
                    case 2:
                        //View teacher  
                        String viewId;
                        System.out.print("Enter Teacher ID to view: ");
                        viewId = scanner.next();
                        viewPersonDetails(viewId, "Teacher");
                        break;
                    case 3: 
                        //Update teacher
                        String updateId;
                        System.out.print("Enter Teacher ID to update: ");
                        updateId = scanner.next();
                        for (int i = 0; i < teacherCount; i++) {
                            if (teachers[i].Id.equals(updateId)) {
                                teachers[i].updateTeacher(updateId);
                                break;
                            }
                        }
                        break;          
                    case 4:
                        //Delete teacher
                        String deleteId;
                        System.out.print("Enter Teacher ID to delete: ");   
                        deleteId = scanner.next();
                        for (int i = 0; i < teacherCount; i++) {
                            if (teachers[i].Id.equals(deleteId)) {
                                teachers[i].deletePerson(deleteId,"Teacher");
                                break;
                            }
                        }   
                        break;
                    case 5:
                        //View All Teachers
                        viewAll("Teacher");
                        System.out.println();
                        break; 
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid Choice..Try again!\n");
                        break;
                }


            


        }else if(choice == 3){
            //Staff Section
        }else if(choice == 4){
            System.out.println("Exiting the program.");
            break;
        }else{
            System.out.println("Invalid choice. Please try again.");
        }


    
}
scanner.close();
    

    }
    

}