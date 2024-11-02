package com.example.controledeconsumodeenergia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {
    TextView tvap,tvpot,tvuso,tvtotal;
    Button btvoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvap = findViewById(R.id.tvAparelhoResult);
        tvpot = findViewById(R.id.tvPotenciaResult);
        tvuso = findViewById(R.id.tvTempUsoResult);
        tvtotal = findViewById(R.id.tvTotalResul);
        btvoltar = findViewById(R.id.btVoltarResult);

        tvap.setText("Aparelho:"+MainActivity.ap);
        tvpot.setText("Potência(w):"+MainActivity.pot);
        tvuso.setText("Uso:"+MainActivity.uso);
        tvtotal.setText("R$"+MainActivity.tot);
    }
    public void voltar(View v){
        finish();
    }
}