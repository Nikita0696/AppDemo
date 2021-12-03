package com.example.appdemo.PostApiCalling;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostAPICalling extends Fragment {

    Button btnresponse;

    RequestDataModel requestDataModel;
    RequestDataModel.ALLLEAVESDTO allleaverequest;
    ResponseDataModel responseDataModel;
    

    public PostAPICalling() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final    View rootview = inflater.inflate(R.layout.fragment_post_a_p_i_calling, container, false);

        btnresponse = rootview.findViewById(R.id.btnresponse);

        btnresponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                btnrequest();

            }
        });


        return rootview;


    }

    private void btnrequest() {
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setTitle("Please Wait...");
        dialog.show();

        requestDataModel = new RequestDataModel();
        requestDataModel.setEcode("1343E");
        requestDataModel.setAllleaves(setleaveDetails());

        PostAPIInterface postAPIInterface = PostAPIClient.getRetrofitInstance().create(PostAPIInterface.class);
        Call<ResponseDataModel> responseDataModelCall = postAPIInterface.getAllResponse(requestDataModel);
        responseDataModelCall.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                dialog.dismiss();
                if (response.isSuccessful() && response.body() != null)
                {
                    responseDataModel = response.body();
                    Toast.makeText(getActivity(), "Response : " + responseDataModel.getResponse() + "\n Response Id " + responseDataModel.getResponsId(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "No response", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Failure!!! ", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private List<RequestDataModel.ALLLEAVESDTO> setleaveDetails() {

        List<RequestDataModel.ALLLEAVESDTO> allleavesdtoList = new ArrayList<>();
        allleaverequest = new RequestDataModel.ALLLEAVESDTO();

        allleaverequest.setLeaveId("L174201");
        allleaverequest.setAction("REJECT");

        allleavesdtoList.add(allleaverequest);
        return allleavesdtoList;
    }
}