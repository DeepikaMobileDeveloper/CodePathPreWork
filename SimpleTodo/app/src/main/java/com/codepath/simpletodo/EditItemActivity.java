package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActivity extends AppCompatActivity {

    String text = null;
    int pos = -1;
    EditText etTodoItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        pos = getIntent().getIntExtra(MainActivity.POS, -1);
        text = getIntent().getStringExtra(MainActivity.TEXT);
        etTodoItem = findViewById(R.id.eTToDoItem);
        etTodoItem.setText(text);
        etTodoItem.setSelection(text.length());
    }

    public void onSaveClick(View view) {
        String editText = etTodoItem.getText().toString();
        if (text.equals(editText.trim())) {
            Toast.makeText(this, "Nothing Changed", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED);
        } else {
            Intent data = new Intent();
            data.putExtra(MainActivity.POS, pos);
            data.putExtra(MainActivity.TEXT, editText);
            setResult(RESULT_OK, data);
        }
        finish();
    }
}