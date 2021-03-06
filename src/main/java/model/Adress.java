package model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "adresses")
public class Adress
{
    @Id
    @Column
    @GeneratedValue
    private Integer adress_id;

    @Column
    @NotBlank
    @Length(min = 2, max = 25)
    private String country;

    @Column
    @NotBlank
    @Length(min = 2, max = 25)
    private String city;

    @Column
    @NotBlank
    @Length(min = 2, max = 25)
    private String street;

    @Column
    @Min(0)
    private Integer number;

    @Column(name = "post_code")
    @NotBlank
    @Length(min = 2, max = 8)
    private String postCode;

    @OneToMany
    @JoinColumn(name = "consumer_id")
    private List<Consumer> list;


    public List<Consumer> getList()
    {
        return list;
    }

    public void setList(List<Consumer> list)
    {
        this.list = list;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        String str = country.trim();
        if (!str.isEmpty())
            this.country = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.country = "";
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        String str = city.trim();
        if (!str.isEmpty())
            this.city = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.city = "";
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        String str = street.trim();
        if (!str.isEmpty())
            this.street = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.street = "";

    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        String str = postCode.trim();
        if (!str.isEmpty())
            this.postCode = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.postCode = "";
    }


    @Override
    public String toString()
    {
        return "Adress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
