package com.example.sql_lite_revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Activity extends AppCompatActivity {
    EditText ed_titlel , ed_desc;
    Button update , delete;
    sql_test sql_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);
        sql_test = new sql_test(this);
        ed_titlel = findViewById(R.id.update_title);
        delete = findViewById(R.id.Delete_btn);
        ed_desc = findViewById(R.id.update_desc);
        update =findViewById(R.id.Update_btn);
        final String id = getIntent().getStringExtra("id");
        final model model = sql_test.get_contact_by_id(id);
        ed_titlel.setText(model.getTitle());
        ed_desc.setText(model.getDesc());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model model1 = new model(ed_titlel.getText().toString() , ed_desc.getText().toString() ,id );
                sql_test.Update_data(model1);
                Toast.makeText(Update_Activity.this, "Note Update Sucssefully", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(Update_Activity.this,MainActivity.class));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql_test.Delete_data(id);
                Toast.makeText(Update_Activity.this, "Note Deleted Sucssefully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Update_Activity.this,MainActivity.class));

            }
        });



    }


}
