package com.example.admin.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 02-08-2017.
 */

public class AdapterForProducts extends RecyclerView.Adapter<AdapterForProducts.RecyclerViewHolder> {



    private ArrayList<Products> arrayList = new ArrayList<Products>();
    Context mContext;

    public AdapterForProducts(ArrayList<Products> arrayList, Context ctx)
    {
        this.arrayList = arrayList;
        this.mContext= mContext;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view,mContext,arrayList);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        Products products =arrayList.get(position);
        holder.pImage.setImageResource(products.getpImage());
        holder.pName.setText(products.getpName());
        holder.pAmount.setText(products.getpAmount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("##" , "onClick: position"+position);


                Intent intent = new Intent(v.getContext(),ProductDescription.class);

                intent.putExtra("products",arrayList);
                intent.putExtra("position",position);



                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {



        ImageView pImage, pImage1, pImage2, pImage3, pImage4;
        TextView pName, pAmount;

        ArrayList<Products> productses = new ArrayList<Products>();
        Context ctx;

        public RecyclerViewHolder(View view,Context ctx,ArrayList<Products> productses)
        {
            super(view);
            this.productses = productses;
            this.ctx=ctx;
            pImage =(ImageView) view.findViewById(R.id.pImage);
            pName =(TextView) view.findViewById(R.id.pName);
            pAmount =(TextView) view.findViewById(R.id.pAmount);
            pImage1 =(ImageView) view.findViewById(R.id.pImageView1);
            pImage2 =(ImageView) view.findViewById(R.id.pImageView2);
            pImage3 =(ImageView) view.findViewById(R.id.pImageView3);
            pImage4 =(ImageView) view.findViewById(R.id.pImageView4);


        }

/*        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Products dataprovider=this.productses.get(position);
            Intent intent = new Intent(ctx,ProductDescription.class);

            intent.putExtra("products", dataprovider);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            *//*intent.putExtra("img_id",dataprovider.getpImage());
            intent.putExtra("name",dataprovider.getpName());
            intent.putExtra("pAmount",dataprovider.getpAmount());

            this.ctx.startActivity(intent);
            Toast.makeText(ctx, "clicked at position"+position,Toast.LENGTH_SHORT).show();

        }*/
    }
}
