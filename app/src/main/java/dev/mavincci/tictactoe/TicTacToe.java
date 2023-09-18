package dev.mavincci.tictactoe;

public class TicTacToe {
    int[] state = new int[9];

    void init() {
        for (Integer x : state) {
            x = 0;
        }
    }

    void print() {
        System.out.print('[');
        for (int x : state) {
            System.out.print(x + ", ");
        }
        System.out.println(']');
    }
}
