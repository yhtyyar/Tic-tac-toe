package main.java.com.yhtyyar.tictactoe;

import static main.java.com.yhtyyar.tictactoe.GameLogic.*;

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
            for (int i = 0; i < FIELD_SIZE; i++) {
                System.out.print(i + 1 +"\t");
                for (int j = 0; j < FIELD_SIZE; j++) {
                    System.out.print(FIELD[i][j] + "\t");
                }
                System.out.println();

            }
        }


}
