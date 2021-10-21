package com.example.gatov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Ambito de variables
    private TextView tx;
    private TextView tx2;
    private Button bA1;
    private Button bA2;
    private Button bA3;
    private Button bB1;
    private Button bB2;
    private Button bB3;
    private Button bC1;
    private Button bC2;
    private Button bC3;
    private Button bRei;

    private String Turno = "X";
    private int tA2 = 0;
    private int tA1 = 0;
    private int tA3 = 0;
    private int tB1 = 0;
    private int tB2 = 0;
    private int tB3 = 0;
    private int tC1 = 0;
    private int tC2 = 0;
    private int tC3 = 0;
    private int Punto = 0;
    private boolean terminado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ALTA BOTONES*/
        bA1 = findViewById(R.id.A1);
        bA2 = findViewById(R.id.A2);
        bA3 = findViewById(R.id.A3);
        bB1 = findViewById(R.id.B1);
        bB2 = findViewById(R.id.B2);
        bB3 = findViewById(R.id.B3);
        bC1 = findViewById(R.id.C1);
        bC2 = findViewById(R.id.C2);
        bC3 = findViewById(R.id.C3);
        bRei = findViewById(R.id.reiniciar);
        tx = findViewById(R.id.textView);
        tx2 = findViewById(R.id.ganador);

        bA1.setOnClickListener(this);
        bA2.setOnClickListener(this);
        bA3.setOnClickListener(this);
        bB1.setOnClickListener(this);
        bB2.setOnClickListener(this);
        bB3.setOnClickListener(this);
        bC1.setOnClickListener(this);
        bC2.setOnClickListener(this);
        bC3.setOnClickListener(this);

        bRei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bA2.setVisibility(View.INVISIBLE); //HACER INVISIBLE
                bA1.setText(""); bA2.setText(""); bA3.setText("");
                bB1.setText(""); bB2.setText(""); bB3.setText("");
                bC1.setText(""); bC2.setText(""); bC3.setText("");
                tA1 = 0; tA2 = 0; tA3 = 0;
                tB1 = 0; tB2 = 0; tB3 = 0;
                tC1 = 0; tC2 = 0; tC3 = 0;
                Turno = "X";
                Punto = 0;
                terminado = false;
                tx2.setText("Carlos López");
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!terminado) {
            CambiarTurno();
            if (view.getId() != R.id.reiniciar) {
                switch (view.getId()) {

                    case R.id.A1:
                        if (tA1 == 0) {
                            bA1.setText(Turno);
                            tA1 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.A2:
                        if (tA2 == 0) {
                            bA2.setText(Turno);
                            tA2 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.A3:
                        if (tA3 == 0) {
                            bA3.setText(Turno);
                            tA3 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.B1:
                        if (tB1 == 0) {
                            bB1.setText(Turno);
                            tB1 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.B2:
                        if (tB2 == 0) {
                            bB2.setText(Turno);
                            tB2 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.B3:
                        if (tB3 == 0) {
                            bB3.setText(Turno);
                            tB3 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.C1:
                        if (tC1 == 0) {
                            bC1.setText(Turno);
                            tC1 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.C2:
                        if (tC2 == 0) {
                            bC2.setText(Turno);
                            tC2 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    case R.id.C3:
                        if (tC3 == 0) {
                            bC3.setText(Turno);
                            tC3 = Punto;
                        } else {
                            CambiarTurno();
                        }
                        break;
                    default:
                        break;
                }
                ComprobarVictoria();
                VerificarEmpate();
            }
        }
    }

    public void CambiarTurno() {
        if (Turno == "X"){
            Turno = "O";
            Punto = 1;
        } else {
            Turno = "X";
            Punto = 2;
        }
    }
    public void ComprobarVictoria() {
        if (tA1 == 1 && tA2 == 1 && tA3 == 1) { Ganador("O"); }
        if (tB1 == 1 && tB2 == 1 && tB3 == 1) { Ganador("O"); }
        if (tC1 == 1 && tC2 == 1 && tC3 == 1) { Ganador("O"); }
        if (tA1 == 1 && tB1 == 1 && tC1 == 1) { Ganador("O"); }
        if (tA2 == 1 && tB2 == 1 && tC2 == 1) { Ganador("O"); }
        if (tA3 == 1 && tB3 == 1 && tC3 == 1) { Ganador("O"); }
        if (tA1 == 1 && tB2 == 1 && tC3 == 1) { Ganador("O"); }
        if (tA3 == 1 && tB2 == 1 && tC1 == 1) { Ganador("O"); }

        if (tA1 == 2 && tA2 == 2 && tA3 == 2) { Ganador("X"); }
        if (tB1 == 2 && tB2 == 2 && tB3 == 2) { Ganador("X"); }
        if (tC1 == 2 && tC2 == 2 && tC3 == 2) { Ganador("X"); }
        if (tA1 == 2 && tB1 == 2 && tC1 == 2) { Ganador("X"); }
        if (tA2 == 2 && tB2 == 2 && tC2 == 2) { Ganador("X"); }
        if (tA3 == 2 && tB3 == 2 && tC3 == 2) { Ganador("X"); }
        if (tA1 == 2 && tB2 == 2 && tC3 == 2) { Ganador("X"); }
        if (tA3 == 2 && tB2 == 2 && tC1 == 2) { Ganador("X"); }
    }
    public void Ganador(String aux) {
        tx2.setText("GANADOR: " + aux);
        terminado = true;
    }

    public void VerificarEmpate() {
        if (!terminado){
            if (tA1 != 0 && tA2 != 0 && tA3 != 0
                    && tB1 != 0 && tB2 != 0 && tB3 != 0
                    && tC1 != 0 && tC2 != 0 && tC3 != 0) {
                tx2.setText("EMPATE");
            }
        }
    }

}