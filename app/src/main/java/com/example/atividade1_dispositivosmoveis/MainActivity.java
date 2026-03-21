package com.example.atividade1_dispositivosmoveis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText inputAlcool = findViewById(R.id.inputPrecoAlcool);
        EditText inputGasolina = findViewById(R.id.inputPrecoGasolina);
        TextView lblResultado = findViewById(R.id.lblResultado);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoAlcool = inputAlcool.getText().toString();
                String textoGasolina = inputGasolina.getText().toString();

                if (textoAlcool.isEmpty() || textoGasolina.isEmpty()) {
                    lblResultado.setText("Preencha os dois campos");
                    return;
                }

                double precoAlcool = Double.parseDouble(textoAlcool);
                double precoGasolina = Double.parseDouble(textoGasolina);

                double razao = precoAlcool / precoGasolina;

                if (razao <= 0.7) {
                    lblResultado.setText("Abasteça com Álcool");
                } else {
                    lblResultado.setText("Abasteça com Gasolina");
                }
            }
        });
    }
}