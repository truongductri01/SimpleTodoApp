package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText etEdit;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etEdit = findViewById(R.id.etEdit);
        saveBtn = findViewById(R.id.saveBtn);

        getSupportActionBar().setTitle("Edit Item");
        etEdit.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etEdit.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // finish, close the screen and go back to main screen
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}