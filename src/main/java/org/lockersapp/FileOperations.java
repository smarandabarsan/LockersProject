package org.lockersapp;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOperations {

    //The directory path should be set here
    public static final String directoryPath = "C:\\Users\\smaranda.barsan\\Desktop\\Directory\\";



    //Method: List all files in the directory
    public void showFileList(String directoryPath){

            if (directoryPath == null || directoryPath.isEmpty() || directoryPath.isBlank())
                throw new NullPointerException("Please make sure the directory path is set and is not empty.");

            File directory = new File(directoryPath);

            if(!directory.exists())
                throw new IllegalArgumentException("The directory doesn't exist.");
            if(directory.isFile())
                throw new IllegalArgumentException("The directory cannot be a file. Please provide a path.");

            String[] files = directory.list();

            if(files != null && files.length > 0) {

                Set<String>fileList = new TreeSet<String>(Arrays.asList(files));
                System.out.println("The files in "+directory.getAbsolutePath()+" are:");
                for(String file1:fileList) {
                    System.out.println(file1);
                }
                System.out.println("\n Total number of files: "+fileList.size());
                System.out.println("\n");

            }else {
                System.out.println("The directory is empty");
            }

    }
    //Method: Add a file to the existing directory list (ignore case sensitivity)
    public void addNewFile(String directoryPath, String fileName) throws IOException {

        //if (fileName == null || fileName.isEmpty() || fileName.isBlank());
        //throw new NullPointerException("Make sure the file exists and is not empty!");

        if (directoryPath == null || directoryPath.isEmpty() || directoryPath.isBlank())
            throw new NullPointerException("Please make sure the directory path is set and is not empty!");

        File newFileToBeCreated = new File(directoryPath+File.separator+fileName);
        boolean createFile = newFileToBeCreated.createNewFile();


        if (createFile == true) {
            System.out.println("\nFile has been successfully created: " + newFileToBeCreated.getAbsolutePath());

        }else {
            System.out.println("\nFile could not be created. The file exists already. Please try again.");
        }


    }
    //Method: Delete a user specified file from the existing directory list
    public void deleteFile(String directoryPath, String fileName) {

        if (directoryPath == null || directoryPath.isEmpty() || directoryPath.isBlank())
            throw new NullPointerException("Please make sure the directory path is set and is not empty!");

        //if (fileName == null || fileName.isEmpty() || fileName.isBlank());
        //throw new NullPointerException("Make sure the file exists and is not empty!");

        File newFileToBeDeleted = new File(directoryPath+File.separator+fileName);
        boolean deleteFile = newFileToBeDeleted.delete();

        if (deleteFile) {

            System.out.println("\nFile deleted successfully");

        }else {

            System.out.println("\nFile Not Found... Please try again." );

        }


    }
    //Method: Search a user specified file from the main directory
    public void searchFile(String directoryPath, String fileName) {

        if (directoryPath == null || directoryPath.isEmpty() || directoryPath.isBlank())
            throw new NullPointerException("Please make sure the directory path is set and is not empty!");

        File directory = new File(directoryPath);

        if(!directory.exists())
            throw new IllegalArgumentException("The directory doesn't exist.");
        if(directory.isFile())
            throw new IllegalArgumentException("The directory cannot be a file. Please provide a path.");

        String[] fileList = directory.list();
        boolean flag = false;
        Pattern pat = Pattern.compile(fileName);

        if(fileList != null && fileList.length > 0) {
            for(String file:fileList) {
                Matcher mat = pat.matcher(file);
                if(mat.matches()) {
                    System.out.println("File found at location: " + directory.getAbsolutePath());
                    flag = true;
                    break;
                }
            }
        }
        if(flag == false)
            System.out.println("File not found. Please try again.");

    }
}
