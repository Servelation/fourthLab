package com.example.fourthlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.fourthlab.bookcart.CartDetailActivity;
import com.example.fourthlab.bookcart.CartFragment;
import com.example.fourthlab.bookdetail.BookDetailActivity;
import com.example.fourthlab.bookdetail.BookDetailFragment;

/**
 * @author anechaev
 * @since 16.01.2022
 */
public class MainActivity extends AppCompatActivity implements OnFragmentItemClickListener {
    private FrameLayout container = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.book_detail_container);
        if (container != null) {
            setFragment(BookDetailFragment.newInstance(0));
        }
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.book_detail_container, fragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_cart) {
            container = findViewById(R.id.book_detail_container);
            if (container != null) {// если альбомная ориентация
                Fragment fragment = CartFragment.newInstance();
                setFragment(fragment);
            } else {
                Intent intent = new Intent(this, CartDetailActivity.class);
                startActivity(intent);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentItemClick(int id) {
        if (container != null) { // если альбомная ориентация
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.book_detail_container, BookDetailFragment.newInstance(id))
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        } else {
            Intent intent = new Intent(this, BookDetailActivity.class);
            intent.putExtra(BookDetailFragment.BOOK_ID_KEY, id);
            startActivity(intent);
        }
    }
}