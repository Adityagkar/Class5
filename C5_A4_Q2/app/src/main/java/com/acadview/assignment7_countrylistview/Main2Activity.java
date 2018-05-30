package com.acadview.assignment7_countrylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    String India[]={"Indore","Delhi","patiala","ahemdabad"};
    String USA[]={"Chicago","Boston","Seattle","Austin"};
    String UK[]={"London","York","Manchester"};
    String UAE[]={"Dubai","Ajman","Abu Dhabi"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       String choice=(getIntent().getStringExtra("choice"));

        listView=findViewById(R.id.cityList);

        switch (choice){
            case "0":
                ArrayAdapter arrayAdapter=new ArrayAdapter(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,India);
                listView.setAdapter(arrayAdapter);
                break;

            case "1":
                ArrayAdapter arrayAdapter2=new ArrayAdapter(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,USA);
                listView.setAdapter(arrayAdapter2);
                break;

            case "2":
                ArrayAdapter arrayAdapter3=new ArrayAdapter(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,UAE);
                listView.setAdapter(arrayAdapter3);
                break;

            case "3":
                ArrayAdapter arrayAdapter4=new ArrayAdapter(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,UK);
                listView.setAdapter(arrayAdapter4);

        }



    }
}
