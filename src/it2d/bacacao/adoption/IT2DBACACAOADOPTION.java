package it2d.bacacao.adoption;

import java.util.Scanner;


public class IT2DBACACAOADOPTION {

    public static void main(String[] args) {
        
        
           Scanner sc = new Scanner(System.in);
           String response;
           do{
        
         System.out.println("\nPet Adoption System");
            System.out.println("1. Add Pet");
            System.out.println("2. View Pets");
            System.out.println("3. Update Pet");
            System.out.println("4. Delete Pet");
            System.out.println("5. Exit");
            
            System.out.print("Enter action: ");
            int action = sc.nextInt();
            IT2DBACACAOADOPTION pet = new IT2DBACACAOADOPTION ();
            switch(action){
                case 1:
                    pet.addAdoption();
                break;
                case 2:
          
                    
                break;
            }
             System.out.println("Do you want to continue? (yes/no): ");
             response = sc.next();
             
             
           }while(response.equalsIgnoreCase("yes"));
           System.out.println("Thank You! ");
    }
               public void addAdoption(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Pet Name: ");
        String name = sc.next();
        System.out.print("Pet Species: ");
        String species = sc.next();
        System.out.print("Pet Breed: ");
        String breed = sc.next();
        System.out.print("Pet Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_PetAdoption (p_name, p_species, p_breed, p_status) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, name, species, breed, status);
        
        
  
    }

  
   
}