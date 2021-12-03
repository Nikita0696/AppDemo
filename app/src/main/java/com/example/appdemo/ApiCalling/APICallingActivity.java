package com.example.appdemo.ApiCalling;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APICallingActivity extends AppCompatActivity {

    private GridViewAdapter gridViewAdapter;
    private GridView gridView;
    private ProgressBar progressBar;

    private void populateGridView(List<Model.HandbillDTO> handbillDTOList) {
        gridView = findViewById(R.id.mGridView);
        gridViewAdapter = new GridViewAdapter(this,handbillDTOList);
        gridView.setAdapter(gridViewAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_i_calling);

        final ProgressBar progressBar = findViewById(R.id.myProgressBar);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);

        APIInerface apiInerface = RetrofitClient.getRetrofitInstance().create(APIInerface.class);

        Call<Model> call = apiInerface.getAllData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                progressBar.setVisibility(View.GONE);
                populateGridView(response.body().getHandbill());


            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}