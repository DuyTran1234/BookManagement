package BookManagement;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookReaderManagement {

    public void createInfo() throws IOException {
        String[] nameReader = new String[1000];
        int i = 0;
        int amountBook = 0;
        File file = new File("D:\\JavaProject\\BookManagement\\READER.DAT");
        File paths = new File("D:\\JavaProject\\BookManagement\\BRM.DAT");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        Scanner readFile = new Scanner(file, "UTF-8");
        Scanner scanner = new Scanner(System.in);
        if (!file.exists()) {
            System.out.println("Infor Reader not exists");
        } else {
            while (readFile.hasNextLine()) {
                readFile.nextLine();
                nameReader[i] = readFile.nextLine();
                for (int j = 1; j <= 3; j++) {
                    readFile.nextLine();
                }
                i++;
            }
        }
        if (!paths.exists()) {
            paths.createNewFile();
        } else {
            fileWriter = new FileWriter(paths, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int j = 0; j < i; j++) {
                System.out.println("Reader name: " + nameReader[j]);
                bufferedWriter.write(nameReader[j] + "\n");
                System.out.print("Enter amount book borrow: ");
                amountBook = scanner.nextInt();
                String getBuffer = scanner.nextLine();
                bufferedWriter.write(amountBook + "\n");
                for (int k = 0; k < amountBook; k++) {
                    while (true) {
                        System.out.print("Enter ID Book need borrow: ");
                        String str = scanner.nextLine();
                        if (checkBookID(str) == true) {
                            bufferedWriter.write(str + "\n");
                            break;
                        } else {
                            System.out.println("Wrong Input Book ID, please enter again!");
                        }
                    }
                    //bufferedWriter.write("\n");
                }
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        }
        readFile.close();

    }

    public boolean checkBookID(String str) throws IOException {
        File file = new File("D:\\JavaProject\\BookManagement\\BOOK.DAT");
        Scanner readFile = new Scanner(file, "UTF-8");
        String[] listBook = new String[1000];
        int i = 0;
        if (!file.exists()) {
            return false;
        } else {
            while (readFile.hasNextLine()) {
                listBook[i] = readFile.nextLine();
                for (int j = 1; j <= 6; j++) {
                    readFile.nextLine();
                }
                i++;
            }
        }
        for (int j = 0; j < i; j++) {
            if (listBook[j].equals(str) == true) {
                return true;
            }
        }
        return false;
    }

    public void readFileBRM() throws IOException {
        File file = new File("D:\\JavaProject\\BookManagement\\BRM.DAT");
        Scanner readFile = new Scanner(file, "UTF-8");
        String str;
        if (!file.exists()) {
            return;
        }
        while (readFile.hasNextLine()) {
            String check = readFile.nextLine();
            System.out.println("Reader name: " + check);
            check = readFile.nextLine();
            System.out.println("Amount Book borrowed: " + check);
            System.out.println("List book id reader borrowed: ");
            check = readFile.nextLine();
            while (!check.equals("") && readFile.hasNextLine() == true) {
                System.out.println(check);
                check = readFile.nextLine();
            }
            System.out.println();
        }
        readFile.close();
    }

    public void sortListBasedName() throws IOException {
        String[][] getListName = getListBRM();
        for (int i = 1; getListName[i - 1][0] != null; i++) {
            for (int j = i; getListName[j][0] != null; j++) {
                if (getListName[i - 1][0].compareTo(getListName[j][0]) > 0) {
                    for (int k = 0; k < 1000; k++) {
                        String temp = getListName[i - 1][k];
                        getListName[i - 1][k] = getListName[j][k];
                        getListName[j][k] = temp;
                    }
                }
            }
        }
        File file = new File("D:\\JavaProject\\BookManagement\\BRM.DAT");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; getListName[i][0] != null; i++) {
            for (int j = 0; getListName[i][j] != null; j++) {
                bufferedWriter.write(getListName[i][j] + "\n");
            }
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public void sortListBasedAmount() throws IOException {
        String[][] list = getListBRM();
        for (int i = 1; list[i - 1][0] != null; i++) {
            for (int j = i; list[j][0] != null; j++) {
                int a = Integer.parseInt(list[i - 1][1]);
                int b = Integer.parseInt(list[j][1]);
                if (a < b) {
                    for (int k = 0; k < 1000; k++) {
                        String temp = list[i - 1][k];
                        list[i - 1][k] = list[j][k];
                        list[j][k] = temp;
                    }
                }
            }
        }
            File file = new File("D:\\JavaProject\\BookManagement\\BRM.DAT");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; list[i][0] != null; i++) {
                for(int j = 0; list[i][j] != null; j++) {
                    bufferedWriter.write(list[i][j] + "\n");
                }
            }
            bufferedWriter.close();
            fileWriter.close();
    }

    public String[][] getListBRM() throws IOException {
        File file = new File("D:\\JavaProject\\BookManagement\\BRM.DAT");
        Scanner readFile = new Scanner(file, "UTF-8");
        String[][] listInfo = new String[1000][1000];
        Matcher matcher;
        Pattern pattern = Pattern.compile("[A-Za-z\\s+]+");
        int row = 0;
        int col = 0;
        while (readFile.hasNextLine()) {
            col = 0;
            String str = readFile.nextLine();
            matcher = pattern.matcher(str);
            if (matcher.matches()) {
                listInfo[row][col] = str;
                col++;
            }
            while (!str.equals("") && readFile.hasNextLine() == true) {
                str = readFile.nextLine();
                listInfo[row][col] = str;
                col++;
            }
            row++;
        }
        return listInfo;
    }
    public void searchInfo() throws IOException {
        boolean check = false;
        File file = new File("D:\\JavaProject\\BookManagement\\BRM.DAT");
        System.out.print("Enter name reader: ");
        Scanner scanner = new Scanner(System.in);
        String strName = scanner.nextLine();
        Scanner readFile = new Scanner(file, "UTF-8");
        while(readFile.hasNextLine()) {
            String str = readFile.nextLine();
            if(strName.equals(str)) {
                check = true;
                System.out.println("Name reader: " + str);
                str = readFile.nextLine();
                System.out.println("Amout book borrowed: " + str);
                System.out.println("List book ID borrowed: ");
                while(!str.equals("") && readFile.hasNextLine()) {
                    str = readFile.nextLine();
                    System.out.println(str);
                }
            }
        }
        if(check == false) {
            System.out.println("Name reader not in list BRM");
        }
    }
}







