package model;


import javax.persistence.*;

@Entity
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
}
