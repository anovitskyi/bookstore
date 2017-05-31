package model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consumer_orders")
public class ConsumerOrder
{
    @Id
    @GeneratedValue
    @Column(name = "consumer_order_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @Column
    private Date date;

    @Column
    private Double price;

    public  ConsumerOrder(){}

    public ConsumerOrder(Cart cart, Consumer consumer, Date date, Double price)
    {
        this.cart = cart;
        this.consumer = consumer;
        this.date = date;
        this.price = price;
    }

    public Cart getCart()
    {
        return cart;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }

    public Consumer getConsumer()
    {
        return consumer;
    }

    public void setConsumer(Consumer consumer)
    {
        this.consumer = consumer;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}
