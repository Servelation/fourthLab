package com.example.fourthlab.bookdetail;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fourthlab.OnFragmentItemClickListener;
import com.example.fourthlab.domain.Book;
import com.example.fourthlab.domain.BookRepository;


/**
 * @author anechaev
 * @since 16.01.2022
 */
public class BookListFragment extends ListFragment {
    private final BookRepository mBookRepository = BookRepository.getInstance();


    private OnFragmentItemClickListener clickListener;

    public BookListFragment() {
        // Required empty public constructor
    }

    public static BookListFragment newInstance(String param1, String param2) {
        BookListFragment fragment = new BookListFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentItemClickListener) {
            clickListener = (OnFragmentItemClickListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<Book> adapter = new ArrayAdapter<>(
            inflater.getContext(), android.R.layout.simple_list_item_1, mBookRepository.getBooks());
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        clickListener = null;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (clickListener != null) {
            clickListener.onFragmentItemClick((int) id);
        }
    }
}