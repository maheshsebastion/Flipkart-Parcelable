package com.example.admin.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;

public class ProductsDescriptionActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] P_name, P_amount;
    int[] pImage= {R.drawable.iphone,R.drawable.lenovo,R.drawable.moto,R.drawable.sgalaxy,};
    int[] pImage1 = {R.drawable.iphone,R.drawable.lenovo,R.drawable.moto,R.drawable.sgalaxy};
    int[] pImage2 = {R.drawable.iphoneback,R.drawable.lenovoback,R.drawable.motoback,R.drawable.galaxyback};
    int[] pImage3 = {R.drawable.iphoneside,R.drawable.lenovoside,R.drawable.motoside,R.drawable.galaxyside};
    int[] pImage4 = {R.drawable.iphoneview,R.drawable.lenovoview,R.drawable.motoview,R.drawable.galaxyview};
    ArrayList<Products> arrayList=new ArrayList<Products>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mobile Devices");

        recyclerView=(RecyclerView) findViewById(R.id.rv);
        P_name =getResources().getStringArray(R.array.names);
        P_amount =getResources().getStringArray(R.array.amount);

        int i=0;
        for(String name: P_name)
        {
            Products products =new Products(pImage[i],name, P_amount[i], pImage1[i], pImage2[i], pImage3[i], pImage4[i]);
            arrayList.add(products);
            i++;
        }

        adapter = new AdapterForProducts(arrayList,this);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(ProductsDescriptionActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.product_buttons, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
