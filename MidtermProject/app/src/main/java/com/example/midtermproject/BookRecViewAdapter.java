package com.example.midtermproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.example.midtermproject.BookActivity.BOOK_ID_KEY;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder>
{
    private static final String TAG = "BookRecViewAdapter";
    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    public BookRecViewAdapter(Context mContext, String parentActivity)
    {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_books, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {
        Log.d(TAG, "onBindViewHolder: ");
        holder.txtName.setText(books.get(position).getName());
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtPages.setText(String.valueOf(books.get(position).getPages()));
        Glide.with(mContext).asBitmap().load(books.get(position).getImageUrl()).into(holder.imgBook);
        holder.parent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(mContext, BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, books.get(position).getId());
                mContext.startActivity(intent);
            }
        });
        if (parentActivity.equals("allBooks"))
            holder.txtDelete.setVisibility(View.GONE);
        else if (parentActivity.equals("alreadyRead"))
        {
            holder.txtDelete.setVisibility(View.VISIBLE);
            holder.txtDelete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setMessage("Do you want to delete " + books.get(position).getName() + " ?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            if (Utils.getInstance(mContext).removeFromAlreadyRead(books.get(position)))
                            {
                                Toast.makeText(mContext, "Book removed", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                        }
                    });
                    builder.create().show();
                }
            });
        }
        else if (parentActivity.equals("wantToRead"))
        {
            holder.txtDelete.setVisibility(View.VISIBLE);
            holder.txtDelete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setMessage("Do you want to delete " + books.get(position).getName() + " ?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            if (Utils.getInstance(mContext).removeFromWantToRead(books.get(position)))
                            {
                                Toast.makeText(mContext, "Book removed", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                        }
                    });
                    builder.create().show();
                }
            });
        }
        else if (parentActivity.equals("favoriteBooks"))
        {
            holder.txtDelete.setVisibility(View.VISIBLE);
            holder.txtDelete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setMessage("Do you want to delete " + books.get(position).getName() + " ?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            if (Utils.getInstance(mContext).removeFromFavorites(books.get(position)))
                            {
                                Toast.makeText(mContext, "Book removed", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                        }
                    });
                    builder.create().show();
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books)
    {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;
        private TextView txtAuthor;
        private TextView txtPages;
        private TextView txtDelete;
        public ViewHolder (@NonNull View itemView)
        {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imageBook);
            txtName = itemView.findViewById(R.id.txtBookName);
            txtAuthor = itemView.findViewById(R.id.author);
            txtPages = itemView.findViewById(R.id.pages);
            txtDelete = itemView.findViewById(R.id.deleteText);
        }
    }
}
