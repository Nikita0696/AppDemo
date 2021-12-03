package com.example.appdemo.ApiCalling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.appdemo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GetApiCalling#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetApiCalling extends Fragment {
    private GridViewAdapter gridViewAdapter;
    private GridView gridView;

    List<Model.HandbillDTO> handbillDTOList;
    /*private ProgressBar progressBar;*/

   /* private void populateGridView(List<Model.HandbillDTO> handbillDTOList) {
        gridView = findViewById(R.id.mGridView);
        gridViewAdapter = new GridViewAdapter(this,handbillDTOList);
        gridView.setAdapter(gridViewAdapter);
    }*/


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GetApiCalling() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GetApiCalling.
     */
    // TODO: Rename and change types and number of parameters
    public static GetApiCalling newInstance(String param1, String param2) {
        GetApiCalling fragment = new GetApiCalling();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_get_api_calling, container, false);

        gridView = rootview.findViewById(R.id.mGridView);

        APIInerface  apiInerface = RetrofitClient.getRetrofitInstance().create(APIInerface.class);
        Call<Model> call = apiInerface.getAllData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful() && response != null)
                {
                    gridViewAdapter = new GridViewAdapter(getActivity(),response.body().getHandbill());
                    gridView.setAdapter(gridViewAdapter);
                    Toast.makeText(getActivity(), "Response : " + response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Response Failure " + response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                Toast.makeText(getActivity(), "Failure!!", Toast.LENGTH_SHORT).show();
            }
        });


        return rootview;
    }
}