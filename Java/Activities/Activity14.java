package activities;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/activities/newFile.txt");
        boolean fStatus = file.createNewFile();
        String str = "This is FST Training activity";
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] strToBytes = str.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
        File fileUtil = FileUtils.getFile("src/main/java/activities/newFile.txt");
        System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
        File destDir = new File("src/main/resources");
        FileUtils.copyFileToDirectory(file, destDir);
        File newFile = FileUtils.getFile(destDir, "newFile.txt");
        String newFileData = FileUtils.readFileToString(newFile, "UTF8");
        System.out.println("Data from new file is: " + newFileData);
    }
}
