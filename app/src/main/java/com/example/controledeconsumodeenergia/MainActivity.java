package com.example.controledeconsumodeenergia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etap, etpot, etkwh, etsuo;
    Spinner spmedia;
    Button btCal, btlimp;
    public static String ap,pot,uso,med,vkwh,tot,tkw;
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

        etap = findViewById(R.id.etAparelhoMain);
        etpot = findViewById(R.id.etPotMain);
        etkwh = findViewById(R.id.etKwhMain);
        etsuo = findViewById(R.id.etTempMain);
        spmedia = findViewById(R.id.spTempMain);
        btCal = findViewById(R.id.btCalcularMain);
        btlimp = findViewById(R.id.btLimparMain);
        preencherSpinner();

        btlimp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etap.setText("");
                etpot.setText("");
                etkwh.setText("");
                etsuo.setText("");
                spmedia.setSelection(0);
            }
        });

       btCal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ap = etap.getText().toString();
               pot = etpot.getText().toString();
               vkwh = etkwh.getText().toString();
               uso = etsuo.getText().toString();
               med = spmedia.getSelectedItem().toString();
               double p,temp,total,tkwh,valkwh;
               p = Double.parseDouble(pot);
               temp = Double.parseDouble(uso);
               valkwh = Double.parseDouble(vkwh);
               if(med.equals("minutos")){
                   temp/=60;
               }
               tkwh = (p*temp*30)/1000;
               tkw = String.valueOf(tkwh);
               total = tkwh*valkwh;
               tot = String.valueOf(total);

               Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
               startActivity(intent);
           }
       });
    }//onCreat
    public void preencherSpinner(){
        List<String>lista = new ArrayList<>();
        lista.add("Escolha o tempo");
        lista.add("Horas");
        lista.add("Minuto");
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        spmedia.setAdapter(adaptador);
    }

}//class