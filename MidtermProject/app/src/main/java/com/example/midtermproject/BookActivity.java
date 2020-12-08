package com.example.midtermproject;

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
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToFavorite, btnBuying;
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
            int bookId = intent.getIntExtra(BOOK_ID_KEY, - 1);
            if (bookId != -1)
            {
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if (null != incomingBook)
                {
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                    handleBuyBooks(incomingBook);
                }
            }
        }
    }

    private void handleBuyBooks(final Book book)
    {
        btnBuying.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (book.getId() == 1)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Great-Gatsby-F-Scott-Fitzgerald/dp/0743273567");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent");
                }
                if (book.getId() == 2)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Graphic-subtitle-illustrated-fantasy-classic/dp/0345445600/ref=sr_1_5?dchild=1&keywords=the+hobbit&qid=1602328295&s=books&sr=1-5");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent");
                }
                if (book.getId() == 3)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Wonderful-Life-Burgess-Nature-History/dp/039330700X/ref=sr_1_1?crid=2RZC5EHWZB9WM&dchild=1&keywords=wonderful+life+stephen+jay+gould&qid=1602328492&sprefix=wonderful+life+st%2Cstripbooks-intl-ship%2C370&sr=8-1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 4)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Cosmos-Carl-Sagan-2013-12-10/dp/B01NANDGAB/ref=sr_1_2?dchild=1&keywords=cosmos+carl+sagan+book&qid=1602328708&sr=8-2");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 5)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Call-Cthulhu-Other-Weird-Stories/dp/0143129457/ref=sr_1_1?crid=1D0BOBMYFWN07&dchild=1&keywords=the+call+of+cthulhu+and+other+weird+stories&qid=1602329656&sprefix=the+call+of+c%2Caps%2C364&sr=8-1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 6)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Miserables-Signet-Classics-Victor-Hugo/dp/045141943X/ref=sr_1_1?crid=1XOHCCY88D55W&dchild=1&keywords=les+miserables&qid=1602337642&s=books&sprefix=les%2Cstripbooks-intl-ship%2C749&sr=1-1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 7)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Thrones-Clash-Kings-Swords-Dragons/dp/0345535529/ref=sr_1_1?crid=N4EF0BYBOEKG&dchild=1&keywords=game+of+thrones&qid=1602337683&s=books&sprefix=game%2Cstripbooks-intl-ship%2C367&sr=1-1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 8)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Dune-Chronicles-Frank-Herbert-1996-06-01/dp/B01JNWFH8U/ref=sr_1_4?dchild=1&keywords=dune&qid=1602337716&s=books&sr=1-4");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 9)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Novel-Stephen-King/dp/1501182099/ref=tmm_hrd_swatch_0?_encoding=UTF8&qid=1602337779&sr=1-1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 10)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Kill-Mockingbird-Harper-Lee/dp/0060935464/ref=sr_1_1?crid=150SOUWA574JI&dchild=1&keywords=to+kill+a+mockingbird&qid=1602337841&s=books&sprefix=to+kil%2Cstripbooks-intl-ship%2C366&sr=1-1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
                if (book.getId() == 11)
                {
                    Uri uri = Uri.parse("https://www.amazon.com/Quixote-Penguin-Classics-Cervantes-Saavedra/dp/0142437239/ref=sr_1_1?crid=263R7LG4HZ4EL&dchild=1&keywords=don+quixote&qid=1602337891&s=books&sprefix=don%2Cstripbooks-intl-ship%2C367&sr=1-1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });
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
                        Toast.makeText(BookActivity.this, book.getName() + " Added", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(BookActivity.this, book.getName() + " Added", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(BookActivity.this, book.getName() + " Added", Toast.LENGTH_SHORT).show();
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
        btnBuying = findViewById(R.id.button);
    }
}