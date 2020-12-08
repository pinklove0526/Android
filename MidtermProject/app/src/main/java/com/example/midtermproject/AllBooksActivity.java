package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllBooksActivity extends AppCompatActivity
{
    private RecyclerView bookRecyclerView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        adapter = new BookRecViewAdapter(this, "allBooks");
        bookRecyclerView = findViewById(R.id.booksRecyclerView);
        bookRecyclerView.setAdapter(adapter);
        bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance(this).getAllBooks());
    }
}