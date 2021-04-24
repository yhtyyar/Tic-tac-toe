package main.java.com.yhtyyar.tictactoe;

import java.util.Random;
import java.util.Scanner;

import static main.java.com.yhtyyar.tictactoe.Field.*;

//Бизнес-логика игры
public class GameLogic {

    static  int FIELD_SIZE ;
    static final char NULL = '_';
    private static final char PLAYER = 'X';
    private static final char COMPUTER = '0';


    private final Scanner console = new Scanner(System.in);
    private final Random random = new Random();

    private void fieldSize() {

        System.out.println("Выберите размер поля для игры Х*Х");

        FIELD_SIZE = console.nextInt();
    }


    // расчет координаты хода игрока
    private String getUserInput() {
        int x, y;    //координаты
        do {
            System.out.println("Введите координаты по оси х и у");
            x = console.nextInt() -1;
            y = console.nextInt() -1;
        } while (!isCellValid(x,y));
        FIELD[y][x] = PLAYER;
        return "Игрок сделал свой ход";
    }

    //расчет координаты хода компютера
    private String generatePCStep() {
        int x, y;    //координаты
        do {
            System.out.println("Ход компютера");
            x = random.nextInt(FIELD_SIZE);
            y = random.nextInt(FIELD_SIZE);
        } while (!isCellValid(x,y));
        FIELD[y][x] = COMPUTER;
        return "Компютер сделал свой ход";
    }

    static void setSum(int x,int y, char sum) {
        FIELD [y][x] = sum;
    }


    private boolean isCellValid (int x, int y) {
        // проверяется координата введенного места (оно в пределах нашего массива или нет)
        if (x < 0 || x >= FIELD_SIZE || y < 0 || y >= FIELD_SIZE) {
            return false;
        }
        // проверяется, выбранная координата пустая или нет
        if (FIELD[y][x] != NULL) {
            return false;
        }
        return true;
    }

    // поиск свободного места
    private boolean freePlace() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (FIELD[i][j] == NULL) {
                    return false;
                }
            }
        }
        return true;
    }



        // проверка на победу
    private boolean checkWinner (char sum){

            //перебирается все строки и столбцы если она равна sum
            // то мы добавляем к переменной result единицу
            // это и есть количество крестиков которые нужно собрать в ряд
            for (int i = 0; i < FIELD_SIZE; i++) {
                int result1 = 0;
                for (int j = 0; j < FIELD_SIZE; j++) {
                    // тут проверяется победа со стороны по индексу строки  стоблцы
                    if (FIELD[i][j] == sum) {
                        result1++;
                    }
                }
                if (result1 == FIELD_SIZE) {
                    return true;
                }
            }


            for (int i = 0; i < FIELD_SIZE; i++) {
                int result2 = 0;
                for (int j = 0; j < FIELD_SIZE; j++) {
                    // тут проверяется победа со стороны по индексу столбцы строки
                    if (FIELD[j][i] == sum) {
                        result2++;
                    }
                }
                if (result2 == FIELD_SIZE) {
                    return true;
                }
            }


            int diagonal1 = 0;
            //выигришь по диагонали (сверху вниз)
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    if (j == i && FIELD[i][j] == sum) {
                        diagonal1++;
                    }
                }
                if (diagonal1 == FIELD_SIZE) {
                    return true;
                }
            }


            int diagonal2 = 0;
            // выигрышь по  дигонали (снизу вверх)
            for (int i = 0, j = FIELD_SIZE - 1; i < FIELD_SIZE && j >= 0; i++, j--) {
                if (FIELD[i][j] == sum) {
                    diagonal2++;
                }
                if (diagonal2 == FIELD_SIZE) {
                    return true;
                }
            }

            return false;
    }





    void startGame() {
        System.out.println("       Игра запущена...   ");

        System.out.println("\n");

        fieldSize();

        initField();
        printField();

        while (true) {
            System.out.println();
            getUserInput();
            printField();
            if (checkWinner(PLAYER)) {
                System.out.println("  Ураа вы победили!");
                break;
            }

            if (freePlace()) {
                System.out.println(" У-вы дружная ничья");
                break;
            }

            System.out.println();
            generatePCStep();
            System.out.println();
            printField();

            if (checkWinner(COMPUTER)) {
                System.out.println("  К сожалению вы проиграли");
                break;
            }

            if (freePlace()) {
                System.out.println(" У-вы дружная ничья");
                break;
            }

        }
        System.exit(0);
    }


}

