package BookManagement;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private String bookID;
    private String  bookName;
    private String author;
    private String specialization;
    private int publishYear;
    private double quantity;

    public void createBook() {
        Pattern pattern;
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        bookID = scanner.nextLine();
        System.out.print("Enter book name: ");
        bookName = scanner.nextLine();
        System.out.print("Enter author: ");
        author = scanner.nextLine();
        do {
            System.out.print("Enter specialization (Art, Science, Economic, IT): ");
            specialization = scanner.nextLine();
            pattern = Pattern.compile("Art|Science|Economic|IT");
            matcher = pattern.matcher(specialization);
        } while(!matcher.matches());
        System.out.print("Enter publish year: ");
        publishYear = scanner.nextInt();
        System.out.print("Enter quantity: ");
        quantity = scanner.nextDouble();
    }
    public void readFileBook() throws IOException {
        Scanner readFile = new Scanner(Paths.get("D:\\JavaProject\\BookManagement\\BOOK.DAT"), "UTF-8");
        String read;
        while(readFile.hasNextLine()) {
            read = readFile.nextLine();
            System.out.println("BOOK ID: " + read);
            read = readFile.nextLine();
            System.out.println("Book name: " + read);
            read = readFile.nextLine();
            System.out.println("Author: " + read);
            read = readFile.nextLine();
            System.out.println("Specialization: " + read);
            read = readFile.nextLine();
            System.out.println("Publish Year: " + read);
            read = readFile.nextLine();
            System.out.println("Quantity: " + read);
            read = readFile.nextLine();
            System.out.println(read);
        }
        readFile.close();
    }
    public void writeFileBook() throws IOException {
        File file = new File("BOOK.DAT");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        if(!file.exists()) {
            file.createNewFile();
        }
        fileWriter = new FileWriter(file.getAbsoluteFile(), true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(bookID + "\n" + bookName + "\n" + author + "\n" + specialization + "\n"
                + publishYear + "\n" + quantity + "\n\n");
        bufferedWriter.close();
        fileWriter.close();
    }
}


















