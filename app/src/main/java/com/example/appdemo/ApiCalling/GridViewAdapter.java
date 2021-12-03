package com.example.appdemo.ApiCalling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {


    private Context context;
    private List<Model.HandbillDTO> handbillDTOS;

    public GridViewAdapter(Context context, List<Model.HandbillDTO> handbillDTOS) {
        this.context = context;
        this.handbillDTOS = handbillDTOS;
    }





    @Override
    public int getCount() {
        return handbillDTOS.size();
    }

    @Override
    public Object getItem(int position) {
        return handbillDTOS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
        {
             convertView = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false);

        }


        ImageView img = convertView.findViewById(R.id.img);

        final Model.HandbillDTO handbillDTO = handbillDTOS.get(position);

        if (handbillDTO.getUrl() != null && handbillDTO.getUrl().length() > 0)
        {
            Picasso.get().load(handbillDTO.getUrl().replace("http:","https:"))
                    .into(img);
        }else
        {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_LONG).show();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, handbillDTO.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
