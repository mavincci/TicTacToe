package dev.mavincci.tictactoe;

public class TicTacToe {

    public static final char[] turns = new char[]{'X', 'O', '\0'};

    private final char[] state = new char[9];
    private int turn = 0;

    TicTacToe() {
        reset();
    }

    void reset() {
        turn = 0;
        for (Character c : state)
            c = turns[2];
    }

    public void input(int i) {
        state[i-1] = turns[turn];
    }

    public void toggleTurn() {
        turn ^= 1;
    }

    public char[] getState() {
        return state;
    }

    public char getTurn() {
        return turns[turn];
    }

    void print() {
        System.out.print('[');
        for (char x : state) {
            System.out.print(x + ", ");
        }
        System.out.println(']');
    }
}
