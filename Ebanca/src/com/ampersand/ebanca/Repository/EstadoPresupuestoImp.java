package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.EstadoPresupuesto;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class EstadoPresupuestoImp extends Abs<EstadoPresupuesto> implements DAO<EstadoPresupuesto>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public EstadoPresupuestoImp() {
        super(EstadoPresupuesto.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
