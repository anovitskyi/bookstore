package model;

public class CartItem
{
    private Book book;
    private int count;
    private double totalPrice;

    public CartItem()
    {
    }

    public CartItem(Book book, int count)
    {
        this.book = book;
        this.count = count;
        this.totalPrice = book.getPrice() * count;
    }
}
