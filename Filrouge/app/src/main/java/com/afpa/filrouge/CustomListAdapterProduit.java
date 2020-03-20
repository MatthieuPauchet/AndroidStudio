package com.afpa.filrouge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

import Model.Produit;

import static Model.JsonPlaceHolderApi.urlPhoto;

public class CustomListAdapterProduit extends BaseAdapter {


    private List<Produit> listProduit;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapterProduit(List<Produit> listProduit, Context context) {
        this.listProduit = listProduit;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listProduit.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.liste_item_layout,null);
            holder = new ViewHolder();
            holder.produitPicView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.produitNameView = (TextView) convertView.findViewById(R.id.textView_name);
            holder.prizeView = (TextView) convertView.findViewById(R.id.textView_prize);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Produit produit = this.listProduit.get(position);
        holder.produitNameView.setText(produit.getPro_libelle_court());

        final NumberFormat instance = NumberFormat.getNumberInstance();
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        holder.prizeView.setText("Prix : "+instance.format(produit.getPro_prix_achat())+"€");

        Picasso.get().load(urlPhoto+produit.getPro_photo()).into(holder.produitPicView);

        LinearLayout ligne = convertView.findViewById(R.id.ligne);
        ligne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailProduitActivity.class);
                Bundle b = new Bundle();
                b.putInt("pro_id", produit.getPro_id());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder{
        ImageView produitPicView;
        TextView produitNameView;
        TextView prizeView;
    }




}
