package com.shelldk.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView percentView, gorgeta, total;
    EditText valor;
    SeekBar percentSeek;
    int progresso;
    float valorCalculo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declarando variaveis
        percentView = findViewById(R.id.textViewPercent);
        gorgeta = findViewById(R.id.textViewGorgeta);
        total = findViewById(R.id.textViewTotal);
        valor = findViewById(R.id.editTextValor);
        percentSeek = findViewById(R.id.seekBarPercent);
        percentView.setText("0%");
        mudarPorcentagem();
    }

    private void mudarPorcentagem()
    {
        percentSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = percentSeek.getProgress();
                percentView.setText(String.valueOf(progresso)+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                if(valor.getText().toString().trim().length() < 1)
                {
                    Toast.makeText(getApplicationContext(),
                            "Digite um valor primeiro",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    valorCalculo = Float.valueOf(valor.getText().toString());
                    gorgeta.setText(String.format("R$%.2f", valorCalculo/100*progresso));
                    total.setText(String.format("R$%.2f", valorCalculo+(valorCalculo/100*progresso)));
                }
            }
        });
    }
}