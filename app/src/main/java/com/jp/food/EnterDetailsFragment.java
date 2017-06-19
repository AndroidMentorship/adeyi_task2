package com.jp.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnterDetailsFragment extends Fragment {
@BindView(R.id.idETaddress) EditText eTaddress;
    @BindView(R.id.idETBusstop) EditText eTBusStop;
    @BindView(R.id.idETemail) EditText eTEmail;
    @BindView(R.id.idETfullname) EditText etFullName;
    @BindView(R.id.idETphone) EditText eTphone;
    @BindView(R.id.idETCoupon) EditText eTcoupon;
    @BindView(R.id.idBtnProceedEnter) Button btnProceed;


    public EnterDetailsFragment() {


        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_enter_details, container, false);
        ButterKnife.bind(this, view);
        final String fullname = etFullName.getText().toString().trim();
        final String email = eTEmail.getText().toString().trim();
        final String address = eTaddress.getText().toString().trim();
        final String phoneNum = eTphone.getText().toString().trim();
        final String busStop = eTBusStop.getText().toString().trim();
        String couponCode = eTcoupon.getText().toString().trim();
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForIrregularities();
                if (isKeysFilled()){
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    ConfirmDetailsFragment confirmDetailsFragment = ConfirmDetailsFragment.newInstance(etFullName.getText().toString().trim(),
                            eTEmail.getText().toString().toString(),
                            eTphone.getText().toString().trim(),
                            eTBusStop.getText().toString().trim(),
                            eTaddress.getText().toString().trim() );
                    fragmentTransaction.replace(R.id.idcontainerframe,confirmDetailsFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        // Inflate the layout for this fragment



        return view;
    }
    public  void checkForIrregularities(){
        if (etFullName.getText().toString().trim().isEmpty()){
            etFullName.setError("Please Enter Full name");
        } else {
            etFullName.setError(null);
        }

        if(eTEmail.getText().toString().trim().isEmpty()){
            eTEmail.setError("Please enter an email address");
        } else {
            eTEmail.setError(null);
        }

        if (eTaddress.getText().toString().toString().isEmpty()){
            eTaddress.setError("Please enter your address");
        } else {
            eTaddress.setError(null);
        }


        if (eTphone.getText().toString().trim().isEmpty()){
            eTphone.setText("Please enter your phone number");
        } else {
            eTphone.setError(null);
        }



    }
public boolean isKeysFilled(){
    if (!etFullName.getText().toString().trim().isEmpty() &&
            !eTphone.getText().toString().trim().isEmpty() &&
            !eTaddress.getText().toString().trim().isEmpty() &&
            !eTEmail.getText().toString().trim().isEmpty() &&
            !eTBusStop.getText().toString().trim().isEmpty()){
        return  true;
    } else {
        return false;
    }

}
}
