package dev.mavincci.tictactoe;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button[] buttons;
    Button actionButton;
    Integer[] ids;

    TicTacToe game;

    void init() {
        game = new TicTacToe();
    }

    void initialize() {

        ids = new Integer[]{
                R.id.btn1,
                R.id.btn2,
                R.id.btn3,
                R.id.btn4,
                R.id.btn5,
                R.id.btn6,
                R.id.btn7,
                R.id.btn8,
                R.id.btn9
        };

        actionButton = findViewById(R.id.action_button);

        buttons = new Button[9];

        for (int i = 0; i < ids.length; ++i) {
            buttons[i] = findViewById(ids[i]);
        }

        game = new TicTacToe();
    }

    void updateState() {
        char[] state = game.getState();

        for (int i = 0; i < buttons.length; ++i) {
            boolean isO = state[i] == TicTacToe.turns[0];
            boolean isX = state[i] == TicTacToe.turns[1];

            if (isO || isX) {
                buttons[i].setEnabled(false);
                buttons[i].setText(isO ? R.string.TIC_O : R.string.TIC_X);
            } else {
                buttons[i].setEnabled(true);
                buttons[i].setText("");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        updateState();
    }
}