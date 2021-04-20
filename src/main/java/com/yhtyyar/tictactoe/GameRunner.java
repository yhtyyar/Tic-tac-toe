package main.java.com.yhtyyar.tictactoe;

import static main.java.com.yhtyyar.tictactoe.GameLogic.*;
import static main.java.com.yhtyyar.tictactoe.Field.*;

public class GameRunner {

    public static void main(String [] args) {


        System.out.println("    Игра запущена...   ");
        System.out.println("     Удачной игры \n");

        System.out.println("  Ход игрока отображается - Х");
        System.out.println("  Ход компютера отображается - 0 \n");

        System.out.println("  Выберите клетку в которую вы хотите попасть \n");



        initField();
        printField();

        computer_s_Move ();


    }


}
