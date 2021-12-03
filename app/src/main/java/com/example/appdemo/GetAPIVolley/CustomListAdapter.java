package com.example.appdemo.GetAPIVolley;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appdemo.R;
import com.example.appdemo.VolleyandRetrofitAPI.Demo;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<Demo> demoList;


    public CustomListAdapter(Activity activity, List<Demo> demoList) {
        this.activity = activity;
        this.demoList = demoList;
    }

    @Override
    public int getCount() {
        return demoList.size();
    }

    @Override
    public Object getItem(int position) {
        return demoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null)
        {
            convertView = LayoutInflater.from(activity).inflate(R.layout.list_row,parent,false);
        }

        TextView serviceName = convertView.findViewById(R.id.serveiceName);
        Demo demo = demoList.get(position);

        serviceName.setText(demo.getServiceName());


        return convertView;
    }
}
