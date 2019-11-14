package BookManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;

public class Test {
    public static void main(String[] args) throws  IOException{
        FileWriter fileWriter = null;
        String data = "FU?";
        BufferedWriter bufferedWriter = null;
        File file = new File("C:\\Users\\DuyTran\\Desktop\\BookManagement\\test.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        fileWriter = new FileWriter(file.getAbsoluteFile(), true);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(data);
        bufferedWriter.close();
        fileWriter.close();

    }
}























