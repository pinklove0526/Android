package com.example.midtermproject_beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity
{
    public static final String BOOK_ID_KEY = "bookId";
    private TextView description;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToFavorite, btnBuyBook;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initView();
        Intent intent = getIntent();
        if (null != intent)
        {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != 1)
            {
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if (null != incomingBook)
                {
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                    handleBuyBook(incomingBook);
                }
            }
        }
    }

    private void handleBuyBook(final Book book)
    {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getFavoriteBooks();
        boolean existInFavoriteBooks = false;
        for (Book b: wantToReadBooks)
        {
            if (b.getId() == book.getId())
                existInFavoriteBooks = true;
        }
        if (existInFavoriteBooks)
            btnBuyBook.setEnabled(false);
        else
        {
            btnBuyBook.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (book.getId() == 1)
                    {
                        Uri webpage = Uri.parse("https://www.amazon.com/Great-Gatsby-Wisehouse-Classics-Fitzgerald/dp/9176373908/ref=sr_1_3?dchild=1&keywords=the+great+gatsby&qid=1602042697&sr=8-3");
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        else
                            Log.d("ImplicitIntents", "Can't handle this intent!");
                    }
                    if (book.getId() == 2)
                    {
                        Uri webpage = Uri.parse("https://www.amazon.com/Hobbit-There-Author-Tolkien-September/dp/B01BRUTAKC/ref=sr_1_4?crid=3838ZK2RD3RO0&dchild=1&keywords=the+hobbit+tolkien&qid=1602042833&sprefix=the+hobbit+tolk%2Caps%2C621&sr=8-4");
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        else
                            Log.d("ImplicitIntents", "Can't handle this intent!");
                    }
                    if (book.getId() == 3)
                    {
                        Uri webpage = Uri.parse("https://www.amazon.com/Wonderful-Life-Burgess-Nature-History/dp/039330700X/ref=sr_1_1?dchild=1&keywords=wonderful+life+stephen&qid=1602043044&sr=8-1");
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        else
                            Log.d("ImplicitIntents", "Can't handle this intent!");
                    }
                    if (book.getId() == 4)
                    {
                        Uri webpage = Uri.parse("https://www.amazon.com/Cosmos-Possible-Worlds-Ann-Druyan/dp/1426219083/ref=sr_1_2?dchild=1&keywords=cosmos+book&qid=1602043138&sr=8-2");
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        else
                            Log.d("ImplicitIntents", "Can't handle this intent!");
                    }
                    if (book.getId() == 5)
                    {
                        Uri webpage = Uri.parse("https://www.amazon.com/Call-Cthulhu-Other-Weird-Stories/dp/0143129457/ref=sr_1_1?crid=2IODUFXS1HFMA&dchild=1&keywords=the+call+of+cthulhu+and+other+weird+stories&qid=1602042988&sprefix=the+call+of+cthulhu+and+ot%2Caps%2C413&sr=8-1");
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        else
                            Log.d("ImplicitIntents", "Can't handle this intent!");
                    }
                }
            });
        }
    }

    private void handleFavoriteBooks(final Book book)
    {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getFavoriteBooks();
        boolean existInFavoriteBooks = false;
        for (Book b: wantToReadBooks)
        {
            if (b.getId() == book.getId())
                existInFavoriteBooks = true;
        }
        if (existInFavoriteBooks)
            btnAddToFavorite.setEnabled(false);
        else
        {
            btnAddToFavorite.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (Utils.getInstance(BookActivity.this).addToFavorite(book))
                    {
                        Intent intent = new Intent(BookActivity.this, FavoriteActivity.class);
                        startActivity(intent);
                        Toast.makeText(BookActivity.this, book.getName() + " added", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(BookActivity.this, "Something wrong happened, please try again", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book)
    {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();
        boolean existInWantToReadBooks = false;
        for (Book b: wantToReadBooks)
        {
            if (b.getId() == book.getId())
                existInWantToReadBooks = true;
        }
        if (existInWantToReadBooks)
            btnAddToWantToRead.setEnabled(false);
        else
        {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (Utils.getInstance(BookActivity.this).addToWantToRead(book))
                    {
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                        Toast.makeText(BookActivity.this, book.getName() + " added", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(BookActivity.this, "Something wrong happened, please try again", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void handleAlreadyRead(final Book book)
    {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();
        boolean existInAlreadyReadBooks = false;
        for (Book b: alreadyReadBooks)
        {
            if (b.getId() == book.getId())
                existInAlreadyReadBooks = true;
        }
        if (existInAlreadyReadBooks)
            btnAddToAlreadyRead.setEnabled(false);
        else
        {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(book))
                    {
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                        Toast.makeText(BookActivity.this, book.getName() + " added", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(BookActivity.this, "Something wrong happened, please try again", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void setData(Book book)
    {
        description.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(bookImage);
    }

    private void initView()
    {
        description = findViewById(R.id.textView2);
        bookImage = findViewById(R.id.imageView2);
        btnAddToWantToRead = findViewById(R.id.button2);
        btnAddToAlreadyRead = findViewById(R.id.button3);
        btnAddToFavorite = findViewById(R.id.button4);
        btnBuyBook = findViewById(R.id.buybutton);
    }
}