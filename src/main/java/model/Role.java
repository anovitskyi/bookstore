package model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role
{
    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "role_name")
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
