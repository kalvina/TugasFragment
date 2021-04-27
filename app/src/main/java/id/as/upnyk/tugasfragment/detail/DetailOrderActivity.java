package id.as.upnyk.tugasfragment.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.as.upnyk.tugasfragment.R;

public class DetailOrderActivity extends AppCompatActivity {

    TextView tvConfirm;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        tvConfirm = findViewById(R.id.tv_confirm);
        btnBack = findViewById(R.id.btn_back_detail);

        String name = getIntent().getStringExtra("et_name");
        int quantity = getIntent().getIntExtra("et_quantity",0);

        String result = "Thank you \n You're done to order :\n"+name+"\n\n In Quantity : "+quantity;
        tvConfirm.setText(result);

        btnBack.setOnClickListener(v -> finish());

    }
}