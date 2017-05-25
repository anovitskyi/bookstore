package model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Locale;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer id;

    @Column
    @NotBlank
    @Length(min = 3, max = 35)
    private String autor;

    @Column
    @NotBlank
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

    @Transient
    private MultipartFile img;

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
        String str = autor.trim();
        this.autor = str.substring(0,1).toUpperCase() + str.substring(1);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        String str = name.trim();
        this.name = str.substring(0,1).toUpperCase() + str.substring(1);
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
        if (desc != null && desc.length() > 2)
        {
            String str = desc.trim();
            this.desc = str.substring(0,1).toUpperCase() + str.substring(1);
        }
        else
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

    public MultipartFile getImg()
    {
        return img;
    }

    public void setImg(MultipartFile img)
    {
        this.img = img;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", unitsInStock=" + unitsInStock +
                '}';
    }
}
