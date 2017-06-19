package com.jp.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmDetailsFragment extends Fragment {
   @BindView(R.id.idTVBusStop)TextView tvBustop;
    @BindView(R.id.idTVbillPrice) TextView tvBillPrice;
    @BindView(R.id.idTVdeliveryAddress) TextView tvDeliveryAddress;
    @BindView(R.id.idTVfullName) TextView tvFullname;
    @BindView(R.id.idTVphoneNum) TextView tvPhone;
    @BindView(R.id.idTVemail) TextView tvEmail;
    @BindView(R.id.idrecyclerViewConfirm) RecyclerView recyclerView;
    @BindView(R.id.idbuttonProceede) Button btnProceed;
    FoodCartAdapter foodCartAdapter;
    LinearLayoutManager linearLayoutManager;

    public ConfirmDetailsFragment() {
        // Required empty public constructor
    }
    public static ConfirmDetailsFragment newInstance(String fullName,
                                                     String email,
                                                     String phoneNum,
                                                     String busStop,
                                                     String address){
        ConfirmDetailsFragment confirmDetailsFrag = new ConfirmDetailsFragment();
        Bundle args = new Bundle();
        args.putString("FULLNAME", fullName);
        args.putString("EMAIL", email);
        args.putString("PHONE", phoneNum);
        args.putString("BUSSTSOP",busStop);
        args.putString("ADDRESS", address);
        confirmDetailsFrag.setArguments(args);

        return confirmDetailsFrag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_details, container, false);
        ButterKnife.bind(this, view);
        String fullName = getArguments().getString("FULLNAME", "fullname");
        String email = getArguments().getString("EMAIL","email");
        String phoneNum = getArguments().getString("PHONE", "phone");
        String busStop = getArguments().getString("BUSSTOP", "Bus Stop");
        String address = getArguments().getString("ADDRESS", "address");
        int billprice = Food.getCartPrice();
        linearLayoutManager = new LinearLayoutManager(getActivity());
        foodCartAdapter = new FoodCartAdapter(getActivity().getApplicationContext(), Food.getFoodCartList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(foodCartAdapter);
        recyclerView.setHasFixedSize(true);

        tvBillPrice.setText("N:"+billprice);
        tvBustop.setText(busStop);
        tvDeliveryAddress.setText(address);
        tvEmail.setText(email);
        tvPhone.setText(phoneNum);
        tvFullname.setText(fullName);
        // Inflate the layout for this fragment
        return  view;
    }

}
