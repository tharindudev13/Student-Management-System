
public class Staff extends Person {
    String Position;

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
    
}
