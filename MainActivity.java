package com.example.mywifi_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button sendbt;
//    private Button getdbt;
    private EditText editdt;
    public String msg;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private ChildEventListener mChild;

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendbt = (Button) findViewById(R.id.input);
//        getdbt = (Button) findViewById(R.id.output);
        editdt = (EditText) findViewById(R.id.editText1);
        listView = (ListView) findViewById(R.id.listviewmsg);

//        initDatabase();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        listView.setAdapter(adapter);

        List<Object> Array = new ArrayList<Object>();

        sendbt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 누르면 수행 할 명령
                msg = editdt.getText().toString();
                databaseReference.push().setValue(msg);
            }

            //databaseReference myRef = database.getRefere






        });


    }

//    private void initDatabase() {
//        mDatabase = FirebaseDatabase.getInstance();
//
//        mReference = mDatabase.getReference("log");
//        mReference.child("log").setValue("check");
    }

//}
