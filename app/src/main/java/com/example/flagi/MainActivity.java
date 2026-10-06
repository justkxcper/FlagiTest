package com.example.flagi;

import static android.view.View.INVISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int licznikKlikniec = 0;
    private TextView textViewPytanie;

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
        textViewPytanie = findViewById(R.id.textViewPytanie);
    }

    public void sprawdzOK(View view) {
        Toast.makeText(MainActivity.this,
                "Ten kolor należy do flagi Polski, nie klikaj go",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void sprawdzNieOK(View view) {
        view.setVisibility(INVISIBLE);
        licznikKlikniec++;
        if (licznikKlikniec == 4) {
            // komunikat i zmiana wyglądu
            textViewPytanie.setText("Brawo, \nTo jest flaga Polski!");
        }
    }
}