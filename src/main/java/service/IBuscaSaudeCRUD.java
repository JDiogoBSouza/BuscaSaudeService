package service;

import java.util.List;

import model.UnidadeSaude;

public interface IBuscaSaudeCRUD
{
	public UnidadeSaude getUnidade(int id);
	public List<UnidadeSaude> list();
	public List<UnidadeSaude> findBy(String name, int type);
	public UnidadeSaude add(UnidadeSaude unidade);
	public void update(int id, UnidadeSaude unidade);
	public void delete(int id);
}
