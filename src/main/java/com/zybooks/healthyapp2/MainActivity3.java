package com.zybooks.healthyapp2;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    GridView gridview;
    String[] item = new String[]{
            //"Ex: 205",
            //"Ex: 2000",
            //"Ex: 500"
    };
    Button button;
    Button Remove;
    Button sms;
    Button settingsButton;
    List<String> ITEM_LIST;
    ArrayAdapter<String> arrayadapter;
    EditText edittext;
    String GetItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gridview = (GridView)findViewById(R.id.gridView1);

        button = (Button)findViewById(R.id.button1);

        Remove = (Button)findViewById(R.id.button2);

        sms = (Button)findViewById(R.id.sms);

        settingsButton = (Button)findViewById(R.id.settingsButton);

        edittext = (EditText)findViewById(R.id.editText1);

        ITEM_LIST = new ArrayList<String>(Arrays.asList(item));

        arrayadapter = new ArrayAdapter<String>(MainActivity3.this,android.R.layout.simple_list_item_1, ITEM_LIST);

        gridview.setAdapter(arrayadapter);

        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GetItem = edittext.getText().toString();

                ITEM_LIST.add(ITEM_LIST.size(),GetItem);

                arrayadapter.notifyDataSetChanged();

                Toast.makeText(MainActivity3.this, "Item Added SuccessFully", Toast.LENGTH_LONG).show();
            }
        });
        Remove.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GetItem = edittext.getText().toString();

                ITEM_LIST.remove(3);

                arrayadapter.notifyDataSetChanged();

                Toast.makeText(MainActivity3.this, "Item Deleted SuccessFully", Toast.LENGTH_LONG).show();
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_main4();
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_main2();
            }
        });
    }

    public void openActivity_main4() {
        Intent intent = new Intent(this, smsScreen.class);
        startActivity(intent);
    }
    public void openActivity_main2() {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}