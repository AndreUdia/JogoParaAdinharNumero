package com.example.andre.jogoparaadinharnumero;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andre.jogoparaadinharnumero.R;

public class Jogo extends Activity implements OnKeyListener{

    private Integer numeroSorteado;
    private TextView mensagem;
    private EditText entrada;
    private EditText numeroEntrada;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        preparacaoInicial();
    }

    private void preparacaoInicial() {
        numeroSorteado = (int) (Math.random() * 101);
        mensagem = (TextView) findViewById(R.id.mensagem);
        entrada = (EditText) findViewById(R.id.entrada);
        numeroEntrada = (EditText) findViewById(R.id.numeroTentativas);
        entrada.setOnKeyListener(this);
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP){
            vericar();
            return true;
        }
        return false;
    }

    private void vericar() {
        contador++;
        int numero = Integer.parseInt(entrada.getText().toString());
        //int i = contador++;
        if (numero == numeroSorteado){
            mensagem.setText(R.string.texto2);
            numeroEntrada.setText(Integer.toString(contador));
            //numeroEntrada.setText(Integer.toString(i));
            entrada.setText("");
        }
        else if (numero > numeroSorteado){
            mensagem.setText(Integer.toString(numero).concat(": é MAIOR que o n° sorteado!"));
            numeroEntrada.setText(Integer.toString(contador));
            //numeroEntrada.setText(Integer.toString(i));
            entrada.setText("");
        }
        else {
            mensagem.setText(Integer.toString(numero).concat(": é MENOR que o n° sorteado!"));
            //numeroEntrada.setText(Integer.toString(i));
            numeroEntrada.setText(Integer.toString(contador));
            entrada.setText("");
            //mensagem.setText(R.string.texto4);
        }
    }

    public void confirms(View m){
        vericar();
    }
}




























