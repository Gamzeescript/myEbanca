package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Presupuesto;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class PresupuestoImp extends Abs<Presupuesto> implements DAO<Presupuesto>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public PresupuestoImp() {
        super(Presupuesto.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
