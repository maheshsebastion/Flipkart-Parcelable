package com.example.admin.recyclerview;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private android.support.v7.app.ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;

    Button button;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] P_name, P_amount;
    int[] pImage = {R.drawable.iphone,R.drawable.lenovo,R.drawable.moto,R.drawable.sgalaxy,};
    int[] pImage1 = {R.drawable.iphone,R.drawable.lenovo,R.drawable.moto,R.drawable.sgalaxy};
    int[] pImage2 = {R.drawable.iphoneback,R.drawable.lenovoback,R.drawable.motoback,R.drawable.galaxyback};
    int[] pImage3 = {R.drawable.iphoneside,R.drawable.lenovoside,R.drawable.motoside,R.drawable.galaxyside};
    int[] pImage4 = {R.drawable.iphoneview,R.drawable.lenovoview,R.drawable.motoview,R.drawable.galaxyview};
    ArrayList<Products> arrayList=new ArrayList<Products>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Flipkart");

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
        layoutManager = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ProductsDescriptionActivity.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.buttons, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
