package dev.mavincci.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView infoLabel;
    Button[] buttons;
    Button actionButton;
    Integer[] ids;

    TicTacToe game;

    boolean hasStarted = false;

    void gameStart() {
        game = new TicTacToe();
        hasStarted = true;
        updateState();

        actionButton.setBackgroundColor(Color.parseColor("#FF0000"));
        actionButton.setText("Stop");
    }

    void gameEnd() {
        hasStarted = false;
        game.reset();
        updateState();

        infoLabel.setText("Click \"Start\"");
        actionButton.setBackgroundColor(Color.parseColor("#24AC37"));
        actionButton.setText("Start");

        for (int i = 0; i < ids.length; ++i)
            buttons[i].setEnabled(false);
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

        infoLabel = findViewById(R.id.info_label);
        infoLabel.setText("Click \"Start\"");

        actionButton = findViewById(R.id.action_button);
        actionButton.setOnClickListener(new ActionButtonHandler());

        buttons = new Button[9];

        for (int i = 0; i < ids.length; ++i) {
            buttons[i] = findViewById(ids[i]);
            buttons[i].setEnabled(false);
            buttons[i].setOnClickListener(new BoardButtonHandler());
        }

        game = new TicTacToe();
    }

    void updateState() {
        char[] state = game.getState();

        for (int i = 0; i < buttons.length; ++i) {
            boolean isX = state[i] == TicTacToe.turns[0];
            boolean isO = state[i] == TicTacToe.turns[1];

            if (isO || isX) {
                buttons[i].setEnabled(false);
                buttons[i].setText(isO ? R.string.TIC_O : R.string.TIC_X);
            } else {
                buttons[i].setEnabled(true);
                buttons[i].setText("");
            }
        }

        infoLabel.setText("" + game.getTurn() + "'s Turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

//        updateState();
    }

    class BoardButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < buttons.length; ++i) {
                if (v.getId() == ids[i]) {
                    Log.d("BoardButtonHandler", "onClick: " + (i + 1));
                    game.input(i + 1);
                    game.toggleTurn();
                    updateState();
                    return;
                }
            }
        }
    }

    class ActionButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (hasStarted)
                gameEnd();
            else
                gameStart();
        }
    }
}