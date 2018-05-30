package com.acadview.assignment7_countrylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String countries[]={"India","USA","UAE","UK"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listView);

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,countries);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                switch (i){
                    case 0 : //India
                        intent.putExtra("choice","0");
                        break;
                    case 1: //USA
                        intent.putExtra("choice","1");
                        break;
                    case 2://UAE
                        intent.putExtra("choice","2");
                        break;
                    case 3://UK
                        intent.putExtra("choice","3");

                }
                startActivity(intent);
            }
        });


    }
}
