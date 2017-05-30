package dao.impl;

import dao.AuthorityDao;
import model.Authority;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuthorityDaoImpl implements AuthorityDao
{
    @Autowired
    private SessionFactory session;

    @Override
    public void addAuthority(Authority authority)
    {
        session.getCurrentSession().save(authority);
    }
}
