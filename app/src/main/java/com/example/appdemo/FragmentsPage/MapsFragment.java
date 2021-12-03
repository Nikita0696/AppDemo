package com.example.appdemo.FragmentsPage;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdemo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapsFragment extends Fragment {

    TextView txtsource ,txtdes, txtdistance ,txttime;
    GoogleMap gMap;
    LatLng currentLoc , desLoc ;
    Button btn_map_details;

    MarkerOptions markerOptions;
    String duration , distance;
    int flag = 0 ;
    GPSTracker gpsTracker;


    OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady( final GoogleMap googleMap) {
            gMap =  googleMap;

            gMap.getUiSettings().setZoomControlsEnabled(true);
            gMap.getUiSettings().setMyLocationButtonEnabled(true);
            markerOptions = new MarkerOptions();
            gpsTracker = new GPSTracker(getContext());

            firstMarker(googleMap);

            googleMap.setOnMapClickListener((LatLng point) -> {
                if (flag == 0)
                {
                    desLoc = new LatLng(point.latitude,point.longitude);
                    markerOptions.position(desLoc).title("New Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    googleMap.addMarker(markerOptions);


                    new TaskDirectionRequest().execute(getDirectionsUrl(currentLoc, point));
                    txtdistance.setText("Distance : " + getDistanceMeters(gpsTracker.getLatitude(), gpsTracker.getLongitude(), point.latitude, point.longitude) + "Meters");

                    txtdes.setText("Destination " + getAddress(point.latitude,point.longitude));
                    //txttime.setText("Time : " + duration);

                    flag = 1;

                    Toast.makeText(getContext(), "Click again to reset the marker", Toast.LENGTH_LONG).show();
                }
                else {
                    googleMap.clear();
                    flag = 0;

                    firstMarker(googleMap);
                    txtdes.setText("");
                    txtdistance.setText("");
                    txttime.setText("");
                }
            });
        }
    };

    private String getAddress(double latitude, double longitude) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            Geocoder geocoder= new Geocoder(getContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude,longitude,1);
            if (addresses.size() > 0)
            {
                Address address = addresses.get(0);
                stringBuilder.append(address.getAddressLine(0)).append("\n");
                stringBuilder.append(address.getLocality()).append("\n");
                stringBuilder.append(address.getCountryName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
    private void firstMarker(GoogleMap googleMap) {

        currentLoc = new LatLng(gpsTracker.getLatitude(), gpsTracker.getLongitude());
        markerOptions.position(currentLoc).title("You are here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 16.0f));
        txtsource.setText(gpsTracker.getAddressLine(getContext()));
    }
    public static long getDistanceMeters(double lat1, double lng1, double lat2, double lng2) {
        double l1 = toRadians(lat1);
        double l2 = toRadians(lat2);
        double g1 = toRadians(lng1);
        double g2 = toRadians(lng2);

        double dist = acos(sin(l1) * sin(l2) + cos(l1) * cos(l2) * cos(g1 - g2));
        if (dist < 0) {
            dist = dist + Math.PI;
        }
        return Math.round(dist * 6378100);
    }






    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapsFragment newInstance(String param1, String param2) {
        MapsFragment fragment = new MapsFragment();
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

        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        txttime = view.findViewById(R.id.txttime);
        txtsource = view.findViewById(R.id.txtsource);
        txtdistance = view.findViewById(R.id.txtdistance);
        txtdes = view.findViewById(R.id.txtdes);

        /*btn_map_details = view.findViewById(R.id.btn_map_details);

        btn_map_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragmentmap);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
    private String getDirectionsUrl(LatLng origin, LatLng dest) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Key
        String key = "key=" + getString(R.string.google_maps_key);

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + key;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;
        System.out.println(url);
        return url;
    }
    private String requestDirection(String requestedUrl) throws IOException {
        String responseString = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(requestedUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            responseString = stringBuffer.toString();
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();

            }
            httpURLConnection.disconnect();
        }

        return responseString;
    }

    public class TaskDirectionRequest extends AsyncTask<String ,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            String responseString = "";
            try {
                responseString = requestDirection(strings[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TaskParseDirection parseResult = new TaskParseDirection();
            parseResult.execute(s);
        }


    }

    private class TaskParseDirection extends AsyncTask<String, Void, List<List<HashMap<String, String>>>> {
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... strings) {
            List<List<HashMap<String, String>>> routes = null;
            JSONObject jsonObject = null;

            try {
                jsonObject = new JSONObject(strings[0]);
                DirectionParser parser = new DirectionParser();
                routes = parser.parse(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> lists) {
            super.onPostExecute(lists);
            ArrayList points = null;
            PolylineOptions polylineOptions = null;
            distance = "";
            duration = "";

            try {
                for (List<HashMap<String, String>> path : lists) {
                    points = new ArrayList();
                    polylineOptions = new PolylineOptions();

                    for (int j = 0; j < path.size(); j++) {
                        HashMap<String, String> point = path.get(j);

                        if (j == 0) {    // Get distance from the list
                            distance = (String) point.get("distance");
                            continue;
                        } else if (j == 1) { // Get duration from the list
                            duration = (String) point.get("duration");
                            continue;
                        }

                        double lat = Double.parseDouble(point.get("lat"));
                        double lon = Double.parseDouble(point.get("lng"));

                        points.add(new LatLng(lat, lon));
                    }
                    polylineOptions.addAll(points);
                    polylineOptions.width(15f);
                    polylineOptions.color(Color.BLUE);
                    polylineOptions.geodesic(true);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (polylineOptions != null) {
                gMap.addPolyline(polylineOptions);
            } else {
                Toast.makeText(getContext(), "Direction not found", Toast.LENGTH_LONG).show();
            }
        }
    }
}