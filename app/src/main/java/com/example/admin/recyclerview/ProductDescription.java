package com.example.admin.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductDescription extends AppCompatActivity {
    ImageView imageView,imageView1,imageView2,imageView3,imageView4;
    TextView tx_name,tx_amount;

    private List<Products> pList;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details_layout);
        imageView =(ImageView) findViewById(R.id.pImage);
        tx_name = (TextView) findViewById(R.id.pName);
        tx_amount = (TextView) findViewById(R.id.pAmount);
        imageView1 = (ImageView) findViewById(R.id.pImageView1);
        imageView2 = (ImageView) findViewById(R.id.pImageView2);
        imageView3 = (ImageView) findViewById(R.id.pImageView3);
        imageView4 = (ImageView) findViewById(R.id.pImageView4);

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("products")){

            pList = (ArrayList) getIntent().getParcelableArrayListExtra("products");
            position = getIntent().getIntExtra("position",00);


            Log.i("### ", "onCreate: "+ pList.get(position).getpName());

            imageView.setImageResource(pList.get(position).getpImage());
            tx_name.setText(pList.get(position).getpName());
            tx_amount.setText(pList.get(position).getpAmount());
            imageView1.setImageResource(pList.get(position).getpImage1());
            imageView2.setImageResource(pList.get(position).getpImage2());
            imageView3.setImageResource(pList.get(position).getpImage3());
            imageView4.setImageResource(pList.get(position).getpImage4());

            Log.d("##", "position choosed = " + position);

        }





    }
}
