package model;


import javax.persistence.*;

@Entity
@Table(name=  "authorities")
public class Authority
{
    @Id
    @GeneratedValue
    @Column(name = "authority_id")
    private Integer id;

    @Column(name = " username")
    private  String username;

    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Role authority;

    public Authority(){}

    public Authority(String username, Role authority)
    {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Role getAuthority()
    {
        return authority;
    }

    public void setAuthority(Role authority)
    {
        this.authority = authority;
    }
}
