package model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer id;

    @Column
    @Length(min = 3, max = 35)
    private String autor;

    @Column
    @Length(min = 3, max = 25)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "description")
    private String desc;

    @Column
    @Min(0)
    private double price;

    @Column(name = "units")
    @Min(0)
    private int unitsInStock;

    @Column
    @Length(min = 3, max = 50)
    private String img;

    public String getAutor()
    {
        return autor;
    }

    public Integer getId()
    {
        return id;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Genre getGenre()
    {
        return genre;
    }

    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getUnitsInStock()
    {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock)
    {
        this.unitsInStock = unitsInStock;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }
}
