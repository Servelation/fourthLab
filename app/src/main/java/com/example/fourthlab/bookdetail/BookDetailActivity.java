package com.example.fourthlab.bookdetail;

import static com.example.fourthlab.bookdetail.BookDetailFragment.BOOK_ID_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.fourthlab.MainActivity;
import com.example.fourthlab.R;
import com.example.fourthlab.bookcart.CartDetailActivity;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        final int bookId = getIntent().getIntExtra(BOOK_ID_KEY, -1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.BookDetailActivityRelativeLayout,
            BookDetailFragment.newInstance(bookId)).commit();
    }
}