package model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name= "consumers")
public class Consumer
{
    @Id
    @Column(name = "consumer_id")
    private Integer id;

    @Column(name = "first_name")
    @NotBlank
    @Length(min = 3, max = 30)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Length(min = 3, max = 30)
    private String lastName;

    @Column
    @Min(0)
    private Integer age;

    @Column
    @Email
    private String email;

    @Column
    @NotBlank
    @Length(min = 3, max = 30)
    private String username;

    @Column
    @NotBlank
    @Length(min = 3, max = 30)
    private String password;

    @Column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Adress adress;


    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        String str = firstName.trim().toLowerCase();
        if (!str.isEmpty())
            this.firstName = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.firstName = "";
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        String str = lastName.trim().toLowerCase();
        if (!str.isEmpty())
            this.lastName = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.lastName = "";
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        String str = username.trim();
        if (!str.isEmpty())
            this.username = username;
        else
            this.username = "";
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        String str = password.trim();
        if (!str.isEmpty())
            this.password = password;
        else
            this.password = "";
    }

    public Adress getAdress()
    {
        return adress;
    }

    public void setAdress(Adress adress)
    {
        this.adress = adress;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
}
