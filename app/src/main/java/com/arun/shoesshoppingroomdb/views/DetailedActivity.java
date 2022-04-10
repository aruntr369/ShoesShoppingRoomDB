package com.arun.shoesshoppingroomdb.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.arun.shoesshoppingroomdb.R;
import com.arun.shoesshoppingroomdb.utils.model.ShoeCart;
import com.arun.shoesshoppingroomdb.utils.model.ShoeItem;
import com.arun.shoesshoppingroomdb.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    private ImageView shoeImageView;
    private TextView shoeNameTV, shoeBrandNameTV, shoePriceTV;
    private AppCompatButton addToCartBtn;
    private ShoeItem shoe;
    private CartViewModel viewModel;
    private List<ShoeCart> shoeCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        shoe = getIntent().getParcelableExtra("shoeItem");
        initializeVariables();

        if (shoe != null) {
            setDataToWidgets();
        }

    }

    private void setDataToWidgets() {
        shoeNameTV.setText(shoe.getShoeName());
        shoeBrandNameTV.setText(shoe.getShoeBrandName());
        shoePriceTV.setText(String.valueOf(shoe.getShoePrice()));
        shoeImageView.setImageResource(shoe.getShoeImage());
    }


        private void initializeVariables() {

        shoeCartList = new ArrayList<>();
        shoeImageView = findViewById(R.id.detailActivityShoeIV);
        shoeNameTV = findViewById(R.id.detailActivityShoeNameTv);
        shoeBrandNameTV = findViewById(R.id.detailActivityShoeBrandNameTv);
        shoePriceTV = findViewById(R.id.detailActivityShoePriceTv);
        addToCartBtn = findViewById(R.id.detailActivityAddToCartBtn);

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
    }
}