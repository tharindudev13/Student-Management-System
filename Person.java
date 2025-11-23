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
        this.Email = Email;
        this.Id = Id;
    }

    void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + Id);
    }

    void deletePerson(String id,String type){
        if (this.Id.equals(id)) {
            System.out.println(type + " with ID " + id + " has been deleted.\n");
            this.isDeleted = true;
        } else {
            System.out.println(type + " ID not found.\n");
        }

    }

    void show(){
        System.out.print(Id+"\t"+ name + "\t" + age + "\t"); 
        
    }


    

    
}


