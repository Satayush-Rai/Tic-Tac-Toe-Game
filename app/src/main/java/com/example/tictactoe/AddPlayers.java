package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText Player1Input = findViewById(R.id.text1);
        EditText Player2Input = findViewById(R.id.text2);

        Button btnStart = findViewById(R.id.btn1);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String Player1 = Player1Input.getText().toString();
                    String Player2 = Player2Input.getText().toString();
                    if(Player1.isEmpty()||Player2.isEmpty()){
                        Toast.makeText(AddPlayers.this,"Add Player Names First",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent intent = new Intent(AddPlayers.this,MainActivity.class);
                        intent.putExtra("Player1",Player1);
                        intent.putExtra("Player2",Player2);
                        startActivity(intent);
                    }
                }catch(NullPointerException e){
                    e.printStackTrace();
                }
            }
        });
    }
}