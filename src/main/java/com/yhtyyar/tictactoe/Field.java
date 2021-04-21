package main.java.com.yhtyyar.tictactoe;

import static main.java.com.yhtyyar.tictactoe.GameLogic.FIELD_SIZE;
import static main.java.com.yhtyyar.tictactoe.GameLogic.NULL;

// Игровое поле
public class Field {

    static final char [] [] FIELD  = new char [FIELD_SIZE][FIELD_SIZE];


    static void initField () {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                FIELD[i][j] = NULL;
            }
        }

    }

    static void printField() {
        int number = 1;
        System.out.println("         1   2   3");
        System.out.println("       -------------" );
        for(int i = 0; i < FIELD_SIZE; i++) {
            //выводит вертикальные номера в поле
            while (number <= FIELD_SIZE) {
                System.out.print("     " + number + " ");
                number++;

                for (int j = 0; j < FIELD_SIZE; j++) {
                    System.out.print("| " + FIELD[i][j] + " ");
                }
                System.out.print( "|");
                System.out.println();
            }
        }
    }

}
