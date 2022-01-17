package com.example.fourthlab.bookcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.fourthlab.R;
import com.example.fourthlab.bookdetail.BookDetailFragment;

public class CartDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail);
        getSupportFragmentManager().beginTransaction()
            .add(R.id.CartDetailActivityRelativeLayout, CartFragment.newInstance())
            .commit();
    }
}