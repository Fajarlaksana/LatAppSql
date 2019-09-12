package com.example.myappsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainDashboard extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> dataList;
    private DataAdapter dataAdapter;

    String[] text = {"LIHAT DATA","INPUT DATA","INFORMASI"};
    int[] image = {R.drawable.ic_archive_black_24dp,R.drawable.ic_add_box_black_24dp,R.drawable.ic_info_black_24dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dataList = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {

            Data data = new Data(text[i], i + 1, image[i]);
            dataList.add(data);
        }
        dataAdapter = new DataAdapter(dataList);
        recyclerView.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        recyclerView.addOnItemTouchListener((RecyclerView.OnItemTouchListener) new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(MainDashboard.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();

                    }
                }));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_grid:
                layoutManager = new GridLayoutManager(this,2);
                recyclerView.setLayoutManager(layoutManager);
                break;
            case R.id.item_horizontal:
                layoutManager = new LinearLayoutManager(MainDashboard.this,LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(layoutManager);
                break;

        }
        return super.onOptionsItemSelected(item);
    }




}
