package com.example.fourthlab.bookdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fourthlab.R;
import com.example.fourthlab.domain.Book;
import com.example.fourthlab.domain.BookRepository;
import com.example.fourthlab.domain.Cart;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author anechaev
 * @since 16.01.2022
 */
public class BookDetailFragment extends Fragment {
    public static final String BOOK_ID_KEY = "BookId";
    private final BookRepository bookRepository = BookRepository.getInstance();

    private int bookId = 0;
    private Button addButton;
    private Button removeButton;

    public BookDetailFragment() {
        // Required empty public constructor
    }

    public static BookDetailFragment newInstance(int bookId) {
        BookDetailFragment fragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putInt(BOOK_ID_KEY, bookId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookId = getArguments().getInt(BOOK_ID_KEY, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_detail, container, false);
        Book book = bookRepository.getBook(bookId);
        TextView nameTextView = view.findViewById(R.id.name_text_view);
        nameTextView.setText(book.getName());
        TextView descriptionTextView = view.findViewById(R.id.description_text_view);
        descriptionTextView.setText(book.getDescription());
        addButton = view.findViewById(R.id.fragmentBookDetailAddToCart);
        removeButton = view.findViewById(R.id.fragmentBookDetailRemoveFromCart);
        addButton.setOnClickListener(v -> {
            Cart.getInstance().addBook(book);
        });
        removeButton.setOnClickListener(v -> {
            Cart.getInstance().removeBook(book);
        });
        return view;
    }

}