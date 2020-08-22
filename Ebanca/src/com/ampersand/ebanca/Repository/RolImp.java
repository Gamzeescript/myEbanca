package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Rol;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class RolImp extends Abs<Rol> implements DAO<Rol>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public RolImp() {
        super(Rol.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
