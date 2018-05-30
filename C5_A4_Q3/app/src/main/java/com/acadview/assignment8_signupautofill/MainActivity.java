package com.acadview.assignment8_signupautofill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,mail,phone,city;
    Button submit;
    Spinner state;
    String state_string;
    Integer state_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        city = findViewById(R.id.city);
        state = findViewById(R.id.statespinner);
        submit = findViewById(R.id.submit);

        final String states[] = {"Bihar", "Chhattisgarh", "Jharkhand", "Madhya Pradesh", "Odisha", "Rajasthan", "Uttar Pradesh"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, states);
        state.setAdapter(arrayAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                state_string = states[i];
                state_position=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "You haven't selected anything ! ", Toast.LENGTH_LONG).show();
            }
        });



            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("mail", mail.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    intent.putExtra("state", state_string);
                    intent.putExtra("state_position", (state_position).toString());
                    intent.putExtra("city", city.getText().toString());
                    startActivity(intent);
                }
            });

            name.setText(getIntent().getStringExtra("name2"));
            mail.setText(getIntent().getStringExtra("mail2"));
            phone.setText(getIntent().getStringExtra("phone2"));
            city.setText(getIntent().getStringExtra("city2"));
            state_position=getIntent().getIntExtra("string_position",0);
            state.setSelection(state_position);



    }


}
