package org.lockersapp;

import java.util.Scanner;
import java.io.IOException;

public class MenuOperations {
    // First option should return the current file names in ascending order.
    // The root directory can be either empty or contain few files or folders in it
    // Second option should return the details of the user interface such as options displaying the following: see FileOperations
    // Third option to close the application

    Scanner input = new Scanner(System.in);
    DisplayScreen screen = new DisplayScreen();
    FileOperations fop = new FileOperations();

    public void selectMainOptions() {

        int selectedOption = 0;
        char decision = 0;

        do {
            screen.mainOptionsScreen();

            try {
                selectedOption = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Your input doesn't work. Please enter one of the following options: 1,2 or 3.");
            }

            switch (selectedOption) {

                case 1:

                    try {
                        fop.showFileList(FileOperations.directoryPath);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println();
                    selectFileOptions();
                    break;
                case 3:
                    System.out.println("Do you wish to exit?");
                    System.out.println("Select (Y/N):");
                    decision = input.nextLine().toUpperCase().charAt(0);
                    if (decision == 'Y'){
                        screen.exitScreen();
                        System.exit(1);
                    }else if(decision == 'N'){
                        screen.mainOptionsScreen();
                    }else {
                        System.out.println("Your input doesn't work. Please select (Y/N)");
                        screen.mainOptionsScreen();
                    }
                default:
                    System.out.println("You can only select options from 1 to 3.");
                    screen.mainOptionsScreen();

            }

        }while (true);
    }
    public void selectFileOptions() {
        int selectedOption = 0;
        String file = null;
        String fileName = null;

        do {
            screen.fileOptionsScreen();

            try {
                selectedOption = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Your input doesn't work. Please select options from 1 to 4.");
            }

            switch (selectedOption) {
                case 1:
                    System.out.println("You've selected to add a file.");
                    System.out.println("Please enter a file name: ");
                    file = input.nextLine();
                    fileName = file.trim();
                    try{
                        fop.addNewFile(FileOperations.directoryPath, fileName);
                    }catch(NullPointerException e){
                        System.out.println(e.getMessage());
                    }catch(IOException e) {
                        System.out.println("Error occurred while adding file..");
                        System.out.println("Please try again...");
                    }catch(Exception e) {
                        System.out.println("Error occurred while adding file..");
                        System.out.println("Please try again...");
                    }
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("You've chosen to delete a file");
                    System.out.println("Please enter a file name to be deleted : ");
                    file = input.nextLine();
                    fileName = file.trim();
                    try {
                        fop.deleteFile(FileOperations.directoryPath, fileName);
                    }catch(NullPointerException e) {
                        System.out.println(e.getMessage());
                    }catch(Exception e) {
                        System.out.println("Error occurred while deleting file.");
                        System.out.println("Please try again...");
                    }
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("\n==> Searching a File...");
                    System.out.println("Please enter a file name to Search : ");
                    file = input.nextLine();
                    fileName = file.trim();
                    try {
                        fop.searchFile(FileOperations.directoryPath, fileName);
                    }catch(NullPointerException e) {
                        System.out.println(e.getMessage());
                    }catch(IllegalArgumentException e) {
                        System.out.println("Error occurred while searching file.");
                        System.out.println("Please try again...");
                    }catch(Exception e) {
                        System.out.println("Error occurred while searching file.");
                        System.out.println("Please try again...");
                    }
                    System.out.println("\n");
                    break;

                case 4: selectMainOptions();
                    break;
                default:
                    System.out.println("You can only select options from 1 to 4.");
                    screen.fileOptionsScreen();
            }

        }while (true);

    }
}