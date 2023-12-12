package day13.day13speedrun.services;

import org.springframework.stereotype.Service;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Date;

import java.nio.file.Paths;

import day13.day13speedrun.model.Employee;

import java.util.Random;


@Service
public class Contacts {
    
    final String dirPath= "C:\\Users\\orbis\\data";

    public String genID(){

        Random rand = new Random();
        int n = rand.nextInt(Integer.MAX_VALUE); // make it all positive.
        // you can make it into hexadeciaml*
        String Hexadecimal = Integer.toHexString(n);
        String formattedHex = String.format("%8s",Hexadecimal).replace(' ', '0');
        return formattedHex;
    }

    private void createFile(Path filePath) throws IOException {
        Files.createFile(filePath);
    }

    private void writeDataToFile(Path filePath, String name, String email, String phoneNo, Date date,String id)
            throws IOException {
            String fileContent = String.format("Name: %s%nEmail: %s%nPhone Number: %s%nDate of Birth: %s%nID: %s%n",
            name, email, phoneNo, date, id);

        Files.writeString(filePath, fileContent, StandardOpenOption.WRITE);
    }

    public void ProcessContactData(Employee emp){
        //generate an ID
        String newId = genID();
        // Overwrite the data of ID* ( this is where you use ur getters and setters.)
        emp.setId(newId);

        // now using this same id* i make a path of the same name with the details inside*
        // you need filepath to create file in the first place. 

        Path filePath = Paths.get(dirPath,emp.getId()+".txt");

        try{
            createFile(filePath);
            writeDataToFile(filePath, emp.getName(), emp.getEmail(), emp.getPhoneNumber(), emp.getDob(), emp.getId());
            System.out.println("File created successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
           
        }

    }


}


