package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @Column(name = "consumer_id")
    private Integer consumer_id;


    public User(){}

    public User(String username, String password, boolean enabled, Integer consumer_id)
    {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.consumer_id = consumer_id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public Integer getConsumer_id()
    {
        return consumer_id;
    }

    public void setConsumer_id(Integer consumer_id)
    {
        this.consumer_id = consumer_id;
    }
}
