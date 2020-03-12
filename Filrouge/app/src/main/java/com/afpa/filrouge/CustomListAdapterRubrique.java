package com.afpa.filrouge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

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
        ViewHolder holder;
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

        Rubrique rubrique = this.listRubrique.get(position);
        holder.rubriqueNameView.setText(rubrique.getRub_nom());
        holder.toto.setText(String.valueOf(rubrique.getRub_id_1()));

        Picasso.get().load("https://dev.amorce.org/mpar/filrouge/assets/images/"+rubrique.getRub_photo()).into(holder.rubriquePicView);

        return convertView;
    }



    static class ViewHolder{
        ImageView rubriquePicView;
        TextView rubriqueNameView;
        TextView toto;
    }

}
