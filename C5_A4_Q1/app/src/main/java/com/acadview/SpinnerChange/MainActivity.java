package com.acadview.SpinnerChange;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,mail,phone,city;
    Button submit;
    Spinner country;
    String state_string;
    Spinner state;
    Integer state_position;
    String fileText;

    String FILE_NAME="mydata.txt";
    String countries[]={"India","USA","UAE","UK"};

    String India[]={"Indore","Delhi","patiala","ahemdabad"};
    String USA[]={"Chicago","Boston","Seattle","Austin"};
    String UK[]={"London","York","Manchester"};
    String UAE[]={"Dubai","Ajman","Abu Dhabi"};
    ListView listView;
    ListView listView2;
    int choice=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);

        country = findViewById(R.id.countryspinner);
        submit = findViewById(R.id.submit);
        state = findViewById(R.id.statespinner);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, countries);
        country.setAdapter(arrayAdapter);


        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            ArrayAdapter<String> arrayAdapter2 ;

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i){
                    case 0 : //India
                       arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, India);
                        break;
                    case 1: //USA
                         arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, USA);
                        break;
                    case 2://UK
                        arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, UK);
                        break;
                    case 3://UAE
                        arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, UAE);
                        break;
                }

                state.setAdapter(arrayAdapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "You haven't selected anything ! ", Toast.LENGTH_LONG).show();
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             confirmAlert();
            }
        });


    }

    private void confirmAlert(){
        AlertDialog.Builder alertdialog= new AlertDialog.Builder(MainActivity.this);

        alertdialog.setTitle("Confirm !");
        alertdialog.setMessage("Are you sure you want to save data values ?");

        alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                try {

                    Toast.makeText(MainActivity.this, "YaLL VALUES ARE SAVED ! TY FOR REGISTERING ", Toast.LENGTH_LONG).show();
                }
                catch(Exception e){
                    e.printStackTrace();
                }



            }
        });

        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alertDialogBox=alertdialog.create();
        alertDialogBox.show();
    }


}