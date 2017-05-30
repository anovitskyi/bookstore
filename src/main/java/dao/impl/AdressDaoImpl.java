package dao.impl;


import dao.AdressDao;
import model.Adress;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdressDaoImpl implements AdressDao
{
    @Autowired
    private SessionFactory session;

    @Override
    public Adress get(Adress adress)
    {
        return (Adress) session.getCurrentSession().createQuery("from model.Adress where country = ? and city = ? and street = ? and number = ? and  post_code = ?")
                .setParameter(0, adress.getCountry())
                .setParameter(1, adress.getCity())
                .setParameter(2, adress.getStreet())
                .setParameter(3, adress.getNumber())
                .setParameter(4, adress.getPostCode())
                .uniqueResult();
    }
}
