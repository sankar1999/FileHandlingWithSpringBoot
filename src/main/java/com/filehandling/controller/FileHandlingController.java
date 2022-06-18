package com.filehandling.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@RestController
public class FileHandlingController {

    public FileHandlingController() {
        System.out.println("This is Postconstructor");

        ArrayList<String> Letters = new ArrayList<String>();
//        Cars.add("Tesla");
//        Cars.add("Audi");
//        Cars.add("Benz");

        // ***** File Reading *****

//        StringBuilder strConcat = new StringBuilder();
//        Cars.forEach((temp) -> strConcat.append(temp + " " + "\n"));
//        System.out.println(strConcat);
//        StringBuilder data = new StringBuilder();
        String data = "";

        try {
            File myObj = new File("Files/HelloFile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                Letters.add(data);
                System.out.println(Letters);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("An Error Occurred...");
            e.printStackTrace();
        }

        // *****



        //***** File Writing *****



        try {

            StringBuilder strMakeLine = new StringBuilder();
            //*******
//            Letters.add("iii");
//            Letters.add("jjj");
//            Letters.add("kkk");
            //*******
            String alphabet = "ABCDEFGHIJKLMNOPQURSTUVWXYZ";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int length = 7;
            for (int i=0; i<length; i++) {
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                sb.append(randomChar);
            }
            String strRandomString = sb.toString();
            Letters.add(strRandomString);
           //********
            // Cars.forEach((temp) -> strConcat.append(temp + " " + "\n"));
            Letters.forEach((temp) -> strMakeLine.append(temp + "\n"));

            FileWriter myWriter = new FileWriter("Files/HelloFile.txt");
            myWriter.write(String.valueOf(strMakeLine));
            myWriter.close();
            System.out.println("File successfully written...");
            System.out.println(strMakeLine);
        }
        catch (IOException e) {
            System.out.println("An error Occurred.");
            e.printStackTrace();
        }
    }
}
