package com.example.shota.activityandintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mfirstEditText;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final int TEXT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfirstEditText = findViewById(R.id.first_et);
    }

    public void lunchsecondactivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        String message = mfirstEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        // starts a second activity
        startActivityForResult(intent, TEXT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST_CODE) {
            if (requestCode == RESULT_OK) {
                String reply = data.getStringExtra(Main2Activity.EXTRA_REPLY);
                mfirstEditText.setText(reply);
                Toast.makeText(this, reply, Toast.LENGTH_LONG).show();
            }
        }
    }
}
