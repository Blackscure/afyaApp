package com.buyahi.afya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AfyaActivity extends AppCompatActivity {
    public static final String TAG = AfyaActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] parlor = new String[]{"Shani Active gym", " Kings Gym and Spa", "Sunsession spa", " Amadavi center", " StylePro point",
            "Superior point", "Brows fitnes", "sarit place", "New york",
            "Natural fitness", "Japan yokozuna", "Hapina center",
            "Boss place", "Gaden city"};
    private String[] services = new String[]{"Chest broden", "six pack", "leg muscles",
            "loose weight", "Massage", "Sweden"
            , " deep tissue", "stress relief", "back bone ", "consultation", "ayuvedict reatment",
            "boxing", "skating", "swimming"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afya);
        ButterKnife.bind(this);
        AfyaFitnessArrayAdapter adapter = new  AfyaFitnessArrayAdapter(this, android.R.layout.simple_list_item_1, parlor, services);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pet = ((TextView) view).getText().toString();
                Log.v(TAG, "In the onItemClickListener!");
                Toast.makeText(AfyaActivity.this, pet, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the Afya Gym Centers near: " + location);
        Log.d(TAG, "In the onCreate method!");
    }
}