package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Estado;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class EstadoImp extends Abs<Estado> implements DAO<Estado>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public EstadoImp() {
        super(Estado.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
