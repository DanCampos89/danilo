package com.br.project1.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.project1.model.veiculo;
import com.br.project1.util.GenericDAO;

@ViewScoped
@ManagedBean(name="veiculo")
public class veiculoBean extends GenericDAO<veiculo> {

}
