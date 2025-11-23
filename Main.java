import java.util.Scanner;



public class Main {
    static Student[] students = new Student[100];
    static Teacher[] teachers = new Teacher[100];
    static Staff[] staffs = new Staff[100];

    static int studentCount = 0;
    static int teacherCount = 0;       
    static int staffCount = 0;

    static Scanner scanner = new Scanner(System.in);


    static void viewPersonDetails(String type){ 

        String id;
        System.out.print("Enter Student ID to view: ");
        id = scanner.next();

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
        System.out.println("----------------------------------\n");
        

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
            System.out.println("EId\tName\t\tAge\tRole");
        }

        for (int i = 0; i < Count; i++) {
            if(!arr[i].isDeleted){
                arr[i].show();
            }
            
            
        }
        System.out.println("----------------------------------\n");

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

    static void delt(String type){
        String deleteId;
        int Count;
        System.out.print("Enter "+ type +"ID to delete: ");   
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

        deleteId = scanner.next();
        for (int i = 0; i < Count; i++) {
            if (arr[i].Id.equals(deleteId)) {
                arr[i].deletePerson(deleteId,type);
                break;
            }
        }   

    }
    public static void main(String[] args) {

        System.out.println("\t___________________________________________\n");
	    System.out.println("\t-------- STUDENT MANAGEMENT SYSTEM --------");
	    System.out.println("\t___________________________________________\n");



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
                        viewPersonDetails("Student");
                        break;
                    case 3: 
                        //Update Student
                        delt("Student");
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
                        viewPersonDetails( "Teacher");
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
                        delt("Teacher");
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
            selectOpt("Employee");

            System.out.print("Option: ");
            int staffChoice = scanner.nextInt();
            System.out.println("");

            switch (staffChoice) {
                    case 1:
                        //Add an Employee  
                        Staff newEmployee = (Staff) Staff.addPerson(staffCount);
                        staffs[staffCount] = newEmployee;
                        staffCount++;
                        System.out.println("\nEmployee added successfully!\n");

                        break;
                    case 2:
                        //View teacher  
                        viewPersonDetails( "Staff");
                        break;
                    case 3: 
                        //Update teacher
                        String updateId;
                        System.out.print("Enter Employee ID to update: ");
                        updateId = scanner.next();
                        for (int i = 0; i < staffCount; i++) {
                            if (staffs[i].Id.equals(updateId)) {
                                staffs[i].updateEmployee(updateId);
                                break;
                            }
                        }
                        break;          
                    case 4:
                        //Delete teacher
                        delt("Staff");
                        break;
                    case 5:
                        //View All Teachers
                        viewAll("Staff");
                        System.out.println();
                        break; 
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid Choice..Try again!\n");
                        break;
                }
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