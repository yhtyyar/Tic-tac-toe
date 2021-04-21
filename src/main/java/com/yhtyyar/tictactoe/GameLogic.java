package main.java.com.yhtyyar.tictactoe;

import java.util.Random;
import java.util.Scanner;

import static main.java.com.yhtyyar.tictactoe.Field.FIELD;

//Бизнес-логика игры
public class GameLogic {

    static final int FIELD_SIZE = 3;
    static final char PLAYER = 'X';
    static final char COMPUTER = '0';
    static final char NULL = '_';

    static Scanner console = new Scanner(System.in);
    static Random random = new Random();

    // расчет координаты хода игрока
    static void player_s_Move() {
        int x, y;    //координаты
        do {
            x = console.nextInt() - 1;
            y = console.nextInt() - 1;
        } while (!isCellValid(x,y));
        FIELD[x][y] = PLAYER;
    }

    //расчет координаты хода компютера
    static void computer_s_Move() {
        int x, y;    //координаты
        do {
            x = random.nextInt(FIELD_SIZE);
            y = random.nextInt(FIELD_SIZE);
        } while (!isCellValid(x,y));
        FIELD[x][y] = COMPUTER;
    }

    static boolean isCellValid (int x, int y) {
        // проверяется координата введенного места (оно в пределах нашего массива или нет)
        if (x < 0 || x >= FIELD_SIZE || y < 0 || y >= FIELD_SIZE) {
            return false;
        }
        // проверяется, выбранная координата пустая или нет
        if (FIELD[x][y] == NULL) {
            return true;
        }
        return false;
    }

    // поиск свободного места
    static boolean freePlace() {
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
        static boolean winCheck ( char sum){
            int result = 0;
            int first = 0;
            int second = 0;

            //перебирается все строки и столбцы если она равна sum
            // то мы добавляем к переменной result единицу
            // это и есть количество крестиков которые нужно собрать в ряд
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    // тут проверяется победа со стороны по индексу строки  стоблцы
                    if (FIELD[i][j] == sum) {
                        result++;
                    }
                }
            }
            if (result == FIELD_SIZE) {
                return true;
            }

            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    // тут проверяется победа со стороны по индексу столбцы строки
                    if (FIELD[j][i] == sum) {
                        result++;
                    }
                }
            }
            if (result == FIELD_SIZE) {
                return true;
            }

            //выигришь по диагонали
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    if (j == i && FIELD[i][j] == sum) {
                        first++;
                    }
                }
            }
            if (first == FIELD_SIZE) {
                return true;
            }

            // выигрышь по обратной дигонали
            for (int i = 0, j = FIELD_SIZE - 1; i < FIELD_SIZE && j >= 0; i++, j--) {
                if (FIELD[i][j] == sum) {
                    second++;
                }
            }
            if (second == FIELD_SIZE) {
                return true;
            }

            return false;
        }

}

