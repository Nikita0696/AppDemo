package com.example.appdemo.GetAPIVolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.appdemo.R;
import com.example.appdemo.VolleyandRetrofitAPI.Demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetApiCallingVolley extends Fragment {
    private static final String TAG = GetApiCallingVolley.class.getSimpleName();

    private static final String Url = "http://scanso.nueclear.com/api/MasterData/GetServiceMaster/CN00000001/7738943013";
    private static final String token = "http://scanso.nueclear.com/api/Login/RegisteredUser";
        private ProgressDialog dialog;
        private List<Demo> demoList = new ArrayList<Demo>();
        private ListView listView;
        private CustomListAdapter adapter;


    public GetApiCallingVolley() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view  =inflater.inflate(R.layout.fragment_get_api_calling_volley, container, false);
        listView = view.findViewById(R.id.listView);
        adapter = new CustomListAdapter(getActivity(),demoList);
        listView.setAdapter(adapter);

        dialog = new ProgressDialog(getActivity());

        dialog.setMessage("Loading....");
        dialog.show();

            fetchToken("");
        return view;
    }

    private void fetchToken(final @NonNull String accessToken) {
        {
            JsonArrayRequest arrayRequest = new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    Toast.makeText(getActivity(), "Here " + response, Toast.LENGTH_SHORT).show();

                    hideDialog();
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject object = response.getJSONObject(i);
                            Demo demo = new Demo();
                            demo.setServiceName(object.getString("ServiceName"));

                            demoList.add(demo);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getActivity(), "Hii", Toast.LENGTH_SHORT).show();
                    hideDialog();

                }
            }) {
                @Override
                public Map getHeaders() throws AuthFailureError {

                    HashMap headers = new HashMap();
                    headers.put("Authorization", "Bearer 8nvcC8jRJ3qNcy1-gRRSzfxZG0XkOkIZUphrkx7H46-ZPCwce4rHLBIHFUREB55oIoISAaBSWkgO61fKdSr9AOL4VbzQ5OrXRPF2CAUpO0Zy-TA4i80ohGwrvLW6GFjIjAthrAZrDw_JOE6KGNiOMSdCR4lAsU3wTDfHCIExXZbyQCGXAnOy0GMPJtHgq1BN3aMCgamSNWxp61JF-fEQ7THIkDHbczlLD-JWii9iKrYkTMf1mpTdwDDsxdSfD1GUeOxExE83jln9gsL3P1yeN6_flq-jiz14Z9jSsFIgPGfkvv4U-GGb7flpl6YSfPEVsfErcraE4faU8m1OHRazucutLHzPB3W1T_6cj8N86bY1fK437aCkNh_s8Ei6d2B9rh1En_F8fk3Fq_g-kADxOzKdZLNOws6tzscjwsTLD32d8NYsIWnkB1uD0x6PWKuNKSRfenTHM1WQh4shwJO9beBy63yVGcoCPFi2z-xEzf-ze7p4UyUjBaI3g9TrU7Bx");
                    return headers;
                }
            };

            AppController.getInstance().addToRequestQueue(arrayRequest);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        hideDialog();
    }

    private void hideDialog() {

        if (dialog != null)
        {
            dialog.dismiss();
            dialog =null;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
}