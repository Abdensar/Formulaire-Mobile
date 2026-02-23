package com.example.formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView tvRecap;
    private Button btnBack, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // Initialize views
        tvRecap = findViewById(R.id.tv_recap);
        btnBack = findViewById(R.id.btn_back);
        btnShare = findViewById(R.id.btn_share);

        // Get data from MainActivity
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String adresse = intent.getStringExtra("adresse");
        String ville = intent.getStringExtra("ville");

        // Format and display data
        String displayText = " NOM COMPLET:\n" + getSafeString(nom) + "\n\n" +
                " EMAIL:\n" + getSafeString(email) + "\n\n" +
                " TÉLÉPHONE:\n" + getSafeString(phone) + "\n\n" +
                " ADRESSE:\n" + getSafeString(adresse) + "\n\n" +
                " VILLE:\n" + getSafeString(ville);

        tvRecap.setText(displayText);

        // Back button
        btnBack.setOnClickListener(v -> {
            finish(); // Close this activity and go back
        });

        // Share button
        btnShare.setOnClickListener(v -> {
            String shareText = "Mes informations:\n" +
                    "Nom: " + getSafeString(nom) + "\n" +
                    "Email: " + getSafeString(email) + "\n" +
                    "Téléphone: " + getSafeString(phone) + "\n" +
                    "Adresse: " + getSafeString(adresse) + "\n" +
                    "Ville: " + getSafeString(ville);

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(shareIntent, "Partager via"));
        });
    }

    // Helper method to avoid null values
    private String getSafeString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "Non renseigné";
        }
        return value;
    }
}