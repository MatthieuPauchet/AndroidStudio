package com.afpa.filrouge;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import retrofit2.Callback;

public class CustomListAdapter extends BaseAdapter {


    private List<Produit> listProduit;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(List<Produit> listProduit, Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
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

        Produit produit = this.listProduit.get(position);
        holder.produitNameView.setText(produit.getPro_libelle_court());


        final NumberFormat instance = NumberFormat.getNumberInstance();
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        holder.prizeView.setText("Prix : "+instance.format(produit.getPro_prix_achat())+"€");

        Picasso.get().load("https://dev.amorce.org/mpar/filrouge/assets/images/"+produit.getPro_photo()).into(holder.produitPicView);

        LinearLayout barre = convertView.findViewById(R.id.barre);
        barre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailProduitActivity.class);
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


//    public int getMipmapResIdByName(String resName)  {
//        String pkgName = context.getPackageName();
//        // Return 0 if not found.
//        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
//        Log.i("unliste", "Res Name: "+ resName+"==> Res ID = "+ resID);
//        return resID;
//    }


}
