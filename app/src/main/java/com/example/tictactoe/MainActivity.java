package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final List<int[]>combinationsList = new ArrayList<>();
    private int playerTurn = 1;
    private int totalBoxSelected = 1;
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{0,4,8});
        combinationsList.add(new int[]{2,4,6});

        try
        {
            String Player1 = getIntent().getStringExtra("Player1").toString();
            String Player2 = getIntent().getStringExtra("Player2").toString();
            binding.playerOneName.setText(Player1);
            binding.playerTwoName.setText(Player2);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }

        binding.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(0)){
                    performAction((ImageView) view,0);
                }
            }
        });
        binding.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(1)){
                    performAction((ImageView) view,1);
                }
            }
        });
        binding.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(2)){
                    performAction((ImageView) view,2);
                }
            }
        });
        binding.img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(3)){
                    performAction((ImageView) view,3);
                }
            }
        });
        binding.img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(4)){
                    performAction((ImageView) view,4);
                }
            }
        });
        binding.img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(5)){
                    performAction((ImageView) view,5);
                }
            }
        });
        binding.img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(6)){
                    performAction((ImageView) view,6);
                }
            }
        });
        binding.img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(7)){
                    performAction((ImageView) view,7);
                }
            }
        });
        binding.img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boxSelection(8)){
                    performAction((ImageView) view,8);
                }
            }
        });
    }
    private void performAction(ImageView imageView,int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;
        if(playerTurn == 1){
            imageView.setImageResource(R.drawable.cross1);
            if(result()){
                WinDialog winDialog = new WinDialog(MainActivity.this,binding.playerOneName.getText().toString()+" Wins! ",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(totalBoxSelected==9){
                WinDialog winDialog = new WinDialog(MainActivity.this,"DRAW!",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else{
                changeTurn(2);
                totalBoxSelected++;
            }
        }
        else{
            imageView.setImageResource(R.drawable.circle1);
            if(result()){
                WinDialog winDialog = new WinDialog(MainActivity.this, binding.playerTwoName.getText().toString()+" Wins! ",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(totalBoxSelected==9){
                WinDialog winDialog = new WinDialog(MainActivity.this,"DRAW!",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else{
                changeTurn(1);
                totalBoxSelected++;
            }
        }
    }
    private void changeTurn(int currTurn){
        playerTurn = currTurn;
        if(playerTurn == 1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.green_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.border);
        }
        else{
            binding.playerTwoLayout.setBackgroundResource(R.drawable.green_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.border);
        }
    }
    private boolean result(){
        boolean response = false;
        for(int i=0;i<combinationsList.size();i++){
            final int[] combination = combinationsList.get(i);
            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn){
                response = true;
            }
        }
        return response;
    }
    private boolean boxSelection(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition]==0){
            response = true;
        }
        return response;
    }
    public void restart(){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalBoxSelected = 1;
        binding.img1.setImageResource(R.drawable.container);
        binding.img2.setImageResource(R.drawable.container);
        binding.img3.setImageResource(R.drawable.container);
        binding.img4.setImageResource(R.drawable.container);
        binding.img5.setImageResource(R.drawable.container);
        binding.img6.setImageResource(R.drawable.container);
        binding.img7.setImageResource(R.drawable.container);
        binding.img8.setImageResource(R.drawable.container);
        binding.img9.setImageResource(R.drawable.container);
    }
}