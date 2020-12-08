package com.example.midtermproject_beta;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils
{
    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String FAVORITE_BOOKS = "favorite_books";
    private static Utils instance;
    private SharedPreferences sharedPreferences;

    private Utils(Context context)
    {
        sharedPreferences = context.getSharedPreferences("alter_db", Context.MODE_PRIVATE);
        if (null == getAllBooks())
            initData();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == getAlreadyReadBooks())
        {
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.apply();
        }

        if (null == getWantToReadBooks())
        {
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.apply();
        }

        if (null == getFavoriteBooks())
        {
            editor.putString(FAVORITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.apply();
        }
    }

    private void initData()
    {
        ArrayList<Book> books = new ArrayList<>();
        String des1 = "The book is narrated by Nick Carraway, a Yale University graduate from the Midwest who moves to New York after World War I to pursue a career in bonds. He recounts the events of the summer he spent in the East two years later, reconstructing his story through a series of flashbacks not always told in chronological order.\n" + "\n" + "In the spring of 1922, Nick takes a house in the fictional village of West Egg on Long Island, where he finds himself living among the colossal mansions of the newly rich. Across the water in the more refined village of East Egg live his cousin Daisy and her brutish, absurdly wealthy husband Tom Buchanan. Early in the summer Nick goes over to their house for dinner, where he also meets Jordan Baker, a friend of Daisy’s and a well-known golf champion, who tells him that Tom has a mistress in New York City. In a private conversation, Daisy confesses to Nick that she has been unhappy. Returning to his house in West Egg, he catches sight of his neighbour, Jay Gatsby, standing alone in the dark and stretching his arms out to a green light burning across the bay at the end of Tom and Daisy’s dock.";
        String des2 = "Hobbits, a race of small humanlike creatures, characteristically value peace, simplicity, and cozy homes yet are capable of incredible feats of courage and resourcefulness. The unwilling hero of The Hobbit, Bilbo Baggins, is persuaded to join Thorin and his 12 dwarfs to recover their stolen treasure, which is being guarded by the dragon Smaug. During the expedition, Bilbo finds a magical ring that renders the wearer invisible, which figures prominently in The Lord of the Rings. The Hobbit is the story of Bilbo’s maturing from a seeker of warmth and comforts to a fighter, however humble, for the greater good. The Hobbit was adapted in various forms, notably as an animated television movie (1977) and as a series of live-action films (2012, 2013) helmed by New Zealand director Peter Jackson. Jackson’s earlier cinematic renderings of The Lord of the Rings (2001, 2002, 2003) were widely regarded as masterful.";
        String des3 = "High in the Canadian Rockies is a small limestone quarry formed 530 million years ago called the Burgess Shale. It hold the remains of an ancient sea where dozens of strange creatures lived in a forgotten corner of evolution preserved in awesome detail. In this book Stephen Jay Gould explores what the Burgess Shale tells us about evolution and the nature of history.";
        String des4 = "The best-selling science book ever published in the English language, Cosmos is a magnificent overview of the past, present, and future of science. Brilliant and provocative, it traces today's knowledge and scientific methods to their historical roots, blending science and philosophy in a wholly energetic and irresistible way.";
        String des5 = "The Call of Cthulhu is probably Lovecraft’s most influential story, serving as the basis for his epic “Old Ones” mythos. It centers around an ancient dragon-sea monster hybrid that implants itself subconsciously into human minds, driving them slowly insane. The cultists who worship Cthulhu commit ritual killings and chant in tongues. As more details of the creature and its history come to light, our narrator realizes that no one can possibly be safe from such a powerful entity — not even himself.";
        books.add(new Book(1, "The Great Gatsby", "F.Scott Fitzgerald", 218, "https://d28hgpri8am2if.cloudfront.net/book_images/onix/cvr9780743246392/the-great-gatsby-9780743246392_hr.jpg", des1));
        books.add(new Book(2, "The Hobbit", "J.R.R.Tolkien", 310, "https://images-na.ssl-images-amazon.com/images/I/A1E+USP9f8L.jpg", des2));
        books.add(new Book(3, "Wonderful Life", "Stephen Jay Gould", 352, "http://ecx.images-amazon.com/images/I/51%2BMbf0EKLL.jpg", des3));
        books.add(new Book(4, "Cosmos", "Carl Sagan", 396, "http://ecx.images-amazon.com/images/I/51SX54fcT-L.jpg", des4));
        books.add(new Book(5, "The Call of Cthulhu and Other Weird Stories", "H.P.Lovecraft", 420, "https://m.media-amazon.com/images/I/41BunCasgTL.jpg", des5));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.apply();
    }

    public static Utils getInstance(Context context)
    {
        if (null != instance)
            return instance;
        else
        {
            instance = new Utils(context);
            return instance;
        }
    }

    public ArrayList<Book> getAllBooks()
    {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks()
    {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getWantToReadBooks()
    {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getFavoriteBooks()
    {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS, null), type);
        return books;
    }

    public Book getBookById(int id)
    {
        ArrayList<Book> books = getAllBooks();
        if (null != books)
        {
            for (Book b: books)
            {
                if (b.getId() == id)
                    return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book)
    {
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books)
        {
            if (books.add(book))
            {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.apply();
                return true;
            }
        }
        return false;
    }

    public boolean addToWantToRead(Book book)
    {
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books)
        {
            if (books.add(book))
            {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.apply();
                return true;
            }
        }
        return false;
    }

    public boolean addToFavorite(Book book)
    {
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books)
        {
            if (books.add(book))
            {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.apply();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Book book)
    {
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books)
        {
            for (Book b: books)
            {
                if (b.getId() == book.getId())
                    if (books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.apply();
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean removeFromWantToRead(Book book)
    {
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books)
        {
            for (Book b: books)
            {
                if (b.getId() == book.getId())
                    if (books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.apply();
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean removeFromFavorites(Book book)
    {
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books)
        {
            for (Book b: books)
            {
                if (b.getId() == book.getId())
                    if (books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.apply();
                        return true;
                    }
            }
        }
        return false;
    }
}