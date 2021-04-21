package main.java.com.yhtyyar.tictactoe;

import java.io.IOException;

import static main.java.com.yhtyyar.tictactoe.GameLogic.*;
import static main.java.com.yhtyyar.tictactoe.Field.*;

public class GameRunner {

    public static void main(String [] args) throws IOException {

        int choice;

        do {
        System.out.println("       Игра запущена...   ");

            System.out.println("    Меню ");
            System.out.println("    1.Правила Игры ");
            System.out.println("    2.Правила ввода ходов");
            System.out.println("    3.Играть");
            System.out.println(" Выберите нужный пункт: ");
            choice =  System.in.read();
        } while (choice < 1 || choice > 3);

        System.out.println();
        System.out.println();

        switch (choice) {
            case 1:
                System.out.println("   Крестики-нолики это логическая игра между двумя " );
                System.out.println("  противниками на квадратном поле 3 на 3 клетки.");
                System.out.println("  Один из игроков играет «крестиками», второй — «ноликами».");
                System.out.println("  Игроки по очереди ставят на свободные клетки поля 3х3 знаки.");
                System.out.println("  Первый, выстроивший в ряд 3 своих фигуры по вертикали, " +
                                   "  горизонтали или диагонали, выигрывает. ");
                System.out.println("  Первый ход делает игрок, ставящий крестики.");
                break;
            case 2:
                System.out.println("  Ход игрока отображается - Х");
                System.out.println("  Ход компютера отображается - 0 \n");

                System.out.println(" В первую очередь нужно ввести координату для строки '1,2,3'  и нажать Enter.");
                System.out.println(" На следующей строке нужно ввести данные для столбца '1,2,3' которая ");
                System.out.println(" находится в выбранной вами ранее строке ");
                System.out.println(" После этого ход компютера а дальше всё повторяется до конца игры");
                break;

            case 3:
                System.out.println("        Удачной игры! \n");
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

                break;
        }




    }

}
