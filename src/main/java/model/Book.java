package model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "author")
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

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> list;

    public String getAutor()
    {
        return autor;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setAutor(String autor)
    {
        String str = autor.trim().toLowerCase();
        if (!str.isEmpty())
            this.autor = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.autor = "";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        String str = name.trim();
        if (!str.isEmpty())
            this.name = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.name = "";
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
        String str = desc.trim();
        if (!str.isEmpty())
            this.desc = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.desc = "";
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

}
