import java.util.Scanner;

public class Person {
     String name;
     int age;
     String Id;
     String Email;
     boolean isDeleted = false;

    static Scanner scanner = new Scanner(System.in);
     

    public Person(String name, int age, String Id, String Email) {
        this.name = name;
        this.age = age;
        this.Id = Id;
        this.Email = Email;
    }

    void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + Id);
    }

    void deletePerson(String id){
        if (this.Id.equals(id)) {
            System.out.println("Person with ID " + id + " has been deleted.");
            this.isDeleted = true;
        } else {
            System.out.println("Person ID not found.");
        }

    }


    

    
}


