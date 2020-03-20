package com.afpa.filrouge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import Model.Rubrique;

import static Model.JsonPlaceHolderApi.urlPhoto;
import static android.view.Gravity.CENTER;
import static android.view.Gravity.LEFT;

public class CustomListAdapterRubrique extends BaseAdapter {


    private List<Rubrique> listRubrique;
    private LayoutInflater layoutInflater;
    private Context context;


    public CustomListAdapterRubrique(List<Rubrique> listRubrique, Context context) {
        this.listRubrique = listRubrique;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public int getCount() {
        return listRubrique.size();
    }

    @Override
    public Object getItem(int position) {
        return listRubrique.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.liste_item_layout,null);
            holder = new ViewHolder();
            holder.rubriquePicView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.rubriqueNameView = (TextView) convertView.findViewById(R.id.textView_name);
            holder.toto = (TextView) convertView.findViewById(R.id.textView_prize);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Rubrique rubrique = this.listRubrique.get(position);
        holder.rubriqueNameView.setText(rubrique.getRub_nom());
        holder.rubriqueNameView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        holder.rubriqueNameView.setGravity(CENTER);
        holder.rubriqueNameView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        holder.toto.setHeight(0);

        Picasso.get().load(urlPhoto+rubrique.getRub_photo()).into(holder.rubriquePicView);

        LinearLayout ligne = convertView.findViewById(R.id.ligne);
        ligne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                String rub_nom = rubrique.getRub_nom();
                b.putString("rub_nom", rub_nom);
                int rub_id  = rubrique.getRub_id();
                b.putInt("rub_id", rub_id);

                if (String.valueOf(rubrique.getRub_id_1()).equals("0")){
                    Intent intent = new Intent(context, ListSousRubriqueActivity.class);
                    intent.putExtras(b);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, ListProduitSousRubriqueActivity.class);
                    intent.putExtras(b);
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }



    static class ViewHolder{
        ImageView rubriquePicView;
        TextView rubriqueNameView;
        TextView toto;
    }

}
