package com.example.calculadoracombustivel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    private Spinner spinnerCombustivel;
    private EditText editInputText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        editInputText = findViewById(R.id.inputFuelPrice);
        spinnerCombustivel = findViewById(R.id.spinnerCombustivel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_combustivel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCombustivel.setAdapter(adapter);

        spinnerCombustivel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String Text = adapterView.getSelectedItem().toString();

                if(Text.equals("Etanol")){
                    Toast.makeText(MainActivity.this, "Etanol selecionado!", Toast.LENGTH_SHORT).show();
                    editInputText.requestFocus();
                } else if(Text.equals("Gasolina")){
                    Toast.makeText(MainActivity.this, "Gasolina selecionada!", Toast.LENGTH_SHORT).show();
                    editInputText.requestFocus();
                } else if(Text.equals("Selecione o tipo de combustível...")){
                    Toast.makeText(MainActivity.this, "Selecione uma opção!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
