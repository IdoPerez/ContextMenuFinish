package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @since 4/18/1345
 * @author Hertel
 * @version 8.0543245.87
 */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * retunning to the main activity.
     * @param view
     */
    public void BackToActivMain(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
