package dev.mavincci.tictactoe;

public class TicTacToe {

    public static final char[] turns = new char[]{'O', 'X', '\0'};

    private final char[] state = new char[9];
    private int turn = 0;

    TicTacToe() {
        reset();
        state[0] = 'O';
        state[3] = 'O';
        state[4] = 'O';
    }

    void reset() {
        turn = 0;
        for (Character c : state)
            c = turns[2];
    }

    public char[] getState() {
        return state;
    }

    void print() {
        System.out.print('[');
        for (char x : state) {
            System.out.print(x + ", ");
        }
        System.out.println(']');
    }
}
