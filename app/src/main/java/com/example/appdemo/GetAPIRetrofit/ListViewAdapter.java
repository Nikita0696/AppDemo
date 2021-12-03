package com.example.appdemo.GetAPIRetrofit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdemo.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

  public List<DemoPojo> demoPojos;
  public Activity context;

  public ListViewAdapter(Activity context , List<DemoPojo> demoPojos)
  {
    this.context = context;
    this.demoPojos = demoPojos;
  }


  @Override
  public int getCount() {
    return demoPojos.size();
  }

  @Override
  public Object getItem(int position) {
    return demoPojos.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    if (convertView == null)
    {
      convertView = LayoutInflater.from(context).inflate(R.layout.list_row_layout,parent,false);

    }

    TextView serveiceName = convertView.findViewById(R.id.serveiceName1);
    DemoPojo demoPojo = demoPojos.get(position);
    serveiceName.setText(demoPojo.getServiceName());

    convertView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(context, demoPojo.getServiceName(), Toast.LENGTH_SHORT).show();
      }
    });
    return convertView ;
  }
}
