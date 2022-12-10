package org.lockersapp;

public class DisplayScreen {

    //Application name and the developer details
    public void welcomeScreen() {
        System.out.println("****************************");
        System.out.println("*         Developer:       *");
        System.out.println("*      Smaranda Barsan     *");
        System.out.println("****************************");
        System.out.println("*     Application name:    *");
        System.out.println("*       LockedMe.Com       *");
        System.out.println("****************************");
        System.out.println("*       Developed for:     *");
        System.out.println("*     Lockers Pvt. Ltd.    *");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("\n");


    }
    public void exitScreen() {
        System.out.println("****************************");
        System.out.println("*  Thank you for visiting  *");
        System.out.println("****************************");
        System.out.println("*      LockedMe.Com        *");
        System.out.println("****************************");
        System.out.println("\n");

    }
    //Options displaying the user interaction information
    public void mainOptionsScreen() {
        System.out.println("***********************************");
        System.out.println("*  Please select an option:       *");
        System.out.println("***********************************");
        System.out.println("1) List current file names         ");
        System.out.println("2) Add, delete or search for a file");
        System.out.println("3) Exit this application           ");
        System.out.println("***********************************");
        System.out.println("\n");
    }
    //Features to accept the user input to select one of the options listed
    public void fileOptionsScreen() {
        System.out.println("****************************************");
        System.out.println("*  Please select a further option:     *");
        System.out.println("****************************************");
        System.out.println("1) Add a file to the directory list     ");
        System.out.println("2) Delete a file from the directory list");
        System.out.println("3) Search a file in the directory       ");
        System.out.println("4) Navigate back to the main menu       ");
        System.out.println("****************************************");
        System.out.println("\n");
    }

}