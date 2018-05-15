package com.gusssar.alexeev.select_card;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameCheckActivity extends AppCompatActivity {
    private ArrayList<String> mScoreList = new ArrayList<>();
    private MyArrayAdapter mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_check);


        GridView gridView = (GridView) findViewById(R.id.gridView);

       // initList();
        mScoreList.add("1");
        mScoreList.add("2");
        mScoreList.add("3");
        mScoreList.add("4");
        mScoreList.add("5");


        //шо то тут не чисто!
        mArrayAdapter = new MyArrayAdapter(this, R.layout.list_item, android.R.id.text1, mScoreList);

        gridView.setAdapter(mArrayAdapter);
        gridView.setOnItemClickListener(myOnItemClickListener);
    }

    public void onClick(View view) {
        String result = "";
        List<String> resultList = mArrayAdapter.getCheckedItems();
        for (int i = 0; i < resultList.size(); i++) {
            result += String.valueOf(resultList.get(i)) + "\n";
        }

        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG)
                .show();
    }

  //  private void initList() {
  //      mScoreList.add("1");
  //      mScoreList.add("2");
  //      mScoreList.add("3");
  //      mScoreList.add("4");
  //      mScoreList.add("5");
  //  }

    AdapterView.OnItemClickListener myOnItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            mArrayAdapter.toggleChecked(position);
        }
    };

    private class MyArrayAdapter extends ArrayAdapter<String> {

        private HashMap<Integer, Boolean> mCheckedMap = new HashMap<>();

        MyArrayAdapter(Context context, int resource,
                       int textViewResourceId, List<String> objects) {
            super(context, resource, textViewResourceId, objects);

            for (int i = 0; i < objects.size(); i++) {
                mCheckedMap.put(i, false);
            }
        }

        void toggleChecked(int position) {
            if (mCheckedMap.get(position)) {
                mCheckedMap.put(position, false);
            } else {
                mCheckedMap.put(position, true);
            }

            notifyDataSetChanged();
        }

     public List<Integer> getCheckedItemPositions() {
         List<Integer> checkedItemPositions = new ArrayList<>();

         for (int i = 0; i < mCheckedMap.size(); i++) {
             if (mCheckedMap.get(i)) {
                 (checkedItemPositions).add(i);
             }
         }

         return checkedItemPositions;
     }

        List<String> getCheckedItems() {
            List<String> checkedItems = new ArrayList<>();

            for (int i = 0; i < mCheckedMap.size(); i++) {
                if (mCheckedMap.get(i)) {
                   (checkedItems).add(mScoreList.get(i)); //тоже посмотри!!!
                }
            }

            return checkedItems;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            View row = convertView;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.list_item, parent, false);
            }

            CheckedTextView checkedTextView = (CheckedTextView) row
                    .findViewById(R.id.checkedTextView);
            checkedTextView.setText(mScoreList.get(position));  //тоже посмотри!!!

            Boolean checked = mCheckedMap.get(position);
            if (checked != null) {
                checkedTextView.setChecked(checked);
            }

            return row;
        }
  }
}