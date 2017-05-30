package model;


import javax.persistence.*;

@Entity
public class CartItem
{
    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column
    private int quantity;

    @Column
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Cart getCart()
    {
        return cart;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }
}
