package com.anthony.palletecolors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener{

    private SeekBar sbr_red = null;
    private SeekBar sbr_green = null;
    private SeekBar sbr_blue = null;
    private SeekBar sbr_alpha = null;
    private View vie_colors = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbr_red = findViewById(R.id.sbrRed);
        sbr_green = findViewById(R.id.sbrGreen);
        sbr_blue = findViewById(R.id.sbrBlue);
        sbr_alpha = findViewById(R.id.sbrAlpha);
        vie_colors = findViewById(R.id.vieColors);

        sbr_red.setOnSeekBarChangeListener(this);
        sbr_green.setOnSeekBarChangeListener(this);
        sbr_blue.setOnSeekBarChangeListener(this);
        sbr_alpha.setOnSeekBarChangeListener(this);
    }

    //Show options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Actions Option menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            
            case R.id.itemAboutOf :
                //Toast.makeText(this, "you've pressed About Of option", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutOfActivity.class);
                startActivity(intent);
                break;

            case R.id.iteHelp :
                //Toast.makeText(this, "you've pressed Help option", Toast.LENGTH_SHORT).show();
                Intent helpAct = new Intent(this, HelpActivity.class);
                startActivity(helpAct);
                break;

            case R.id.iteExit :
                Toast.makeText(this, "you've pressed Exit option", Toast.LENGTH_SHORT).show();
                break;


            case R.id.iteReset :
                break;

            case R.id.idTransparent :
                sbr_alpha.setProgress(0);
                break;

            case R.id.idSemiTransparent :
                sbr_alpha.setProgress(128);
                break;

            case R.id.idOpaque :
                sbr_alpha.setProgress(255);
                break;

            case R.id.idBlack :
                break;

            case R.id.idWhite :
                break;

            case R.id.idRed :
                sbr_red.setProgress(255);
                sbr_green.setProgress();
                sbr_blue.setProgress(0);
                break;

            case R.id.idGreen :
                sbr_red.setProgress(0);
                sbr_green.setProgress(255);
                sbr_blue.setProgress(0);
                break;

            case R.id.idBlue :
                sbr_red.setProgress(0);
                sbr_green.setProgress(0);
                sbr_blue.setProgress(255);
                break;

            case R.id.idCyan :
                break;

            case R.id.idMagenta :
                sbr_red.setProgress(255);
                sbr_green.setProgress(0);
                sbr_blue.setProgress(255);
                break;

            case R.id.idYellow :
                sbr_red.setProgress(255);
                sbr_green.setProgress(255);
                sbr_blue.setProgress(0);
                break;
        }
        
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {

        int r = sbr_red.getProgress();
        int g = sbr_green.getProgress();
        int b = sbr_blue.getProgress();
        int a = sbr_alpha.getProgress();

        int color = Color.argb(a,r,g,b);
        vie_colors.setBackgroundColor(color);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}