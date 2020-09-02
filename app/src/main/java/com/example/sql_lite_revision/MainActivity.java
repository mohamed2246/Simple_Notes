package com.example.sql_lite_revision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements Adapter.ON_item_click_lisner , View.OnClickListener {
    EditText title, description;
    Button btn_save;
    RecyclerView recyclerView;
    List<model> models;
    //Notes_DB notes_db;
    sql_test sql_test;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
       // notes_db = new Notes_DB(this);
        sql_test = new sql_test(this);
        Intial();
        models = sql_test.get_my_notes();
         adapter = new Adapter(models, this,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();



    }

    private void Intial() {

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        btn_save = findViewById(R.id.save_btn);
        btn_save.setOnClickListener(this);
        recyclerView = findViewById(R.id.recycleview);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_btn:
                model model = new model(title.getText().toString(), description.getText().toString() );
                models = sql_test.get_my_notes();
                sql_test.add_node(model);
                adapter = new Adapter(models, this , this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                break;
        }

    }

    @Override
    public void on_click_lisner(String id, View view) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this , Update_Activity.class);
        intent.putExtra("id" , id);
        startActivity(intent);
    }



}
