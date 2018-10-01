package com.example.eunra.myapplication;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    EditText ten, age;
    Button them, xoa, sua;
    ArrayList<Person> ds;
    ListView lv;
    ArrayAdapter<Person> arrdt;

    int vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ten = findViewById(R.id.ten);
        age = findViewById(R.id.age);
        lv = findViewById(R.id.lv);



        ds = new ArrayList<>();
        ds.add(new Person("NBam", 25));
        ds.add(new Person("ew", 32));
        ds.add(new Person("dsa", 1));
        ds.add(new Person("zx", 23));




        arrdt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ds);

        lv.setAdapter(arrdt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vt = position;
                Toast.makeText(MainActivity.this, ""+vt, Toast.LENGTH_SHORT).show();
                ten.setText(ds.get(position).getTen().toString());
                age.setText(ds.get(position).getAge()+"");
            }
        });




        sua = findViewById(R.id.sua);
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nten = ten.getText().toString();
                int nage = Integer.parseInt(age.getText().toString());
                for(int i = 0; i<= ds.size(); i++){
                    if(vt == i){
                        ds.get(i).setTen(nten);
                        ds.get(i).setAge(nage);
                        arrdt.notifyDataSetChanged();
                    }
                }
            }
        });

        them = findViewById(R.id.them);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nten = ten.getText().toString();

                int nage = Integer.parseInt(age.getText().toString());
                if( nten.trim().length() == 0){
                    ten.setError("Chua nhap ne");
                    ten.requestFocus();
                 //   age.setError("loi");
                   Toast.makeText(MainActivity.this, "Chua nhap dl", Toast.LENGTH_SHORT).show();
                }else{
                    ds.add(new Person(nten, nage));
                    arrdt.notifyDataSetChanged();
                }

            }
        });

        xoa = findViewById(R.id.xoa);
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ds.remove(vt);
                    arrdt.notifyDataSetChanged();

            }
        });


    }


}
