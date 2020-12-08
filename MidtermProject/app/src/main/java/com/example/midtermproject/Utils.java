package com.example.midtermproject;

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
        //TODO: create data
        ArrayList<Book> books = new ArrayList<>();
        String des1 = "The book is narrated by Nick Carraway, a Yale University graduate from the Midwest who moves to New York after World War I to pursue a career in bonds. He recounts the events of the summer he spent in the East two years later, reconstructing his story through a series of flashbacks not always told in chronological order.\n" + "\n" + "In the spring of 1922, Nick takes a house in the fictional village of West Egg on Long Island, where he finds himself living among the colossal mansions of the newly rich. Across the water in the more refined village of East Egg live his cousin Daisy and her brutish, absurdly wealthy husband Tom Buchanan. Early in the summer Nick goes over to their house for dinner, where he also meets Jordan Baker, a friend of Daisy’s and a well-known golf champion, who tells him that Tom has a mistress in New York City. In a private conversation, Daisy confesses to Nick that she has been unhappy. Returning to his house in West Egg, he catches sight of his neighbour, Jay Gatsby, standing alone in the dark and stretching his arms out to a green light burning across the bay at the end of Tom and Daisy’s dock.\n" + "\n";
        String des2 = "Hobbits, a race of small humanlike creatures, characteristically value peace, simplicity, and cozy homes yet are capable of incredible feats of courage and resourcefulness. The unwilling hero of The Hobbit, Bilbo Baggins, is persuaded to join Thorin and his 12 dwarfs to recover their stolen treasure, which is being guarded by the dragon Smaug. During the expedition, Bilbo finds a magical ring that renders the wearer invisible, which figures prominently in The Lord of the Rings. The Hobbit is the story of Bilbo’s maturing from a seeker of warmth and comforts to a fighter, however humble, for the greater good. The Hobbit was adapted in various forms, notably as an animated television movie (1977) and as a series of live-action films (2012, 2013) helmed by New Zealand director Peter Jackson. Jackson’s earlier cinematic renderings of The Lord of the Rings (2001, 2002, 2003) were widely regarded as masterful.";
        String des3 = "High in the Canadian Rockies is a small limestone quarry formed 530 million years ago called the Burgess Shale. It hold the remains of an ancient sea where dozens of strange creatures lived in a forgotten corner of evolution preserved in awesome detail. In this book Stephen Jay Gould explores what the Burgess Shale tells us about evolution and the nature of history.";
        String des4 = "The best-selling science book ever published in the English language, Cosmos is a magnificent overview of the past, present, and future of science. Brilliant and provocative, it traces today's knowledge and scientific methods to their historical roots, blending science and philosophy in a wholly energetic and irresistible way.";
        String des5 = "The Call of Cthulhu is probably Lovecraft’s most influential story, serving as the basis for his epic “Old Ones” mythos. It centers around an ancient dragon-sea monster hybrid that implants itself subconsciously into human minds, driving them slowly insane. The cultists who worship Cthulhu commit ritual killings and chant in tongues. As more details of the creature and its history come to light, our narrator realizes that no one can possibly be safe from such a powerful entity — not even himself.";
        String des6 = "The only completely unabridged paperback edition of Victor Hugo’s masterpiece—a sweeping tale of love, loss, valor, and passion.\n" + "\n" + "ntroducing one of the most famous characters in literature, Jean Valjean—the noble peasant imprisoned for stealing a loaf of bread—Les Misérables ranks among the greatest novels of all time. In it, Victor Hugo takes readers deep into the Parisian underworld, immerses them in a battle between good and evil, and carries them to the barricades during the uprising of 1832 with a breathtaking realism that is unsurpassed in modern prose.\n" + "\n" + "Within his dramatic story are themes that capture the intellect and the emotions: crime and punishment, the relentless persecution of Valjean by Inspector Javert, the desperation of the prostitute Fantine, the amorality of the rogue Thénardier, and the universal desire to escape the prisons of our own minds. Les Misérables gave Victor Hugo a canvas upon which he portrayed his criticism of the French political and judicial systems, but the portrait that resulted is larger than life, epic in scope—an extravagant spectacle that dazzles the senses even as it touches the heart.";
        String des7 = "Winter is coming. Such is the stern motto of House Stark, the northernmost of the fiefdoms that owe allegiance to King Robert Baratheon in far-off King’s Landing. There Eddard Stark of Winterfell rules in Robert’s name. There his family dwells in peace and comfort: his proud wife, Catelyn; his sons Robb, Brandon, and Rickon; his daughters Sansa and Arya; and his bastard son, Jon Snow. Far to the north, behind the towering Wall, lie savage Wildings and worse—unnatural things relegated to myth during the centuries-long summer, but proving all too real and all too deadly in the turning of the season.\n" + "\n" + "Yet a more immediate threat lurks to the south, where Jon Arryn, the Hand of the King, has died under mysterious circumstances. Now Robert is riding north to Winterfell, bringing his queen, the lovely but cold Cersei, his son, the cruel, vainglorious Prince Joffrey, and the queen’s brothers Jaime and Tyrion of the powerful and wealthy House Lannister - he first a swordsman without equal, the second a dwarf whose stunted stature belies a brilliant mind. All are heading for Winterfell and a fateful encounter that will change the course of kingdoms.\n" + "\n" + "Meanwhile, across the Narrow Sea, Prince Viserys, heir of the fallen House Targaryen, which once ruled all of Westeros, schemes to reclaim the throne with an army of barbarian Dothraki—whose loyalty he will purchase in the only coin left to him: his beautiful yet innocent sister, Daenerys.";
        String des8 = "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family tasked with ruling an inhospitable world where the only thing of value is the “spice” melange, a drug capable of extending life and enhancing consciousness. Coveted across the known universe, melange is a prize worth killing for...\n" + "\n" + "When House Atreides is betrayed, the destruction of Paul’s family will set the boy on a journey toward a destiny greater than he could ever have imagined. And as he evolves into the mysterious man known as Muad’Dib, he will bring to fruition humankind’s most ancient and unattainable dream.\n" + "\n" + "A stunning blend of adventure and mysticism, environmentalism and politics, Dune won the first Nebula Award, shared the Hugo Award, and formed the basis of what is undoubtedly the grandest epic in science fiction.";
        String des9 = "Welcome to Derry, Maine. It’s a small city, a place as hauntingly familiar as your own hometown. Only in Derry the haunting is real.\n" + "\n" + "They were seven teenagers when they first stumbled upon the horror. Now they are grown-up men and women who have gone out into the big world to gain success and happiness. But the promise they made twenty-eight years ago calls them reunite in the same place where, as teenagers, they battled an evil creature that preyed on the city’s children. Now, children are being murdered again and their repressed memories of that terrifying summer return as they prepare to once again battle the monster lurking in Derry’s sewers.\n" + "\n" + "Readers of Stephen King know that Derry, Maine, is a place with a deep, dark hold on the author. It reappears in many of his books, including Bag of Bones, Hearts in Atlantis, and 11/22/63. But it all starts with It.";
        String des10 = "One of the most cherished stories of all time, To Kill a Mockingbird has been translated into more than forty languages, sold more than forty million copies worldwide, served as the basis for an enormously popular motion picture, and was voted one of the best novels of the twentieth century by librarians across the country. A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice, t views a world of great beauty and savage inequities through the eyes of a young girl, as her father - a crusading local lawyer—risks everything to defend a black man unjustly accused of a terrible crime.";
        String des11 = "Don Quixote has become so entranced reading tales of chivalry that he decides to turn knight errant himself. In the company of his faithful squire, Sancho Panza, these exploits blossom in all sorts of wonderful ways. While Quixote's fancy often leads him astray—he tilts at windmills, imagining them to be giants—Sancho acquires cunning and a certain sagacity. Sane madman and wise fool, they roam the world together-and together they have haunted readers' imaginations for nearly four hundred years.\n" + "\n" + "With its experimental form and literary playfulness, Don Quixote has been generally recognized as the first modern novel. This Penguin Classics edition, with its beautiful new cover design, includes John Rutherford's masterly translation, which does full justice to the energy and wit of Cervantes's prose, as well as a brilliant critical introduction by Roberto Gonzalez Echevarriá";
        books.add(new Book(1, "The Great Gatsby", "F.Scott Fitzgerald", 218, "https://images-na.ssl-images-amazon.com/images/I/41iers+HLSL._SY344_BO1,204,203,200_.jpg", des1));
        books.add(new Book(2, "The Hobbit", "J.R.R.Tolkien", 310, "https://images-na.ssl-images-amazon.com/images/I/A1E+USP9f8L.jpg", des2));
        books.add(new Book(3, "Wonderful Life", "Stephen Jay Gould", 352, "https://images-na.ssl-images-amazon.com/images/I/51rpv9a7+bL._SX329_BO1,204,203,200_.jpg", des3));
        books.add(new Book(4, "Cosmos", "Carl Sagan", 396, "https://images-na.ssl-images-amazon.com/images/I/51dmVfsONaL._SX322_BO1,204,203,200_.jpg", des4));
        books.add(new Book(5, "The Call of Cthulhu and Other Weird Stories", "H.P.Lovecraft", 420, "https://images-na.ssl-images-amazon.com/images/I/51R2gi4w35L._SX329_BO1,204,203,200_.jpg", des5));
        books.add(new Book(6, "Les Misérables (Signet Classics)", "Victor Hugo", 1488, "https://images-na.ssl-images-amazon.com/images/I/51gFfl+xHxL._SX299_BO1,204,203,200_.jpg", des6));
        books.add(new Book(7, "Game of Thrones", "Georgae R. R. Martin", 5216, "https://images-na.ssl-images-amazon.com/images/I/61iRBvRYEcL._SY498_BO1,204,203,200_.jpg", des7));
        books.add(new Book(8, "Dune", "Frank Herbert", 896, "https://images-na.ssl-images-amazon.com/images/I/41UZeCEKOBL._SX331_BO1,204,203,200_.jpg", des8));
        books.add(new Book(9, "It", "Stephen King", 1138, "https://images-na.ssl-images-amazon.com/images/I/51tUePGFFlL._SX334_BO1,204,203,200_.jpg", des9));
        books.add(new Book(10, "To Kill a Mockingbird", "Harper Lee", 281, "https://images-na.ssl-images-amazon.com/images/I/51IXWZzlgSL._SX330_BO1,204,203,200_.jpg", des10));
        books.add(new Book(11, "Don Quixote", "Miguel de Cervantes", 863, "https://images-na.ssl-images-amazon.com/images/I/51nBHIQv6zL._SX332_BO1,204,203,200_.jpg", des11));
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
                editor.putString(FAVORITE_BOOKS, gson.toJson(books));
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
                {
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
                {
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
                {
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
        }
        return false;
    }
}
