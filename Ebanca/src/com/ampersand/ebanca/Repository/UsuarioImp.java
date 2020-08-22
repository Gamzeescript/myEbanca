package com.ampersand.ebanca.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ampersand.ebanca.Model.Usuario;
import com.ampersand.ebanca.utils.Abs;
import com.ampersand.ebanca.utils.DAO;

@Repository
@Transactional
public class UsuarioImp extends Abs<Usuario> implements DAO<Usuario>{
	
	@Autowired
    private SessionFactory sessionFactory;

    public UsuarioImp() {
        super(Usuario.class);
    }

    @Override
    public SessionFactory getSF() {
        return sessionFactory;
    }

}
