package com.gusssar.alexeev.select_card;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoTab(View view) {
        Intent intent = new Intent(this, GameTableActivity.class);
        startActivity(intent);
    }

    public void GoCh(View view) {
        Intent intent = new Intent(this, GameCheckActivity.class);
        startActivity(intent);
    }

    public void GoVl(View view) {
        Intent intent = new Intent(this, VlobActivity.class);
        startActivity(intent);
    }

    public void GoVlEasy(View view) {
        Intent intent = new Intent(this, EasyVlopActivity.class);
        startActivity(intent);
    }
}
