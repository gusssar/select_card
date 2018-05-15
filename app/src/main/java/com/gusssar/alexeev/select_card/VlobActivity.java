package com.gusssar.alexeev.select_card;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VlobActivity extends AppCompatActivity {

    private CheckBox m6CheckBox, m7CheckBox;
    private TextView mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlob);

        m6CheckBox = (CheckBox) findViewById(R.id.ch_box_1);
        m7CheckBox = (CheckBox) findViewById(R.id.ch_box_2);

        mEdit = (TextView) findViewById(R.id.debug_edit);
    }

    public void ShowRes(View view) {
        int total = 0;
        if (m6CheckBox.isChecked()){
            total = total +6;
        }
        if (m7CheckBox.isChecked()){
            total = total +7;
        }
//        else {}
        mEdit.setText("Итого " + total);
        return;
    }
}
