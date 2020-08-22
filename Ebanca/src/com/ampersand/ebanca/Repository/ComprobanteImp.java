package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Comprobante;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class ComprobanteImp extends Abs<Comprobante> implements DAO<Comprobante>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public ComprobanteImp() {
        super(Comprobante.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
