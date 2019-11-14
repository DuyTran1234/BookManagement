package BookManagement;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String getBuffer;
        while(true) {
            Book newBook = new Book();
            Reader newReader = new Reader();
            BookReaderManagement bookReaderManagement = new BookReaderManagement();
            System.out.println("====================== MENU ======================");
            System.out.println("1. Add Book in file BOOK.DAT");
            System.out.println("2. Print list book from file BOOK.DAT");
            System.out.println("3. Add reader in file READER.DAT");
            System.out.println("4. Print list reader from file");
            System.out.println("5. Create infomation Book reader");
            System.out.println("6. Print list infomation Book reader");
            System.out.println("7. Sort list book reader management");
            System.out.println("8. Search and display infomation in BookReaderManagement based on name reader");
            System.out.println("0. Exit");
            System.out.print("#Select: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 0) {
                break;
            }
            else if(choice == 1) {
                newBook.createBook();
                newBook.writeFileBook();
            }
            else if(choice == 2) {
                newBook.readFileBook();
            }
            else if(choice == 3) {
                newReader.createReader();
                newReader.writeFileReader();
            }
            else if(choice == 4) {
                newReader.readFileReader();
            }
            else if(choice == 5) {
                bookReaderManagement.createInfo();
            }
            else if(choice == 6) {
                bookReaderManagement.readFileBRM();
            }
            else if(choice == 7) {
                int select = 0;
                System.out.println("1. Sort list based on name reader");
                System.out.println("2. Sort list based on amount book borrowed");
                System.out.print("#Select: ");
                select = scanner.nextInt();
                getBuffer = scanner.nextLine();
                if(select == 1) {
                    bookReaderManagement.sortListBasedName();
                }
                else if (select == 2) {
                    bookReaderManagement.sortListBasedAmount();
                }
            }
            else if(choice == 8) {
                bookReaderManagement.searchInfo();
            }
            else {
                System.out.println("Wrong input, please enter again!!");
            }
        }
    }
}
























