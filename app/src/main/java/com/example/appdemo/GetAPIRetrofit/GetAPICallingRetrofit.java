package com.example.appdemo.GetAPIRetrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GetAPICallingRetrofit extends Fragment {
    private ProgressDialog dialog;
    /*private List<Demo> demoList = new ArrayList<Demo>();*/
    private ListView listView;
    private ListViewAdapter adapter;
    private List<DemoPojo> demoPojoList = new ArrayList<DemoPojo>();






    public GetAPICallingRetrofit() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_get_a_p_i_calling_retrofit, container, false);
        listView = view.findViewById(R.id.listViewRetrofit);

        GetAPIInterface anInterface = GetRetrofitClient.getRetrofitInstanceClient().create(GetAPIInterface.class);
        Call<List<DemoPojo>> call = anInterface.getAllData(GetAPIInterface.auth);
        call.enqueue(new Callback<List<DemoPojo>>() {
            @Override
            public void onResponse(Call<List<DemoPojo>> call, Response<List<DemoPojo>> response) {
                if (response.isSuccessful() && response.body() != null)
                {
                    adapter = new ListViewAdapter(getActivity(),response.body());
                    listView.setAdapter(adapter);
                    Toast.makeText(getActivity(), "Response : " + response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Fail : " + response, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<DemoPojo>> call, Throwable t) {


                Toast.makeText(getActivity(), "Failure ", Toast.LENGTH_SHORT).show();


            }
        });



        return view;
    }
}