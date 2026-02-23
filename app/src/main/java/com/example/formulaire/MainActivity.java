package com.example.formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText editNom, editEmail, editPhone, editAdresse, editVille;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements (connect Java to XML)
        editNom = findViewById(R.id.edit_nom);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        editAdresse = findViewById(R.id.edit_adresse);
        editVille = findViewById(R.id.edit_ville);
        btnSubmit = findViewById(R.id.btn_submit);

        // Set click listener on submit button
        btnSubmit.setOnClickListener(v -> {
            // Check if form is valid before proceeding
            if (validateForm()) {
                // Get text from all fields
                String nom = editNom.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();
                String adresse = editAdresse.getText().toString().trim();
                String ville = editVille.getText().toString().trim();

                // Create Intent to go to second screen
                Intent intent = new Intent(MainActivity.this, Screen2Activity.class);

                // Add data to Intent (key-value pairs)
                intent.putExtra("nom", nom);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                intent.putExtra("adresse", adresse);
                intent.putExtra("ville", ville);

                // Start the second activity
                startActivity(intent);
            }
        });
    }

    // Form validation method
    private boolean validateForm() {
        boolean isValid = true;

        // Get text from fields
        String nom = editNom.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();

        // Validate Name (required)
        if (TextUtils.isEmpty(nom)) {
            editNom.setError("Le nom est requis");
            isValid = false;
        }

        // Validate Email (required and valid format)
        if (TextUtils.isEmpty(email)) {
            editEmail.setError("L'email est requis");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Email invalide");
            isValid = false;
        }

        // Validate Phone (optional but if entered, must be valid)
        if (!TextUtils.isEmpty(phone) && phone.length() < 10) {
            editPhone.setError("Numéro de téléphone invalide");
            isValid = false;
        }

        // Show toast if form is invalid
        if (!isValid) {
            Toast.makeText(this, "Veuillez corriger les erreurs", Toast.LENGTH_SHORT).show();
        }

        return isValid;
    }

    // Clear form when returning to this screen
    @Override
    protected void onResume() {
        super.onResume();
        // Clear all fields
        editNom.setText("");
        editEmail.setText("");
        editPhone.setText("");
        editAdresse.setText("");
        editVille.setText("");
    }

    // ========== BONUS: Save data on screen rotation ==========
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save all field values before rotation
        outState.putString("saved_nom", editNom.getText().toString());
        outState.putString("saved_email", editEmail.getText().toString());
        outState.putString("saved_phone", editPhone.getText().toString());
        outState.putString("saved_adresse", editAdresse.getText().toString());
        outState.putString("saved_ville", editVille.getText().toString());

        // Optional: Save which field has focus
        if (getCurrentFocus() != null) {
            int focusedId = getCurrentFocus().getId();
            outState.putInt("focused_field", focusedId);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore all field values after rotation
        if (savedInstanceState != null) {
            editNom.setText(savedInstanceState.getString("saved_nom"));
            editEmail.setText(savedInstanceState.getString("saved_email"));
            editPhone.setText(savedInstanceState.getString("saved_phone"));
            editAdresse.setText(savedInstanceState.getString("saved_adresse"));
            editVille.setText(savedInstanceState.getString("saved_ville"));

            // Optional: Restore focus to the field that had it
            int focusedId = savedInstanceState.getInt("focused_field", -1);
            if (focusedId != -1) {
                findViewById(focusedId).requestFocus();
            }
        }
    }

}