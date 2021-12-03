package com.example.appdemo.VolleyandRetrofitAPI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.appdemo.ApiCalling.APIInerface;
import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;


public class CallAPIVolleyAndRetrofit extends Fragment {

    private Button btnvolley , btnretrofit;
    ListView  listview;

    String authenticationKey;
    String serviceName;

    List<UserModel> userModels = new ArrayList<>();
    List<UserModel> models = new ArrayList<>();

    ListViewAdapterRetrofit listViewAdapterRetrofit;


    public CallAPIVolleyAndRetrofit() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_call_a_p_i_volley_and_retrofit, container, false);

        btnvolley = view.findViewById(R.id.btnvolley);
        btnretrofit = view.findViewById(R.id.btnretrofit);
        listview = view.findViewById(R.id.listview);

        btnvolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateToken();
                callVolleyAPI();

            }
        });
        btnretrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateToken();
                callRetrofitAPI();
                
            }
        });

        return view;
    }

    private void callRetrofitAPI() {
    }

    private void callVolleyAPI() {

    }

    private void generateToken() {
        UserRequestData userRequestData = new UserRequestData();
        APIInerface apiInerface = APIClient.getInstance()
    }
}