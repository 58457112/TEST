import Controllers.PatientController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static Controllers.PatientController.*;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://127.0.0.1:3306/login_shema";
        try {


            Connection connection = DriverManager.getConnection(URL, "root", "Chedysoltani");
            System.out.println("yessss");
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM PATIENT");

        }
        catch (Exception e){
            System.out.println("leeee");

        }
        // Création d'un objet PatientController2
        PatientController patientController = new PatientController();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Affichage du menu
            System.out.println("Menu :");
            System.out.println("1. Afficher tous les patients");
            System.out.println("2. Créer un nouveau patient");
            System.out.println("3. Mise a jour");
            System.out.println("4. Supp2rimer un patient");
            System.out.print("Choisissez une option : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Afficher tous les patients
                    displayAllPatients(patientController);
                    break;
                case 2:
                    // Créer un nouveau patient
                    createNewPatient(patientController, scanner);
                    break;
                case 3:
                    updatePatientInfo(patientController, scanner);

                    break;
                case 4:
                    // Supprimer un patient
                    deletePatient(patientController, scanner);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        }

        scanner.close();
    }
}


