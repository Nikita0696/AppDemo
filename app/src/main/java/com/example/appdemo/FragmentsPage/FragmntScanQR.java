package com.example.appdemo.FragmentsPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdemo.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmntScanQR#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmntScanQR extends Fragment {

    private Button btnscan;
    public static TextView scantext;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmntScanQR() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmntScanQR.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmntScanQR newInstance(String param1, String param2) {
        FragmntScanQR fragment = new FragmntScanQR();
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

        final View rootView = inflater.inflate(R.layout.fragment_fragmnt_scan_q_r,
                container, false);

        btnscan = (Button) rootView.findViewById(R.id.btnscan1);
        scantext = rootView.findViewById(R.id.scantext1);

        // Inflate the layout for this fragment

        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                Intent intent = new Intent(getContext(),ScannerViewActivity.class);
                startActivity(intent);*/
                /*IntentIntegrator.forSupportFragment(FragmntScanQR.this).initiateScan();*/
                IntentIntegrator.forSupportFragment(FragmntScanQR.this).initiateScan();
//                scanCode();
            }
        });


        return rootView;
    }


    private void scanCode() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
        intentIntegrator.setCaptureActivity(CaptureAct.class);
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setPrompt("Scanning Code");
        intentIntegrator.initiateScan();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        scantext.setText(scanResult.getContents());*/

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() != null) {
                String getBarcodeDetails = result.getContents();
                scantext.setText("" + getBarcodeDetails.toUpperCase());
            }

       /* if (scanResult != null)
        {
            scantext.setText(scanResult.getContents());
            if (scanResult.getContents() != null)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(scanResult.getContents());
                builder.setTitle("Scanning Result");
                builder.setPositiveButton("Scan Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scanCode();
                    }
                }).setNegativeButton("finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            getActivity().finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();;
            }
            else {
                Toast.makeText(getContext(),"No Result",Toast.LENGTH_LONG).show();
            }
        }
        else
            Toast.makeText(getContext(),"No Result",Toast.LENGTH_LONG).show();*/
        }
    }
}