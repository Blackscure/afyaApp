package com.buyahi.afya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AfyaActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] centers = new String[] {"Tassia", "Kitengela",
            "Hulligam", "Garden City", "Thika", "Zion mall",
            "Sinza cty", "Aurelx", "Maltys", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afya);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, centers);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(AfyaActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });
        mLocationTextView.setText("Here are all the Exersse offerd near: " + location);
    }


}


