package com.appdeveloperrakib.recyclerview_thegroceryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appdeveloperrakib.recyclerview_thegroceryapp.Adapter.MyAdapter;
import com.appdeveloperrakib.recyclerview_thegroceryapp.Model.Item;
import com.appdeveloperrakib.recyclerview_thegroceryapp.R;
import com.appdeveloperrakib.recyclerview_thegroceryapp.Utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    // 1- AdapterView
    RecyclerView recyclerView;

    // 2- Data Source
    List<Item> itemList;

    // 3- Adapter
    MyAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();
        Item item1 = new Item(R.drawable.fruit,"Fruits","Fresh Fruits from the Garden");
        Item item2 = new Item(R.drawable.vegitables,"Vegetables","Delecious Vegetables");
        Item item3 = new Item(R.drawable.bread,"Bakery","Bread, Wheat and Beans");
        Item item4 = new Item(R.drawable.beverage,"Beverage","Juice, Tea, Coffe and Soda");
        Item item5 = new Item(R.drawable.milk,"Milk","Milk, Shakes and Yogurt");
        Item item6 = new Item(R.drawable.popcorn,"Snacks","Pop Corn, Donut and Drinks");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        myadapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myadapter);

        myadapter.setClickListener(this);


    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You Choose "+itemList.get(pos).getItemName(), Toast.LENGTH_SHORT).show();
    }
}