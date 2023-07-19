package com.example.juegotriki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView imgTurno;
    TextView txtTurno;
    TextView txtDialogo;
    Button btnInicio;
    int Turno;
    boolean Ganar = false;

    public void ValidarGanador(ImageView img1, ImageView img2, ImageView img3, String Valor){
        if ((img1.getTag().equals(Valor)) && (img2.getTag().equals(Valor)) && (img3.getTag().equals(Valor))){
            Dialog dialogo = new Dialog (this);
            dialogo.setContentView(R.layout.vista_dialogo);
            txtDialogo = (TextView)dialogo.findViewById(R.id.txtDialogo);
            dialogo.show();

            if (img1.getTag().equals("x")){
                txtDialogo.setText("Jugador 1");
                dialogo.show();
            }else if (img1.getTag().equals("o")){
                txtDialogo.setText("Jugador 2");
                dialogo.show();
            }
            Ganar = true;
        }
    }

    public void Jugando(ImageView img){
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Ganar){
                    if (img.getTag().equals("null")){
                        if (txtTurno.getText().toString().equals("Jugador 1")){

                            img.setImageResource(R.mipmap.x);
                            txtTurno.setText("Jugador 2");
                            img.setTag("x");
                            ValidarGanador(img1, img2, img3, "x");
                            ValidarGanador(img4, img5, img6, "x");
                            ValidarGanador(img7, img8, img9, "x");
                            ValidarGanador(img1, img4, img7, "x");
                            ValidarGanador(img2, img5, img8, "x");
                            ValidarGanador(img3, img6, img9, "x");
                            ValidarGanador(img1, img5, img9, "x");
                            ValidarGanador(img3, img5, img7, "x");
                        }else if(txtTurno.getText().toString().equals("Jugador 2")){
                            img.setImageResource(R.mipmap.o);
                            txtTurno.setText("Jugador 1");
                            img.setTag("o");
                            ValidarGanador(img1, img2, img3, "o");
                            ValidarGanador(img4, img5, img6, "o");
                            ValidarGanador(img7, img8, img9, "o");
                            ValidarGanador(img1, img4, img7, "o");
                            ValidarGanador(img2, img5, img8, "o");
                            ValidarGanador(img3, img6, img9, "o");
                            ValidarGanador(img1, img5, img9, "o");
                            ValidarGanador(img3, img5, img7, "o");
                        }
                    }
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTurno = (TextView) findViewById(R.id.txtTurno);
        btnInicio = (Button) findViewById(R.id.btnInicio);

        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);
        img4=(ImageView) findViewById(R.id.img4);
        img5=(ImageView) findViewById(R.id.img5);
        img6=(ImageView) findViewById(R.id.img6);
        img7=(ImageView) findViewById(R.id.img7);
        img8=(ImageView) findViewById(R.id.img8);
        img9=(ImageView) findViewById(R.id.img9);
        imgTurno=(ImageView) findViewById(R.id.imgTurno);


        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnInicio.setText("Reiniciar");
                if(btnInicio.getText().toString().equals("Reiniciar")){
                    btnInicio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent Reiniciar = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(Reiniciar);
                        }
                    });
                }

                Turno = ((int)(Math.random() * 2)) + 1;
                if (Turno == 1){
                    imgTurno.setImageResource(R.mipmap.x);
                    txtTurno.setText("Jugador 1");
                }else{
                    imgTurno.setImageResource(R.mipmap.o);
                    txtTurno.setText("Jugador 2");
                }
            }
        }
        );

        Jugando(img1);
        Jugando(img2);
        Jugando(img3);
        Jugando(img4);
        Jugando(img5);
        Jugando(img6);
        Jugando(img7);
        Jugando(img8);
        Jugando(img9);
    }
}