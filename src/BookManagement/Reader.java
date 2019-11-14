package BookManagement;

import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    private String readerID;
    private String fullName;
    private String address;
    private String phoneNumber;

    public void createReader() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern;
        Matcher matcher;
        System.out.print("Enter reader ID: ");
        readerID = scanner.nextLine();
        do {
            System.out.print("Enter full name: ");
            fullName = scanner.nextLine();
            pattern = Pattern.compile("^[A-Z][a-zA-Z\\s]+");
            matcher = pattern.matcher(fullName);
        } while(!matcher.matches());
        System.out.print("Enter address: ");
        address = scanner.nextLine();
        do {
            System.out.print("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            pattern = Pattern.compile("[0-9\\s]+");
            matcher = pattern.matcher(phoneNumber);
        } while(!matcher.matches());
    }
    public void readFileReader() throws IOException {
        Scanner readFile = new Scanner(Paths.get("D:\\JavaProject\\BookManagement\\READER.DAT"), "UTF-8");
        String str;
        while(readFile.hasNextLine()) {
            str = readFile.nextLine();
            System.out.println("ReaderID: " + str);
            str = readFile.nextLine();
            System.out.println("Full Name: " + str);
            str = readFile.nextLine();
            System.out.println("Address: " + str);
            str = readFile.nextLine();
            System.out.println("Phone Number: " + str);
            str = readFile.nextLine();
            System.out.println(str);
        }
        readFile.close();
    }
    public void writeFileReader() throws IOException {
        File file = new File("D:\\JavaProject\\BookManagement\\READER.DAT");
        if(!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        fileWriter = new FileWriter(file.getAbsoluteFile(), true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(readerID + "\n" + fullName + "\n" + address + "\n" + phoneNumber + "\n\n");
        bufferedWriter.close();
        fileWriter.close();
    }
}











