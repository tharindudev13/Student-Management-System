
public class Teacher extends Person{
    String subject;


    public Teacher(String name, int age, String Id, String Email, String subject) {
        super(name, age, Id, Email);
        this.subject = subject;
    }
    @Override
    void showDetails(){
        super.showDetails();
        System.out.print("Subjects: " + subject);
        
        
        System.out.println();


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