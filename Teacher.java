
public class Teacher extends Person{
    String[] Subjects;


    public Teacher(String name, int age, String Id, String Email, String[] Subjects) {
        super(name, age, Id, Email);
        this.Subjects = Subjects;
    }
    @Override
    void showDetails(){
        super.showDetails();
        System.out.print("Subjects: ");
        for (String subject : Subjects) {
            System.out.print(subject + " ");
        }
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

        System.out.print("Number of Subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] Subjects = new String[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            Subjects[i] = scanner.nextLine();
        }

        Teacher teacher = new Teacher(name, age, Id, Email, Subjects);

        return teacher;

    }
}