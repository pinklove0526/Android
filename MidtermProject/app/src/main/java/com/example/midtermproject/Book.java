package com.example.midtermproject;

public class Book
{
    private int id;
    private String name;
    private String author;
    private int pages;
    private String imageUrl;
    private String longDesc;

    public Book(int id, String name, String author, int pages, String imageUrl, String longDesc)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.longDesc = longDesc;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getPages()
    {
        return pages;
    }

    public void setPages()
    {
        this.pages = pages;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl()
    {
        this.imageUrl = imageUrl;
    }

    public String getLongDesc()
    {
        return longDesc;
    }

    public void setLongDesc(String longDesc)
    {
        this.longDesc = longDesc;
    }

    @Override
    public String toString()
    {
        return "Book{" + "id=" + id + ", name=" + name + '\'' + ", author=" + author + '\'' + ", pages=" + pages + '\'' + ", imageUrl=" + imageUrl + '\'' + ", longDesc=" + longDesc + '\'' + '}';
    }
}