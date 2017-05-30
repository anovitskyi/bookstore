package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart
{
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Integer id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> list;

    @OneToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @Column(name = "grant_total")
    private double grantTotal;

    public List<CartItem> getList()
    {
        return list;
    }

    public void setList(List<CartItem> list)
    {
        this.list = list;
    }

    public Consumer getConsumer()
    {
        return consumer;
    }

    public void setConsumer(Consumer consumer)
    {
        this.consumer = consumer;
    }

    public double getGrantTotal()
    {
        return grantTotal;
    }

    public void setGrantTotal(double grantTotal)
    {
        this.grantTotal = grantTotal;
    }
}
