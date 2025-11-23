
public class Teacher extends Person{
    String subject;
    private int workDays;
    double salary;


    public Teacher(String name, int age, String Id, String Email, String subject) {
        super(name, age, Id, Email);
        this.subject = subject;
    }

    private double Salary(){
        double bonus = 0;
        double basic = workDays * 1500;
        if(workDays > 20){
            bonus = basic * 0.25;
        }

        salary = basic + bonus;
        return salary;
    }

    

    

    

    @Override
    void showDetails(){
        super.showDetails();
        System.out.print("Subjects: " + subject);
        
        
        System.out.println();


    }

    void updateTeacher(String id){
        if (this.Id.equals(id)) {

            System.out.print("Enter new Subject: ");
            this.subject = scanner.nextLine();

            System.out.print("Enter Worked Days: ");
            this.workDays = scanner.nextInt();

            this.salary = Salary();

            System.out.println("Teacher details updated successfully.");
        } else {
            System.out.println("Teacher ID not found.");
        }

    }

    

    @Override
    void show(){
        super.show();
        System.out.print(subject+"\t"); 
        System.out.println();

    }

    static Person addPerson(int count){

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: "); 
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String Id = "T" + String.valueOf(count + 1);

        System.out.print("Email: ");
        String Email = scanner.nextLine();

        System.out.print("Subject: ");
        String subject = scanner.nextLine();

        
        Teacher teacher = new Teacher(name, age, Id, Email, subject);

        return teacher;

    }
}