package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int horizontal, vertical;
        String input;
        Scanner scanned = new Scanner(System.in);

        System.out.println("Please enter your dimensions, followed by your tetrominos");
        horizontal = scanned.nextInt();
        vertical = scanned.nextInt();
        scanned.nextLine();
        input = scanned.nextLine();


        Board myTetris = new Board(horizontal, vertical);

        Player myPlayer = new Player (input, horizontal, vertical);

        long begin = System.currentTimeMillis();
        myPlayer.printSolution(myTetris);
        long end = System.currentTimeMillis();

        System.out.println( (end - begin) / 1000 + " seconds");

    }
}
