package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Banco;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class BancoImp extends Abs<Banco> implements DAO<Banco>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public BancoImp() {
        super(Banco.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
