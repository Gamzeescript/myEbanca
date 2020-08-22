package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Movimientos;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class MovimientosImp extends Abs<Movimientos> implements DAO<Movimientos>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public MovimientosImp() {
        super(Movimientos.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
