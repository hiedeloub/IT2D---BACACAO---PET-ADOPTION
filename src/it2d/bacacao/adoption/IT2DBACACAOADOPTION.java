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
                    pet.viewAdoption();
                    
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
        String fname = sc.next();
        System.out.print("Pet Species: ");
        String lname = sc.next();
        System.out.print("Pet Breed: ");
        String email = sc.next();
        System.out.print("Pet Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_PetAdoption (p_name, p_species, p_breed, p_status) VALUES (?, ?, ?, ?)";
        conf.addAdoption(sql, fname, lname, email, status);
        
        
     }
    @SuppressWarnings("empty-statement")
               private void viewAdoption() {
        String petQuery = "SELECT * FROM Adoption";
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        String[] petColumns;
        petColumns = {"p_id", "p_name", "p_species", "p_breed", "p_status"};

        conf.viewRecords(petQuery, petColumns);
    }

    private static class conf {

        private static void viewRecords(String votersQuery, String[] votersHeaders, String[] votersColumns) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void viewRecords(String petQuery, String[] petColumns) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public conf() {
        }
    }
   
}