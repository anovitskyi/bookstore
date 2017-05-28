package model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "adresses")
public class Adress
{
    @Id
    @Column(name = "adress_id")
    private Integer id;

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
    @NotBlank
    @Min(0)
    private Integer number;

    @Column(name = "post_code")
    @NotBlank
    @Length(min = 2, max = 6)
    private String postCode;

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        String str = country.trim();
        if (!str.isEmpty())
            this.country = country;
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
            this.city = city;
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
            this.street = street;
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
            this.postCode = postCode;
        else
            this.postCode = "";
    }
}
