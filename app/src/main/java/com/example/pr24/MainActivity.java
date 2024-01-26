package com.example.pr24;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    RadioGroup radioGroup;
    EditText editText;
    Button button;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textToSpeech = new TextToSpeech(this, this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                setLanguage(radioButton.getText().toString());
                textToSpeech.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }
    private void setLanguage(String language) {
        switch (language) {
            case "English":
                textToSpeech.setLanguage(Locale.US);
                break;
            case "Spanish":
                textToSpeech.setLanguage(new Locale("es", "ES"));
                break;
            case "French":
                textToSpeech.setLanguage(Locale.FRENCH);
                break;
            case "German":
                textToSpeech.setLanguage(Locale.GERMANY);
                break;
            case "Italian":
                textToSpeech.setLanguage(Locale.ITALY);
                break;
            case "Japanese":
                textToSpeech.setLanguage(Locale.JAPAN);
                break;
            case "Chinese":
                textToSpeech.setLanguage(Locale.CHINA);
                break;
        }
    }
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.US);
        }
    }

    @Override
    protected void onDestroy() {
        textToSpeech.stop();
        textToSpeech.shutdown();
        super.onDestroy();
    }
}
