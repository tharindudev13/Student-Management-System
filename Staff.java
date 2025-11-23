
public class Staff extends Person {
    String Position;
    private int workDays;
    double salary;

    public Staff(String name, int age, String Id, String Email, String Position) {
        super(name, age, Id, Email);
        this.Position = Position;
    }

    @Override
    void showDetails(){ 
        super.showDetails();
        System.out.println("Position:\t" + Position);
    }

    @Override
    void show(){
        super.show();
        System.out.print(Position+"\t");   
        System.out.println();

    }

    static Person addPerson(int count){

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: "); 
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline


        String Id = "E" + String.valueOf(count + 1);

        System.out.print("Email: ");
        String Email = scanner.nextLine();

        System.out.print("Position: ");
        String Position = scanner.nextLine();

        Staff staff = new Staff(name, age, Id, Email, Position);

        return staff;

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

    void updateEmployee(String id){
        if (this.Id.equals(id)) {

            System.out.print("Enter new Subject: ");
            this.Position = scanner.nextLine();

            System.out.print("Enter Worked Days: ");
            this.workDays = scanner.nextInt();

            this.salary = Salary();

            System.out.println("Teacher details updated successfully.");
        } else {
            System.out.println("Teacher ID not found.");
        }

    }
    
}
