package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Gerencia;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class GerenciaImp extends Abs<Gerencia> implements DAO<Gerencia>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public GerenciaImp() {
        super(Gerencia.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
