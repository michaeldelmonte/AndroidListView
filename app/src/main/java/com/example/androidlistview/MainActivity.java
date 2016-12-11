package com.example.androidlistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    String[] valueList;
    ListView listView;
    ArrayList arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_checked, arrayList);

    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        String itemSelected = arrayList.get(position).toString();

        ListDialogFragment listDialogFragment = ListDialogFragment.newInstance("Viewed","Selected Item : " + itemSelected, "item_clicked");
        listDialogFragment.show(getFragmentManager(), "dialog");
    }

    public void handleSaveToList(View view) {
        ListDialogFragment listDialogFragment = ListDialogFragment.newInstance("Add Item to list","", "item_add");
        listDialogFragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick(String valueText) {
        if (valueText.equals("")) {
            Toast.makeText(getApplicationContext(), "Type Something", Toast.LENGTH_SHORT).show();
        } else {
            listView = (ListView) findViewById(android.R.id.list);
            listView.setAdapter(adapter);

            arrayList.add(valueText);

            adapter.notifyDataSetChanged();
        }
    }

    public void doNegativeClick() {

    }
}
