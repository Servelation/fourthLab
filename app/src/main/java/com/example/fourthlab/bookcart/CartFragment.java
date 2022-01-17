package com.example.fourthlab.bookcart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.fourthlab.R;
import com.example.fourthlab.bookdetail.BookDetailFragment;
import com.example.fourthlab.domain.Book;
import com.example.fourthlab.domain.Cart;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
    private static final int TEXT_VIEW_WIDTH = 295;
    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        LinearLayout layout = view.findViewById(R.id.CartLinearLayout);

        Set<Map.Entry<String, List<Book>>> entrySet = Cart.getInstance().getCartContent().entrySet();
        double globalSum = entrySet.stream().mapToDouble(entry -> {
            LinearLayout child = new LinearLayout(getContext());
            child.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
            child.setLayoutParams(params);

            TextView nameView = new TextView(getContext());
            nameView.setMaxLines(5);
            nameView.setWidth(TEXT_VIEW_WIDTH);
            nameView.setText(entry.getKey());
            child.addView(nameView);

            List<Book> books = entry.getValue();

            TextView priceView = new TextView(getContext());
            String price = Double.toString(books.get(0).getPrice());
            priceView.setText(price);
            priceView.setWidth(TEXT_VIEW_WIDTH);
            child.addView(priceView);

            TextView amountView = new TextView(getContext());
            String amount = Integer.toString(books.size());
            amountView.setText(amount);
            amountView.setWidth(TEXT_VIEW_WIDTH);
            child.addView(amountView);

            TextView sumView = new TextView(getContext());
            double sum = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();

            String sumStr = Double.toString(sum);
            sumView.setText(sumStr);
            sumView.setWidth(TEXT_VIEW_WIDTH);
            child.addView(sumView);

           layout.addView(child);
           return sum;
        }).sum();
        TextView globalSumTextView = view.findViewById(R.id.globalSumTextView);
        String globalSumText = Double.toString(globalSum);
        globalSumTextView.setText(globalSumText);
        return view;
    }
}