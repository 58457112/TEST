package Controllers;

import Models.Patient_model;

import java.io.*;
import java.util.ArrayList;

public class PatientPersistence {
    private static final String FILENAME = "patients.txt";

    public static void savePatients(ArrayList<Patient_model> patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(patients);
            System.out.println("Données des patients sauvegardées avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des données des patients : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Patient_model> loadPatients() {
        ArrayList<Patient_model> patients = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            patients = (ArrayList<Patient_model>) ois.readObject();
            System.out.println("Données des patients chargées avec succès.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement des données des patients : " + e.getMessage());
        }
        return patients;
    }
}

