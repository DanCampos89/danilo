package com.br.project1.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.project1.model.usuario;
import com.br.project1.util.GenericDAO;

@ViewScoped
@ManagedBean(name="usuario")
public class usuarioBean extends GenericDAO<usuario> {
	

}
