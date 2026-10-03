package com.example.practica2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private EditText entradaEditText;
    private TextView resultadoTextView;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   // <-- Falta esta línea

        entradaEditText = findViewById(R.id.editTextNumberDecimal);
        resultadoTextView = findViewById(R.id.textView2);
        calcularButton = findViewById(R.id.button16);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });
    }

    //Calcular resultado

    private void calcularResultado() {
        String expresion = entradaEditText.getText().toString();
        // Obtener la expresion ingresada

        try {
            // Evaluar la expresion matematica
            double resultado = evaluarExpresion(expresion);
            resultadoTextView.setText("Resultado: " + resultado);
            // Mostrar el resultado
        } catch (Exception e) {
            resultadoTextView.setText("Error: Expresión Invalida");
            // Manejar errores
        }
    }

    // Metodo para evaluar la expresion matematica usando exp4j
    private double evaluarExpresion(String expresion) {
        // crear una expresion con exp4j
        Expression expression = new ExpressionBuilder(expresion).build();
        return expression.evaluate(); // evaluar y devolver el resultado
    }
}