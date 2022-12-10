package org.lockersapp;

public class Main {

    //This is where it starts
    public static void main(String[] args) {
        DisplayScreen screen = new DisplayScreen();
        MenuOperations options = new MenuOperations();

        screen.welcomeScreen();
        options.selectMainOptions();
    }


}
