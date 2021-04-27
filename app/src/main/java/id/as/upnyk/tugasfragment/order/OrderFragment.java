package id.as.upnyk.tugasfragment.order;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.as.upnyk.tugasfragment.R;
import id.as.upnyk.tugasfragment.detail.DetailOrderActivity;

public class OrderFragment extends Fragment {

    Button btnOrderWithData, btnOrderWithPhone;
    EditText etOrderName, etOrderQuantity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnOrderWithData = view.findViewById(R.id.btn_order_with_data);
        btnOrderWithPhone = view.findViewById(R.id.btn_order_with_phone);
        etOrderName = view.findViewById(R.id.et_order_name);
        etOrderQuantity = view.findViewById(R.id.et_order_quantity);

        btnOrderWithData.setOnClickListener(v -> {
            if (!etOrderName.getText().toString().isEmpty() && !etOrderQuantity.getText().toString().isEmpty()){
                Intent tdata = new Intent(getActivity(), DetailOrderActivity.class);
                tdata.putExtra("et_name", etOrderName.getText().toString());
                tdata.putExtra("et_quantity", Integer.parseInt(etOrderQuantity.getText().toString()));
                startActivity(tdata);
            } else {
                Toast.makeText(getActivity(), "Please input data first!",Toast.LENGTH_SHORT).show();
            }
        });
        btnOrderWithPhone.setOnClickListener(v -> {
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 081277112843"));
            startActivity(call);
        });
    }
}