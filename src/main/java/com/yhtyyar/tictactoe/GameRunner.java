package main.java.com.yhtyyar.tictactoe;

import static main.java.com.yhtyyar.tictactoe.GameLogic.*;
import static main.java.com.yhtyyar.tictactoe.Field.*;

public class GameRunner {

    public static void main(String [] args) {


        System.out.println("       Игра запущена...   ");
        System.out.println("        Удачной игры! \n");

        System.out.println("  Ход игрока отображается - Х");
        System.out.println("  Ход компютера отображается - 0 \n");

        System.out.println("  Выберите клетку в которую вы хотите попасть \n");



        initField();
        printField();

        while (true) {
            player_s_Move();
            System.out.println();
            printField();
            if (winCheck(PLAYER)) {
                System.out.println("  Ураа вы победили!");
                break;
            }
            if (freePlace()) {
                System.out.println(" Увы дружная ничья");
                break;
            }
            computer_s_Move();
            System.out.println();
            printField();
            if (winCheck(COMPUTER)) {
                System.out.println("  К сожалению вы проиграли");
                break;
            }
            if (freePlace()) {
                System.out.println(" Увы дружная ничья");
                break;
            }
        }

    }

}
