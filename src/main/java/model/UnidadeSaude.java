package model;

import java.util.ArrayList;
import java.util.Iterator;

// TODO: Auto-generated Javadoc
/**
 * Classe UnidadeSaude
 * Responsavel por representar uma unidade de saúde.
 */

public class UnidadeSaude{
	
	/** The nome. */
	private String nome;
	
	/** The endereco. */
	private String endereco;
	
	/** The bairro. */
	private String bairro;
	
	/** The id. */
	private int id;
	
	/** The especialidades. */
	private ArrayList<String> especialidades;

	
	/**
	 * Metodo Construtor Com todos os parametros da classe.
	 *
	 * @param nome Nome da unidade de saude.
	 * @param endereco Endereço da unidade de sa�de.
	 * @param bairro Bairro da unidade de saude.
	 * @param id id da unidade de saude.
	 * @param especialidades Especialidades presentes na unidade de saude.
	 */
	public UnidadeSaude(String nome, String endereco, String bairro, int id, ArrayList<String> especialidades) {
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.id = id;
		this.especialidades = especialidades;
	}
	
	
	/**
	 * Metodo Construtor sem ID da classe.
	 *
	 * @param nome Nome da unidade de saude.
	 * @param endereco Endereço da unidade de saude.
	 * @param bairro Bairro da unidade de saude.
	 * @param especialidades Especialidades presentes na unidade de saude.
	 */
	public UnidadeSaude(String nome, String endereco, String bairro, ArrayList<String> especialidades) {
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.especialidades = especialidades;
	}
	
	/**
	 * Metodo Construtor Padrão da classe.
	 *
	 */
	public UnidadeSaude()
	{
		this.nome = "";
		this.endereco = "";
		this.bairro = "";
		this.id = -1;
		this.especialidades = new ArrayList<String>();
	}

	
	/**
	 * Metodo get do atributo nome.
	 *
	 * @return Retorna o valor atual do atributo nome.
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * Metodo set do atributo nome .
	 *
	 * @param nome tem como um parametro o nome a ser setado no atributo
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 	/**
	 * Metodo get do atributo endereco.
	 *
	 * @return Retorna o valor atual do atributo endereco.
	 */
	public String getEndereco() {
		return endereco;
	}


	/**
	 * Metodo set do atributo endereco.
	 *
	 * @param endereco Novo valor do atributo endereco.
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	/**
	 * Metodo get do atributo bairro.
	 *
	 * @return Retorna o valor atual do atributo bairro.
	 */
	public String getBairro() {
		return bairro;
	}


	/**
	 * 	/**
	 * Metodo get do atributo id.
	 *
	 * @return Retorna o valor atual do atributo id.
	 */
	public int getId() {
		return id;
	}


	/**
	 * Metodo set do atributo id.
	 *
	 * @param id Novo valor do atributo id.
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * Metodo set do atributo bairro.
	 *
	 * @param bairro Novo valor do atributo bairro.
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Metodo get do atributo especialidades.
	 *
	 * @return Retorna o valor atual do atributo especialidades.
	 */
	public ArrayList<String> getEspecialidades() {
		return especialidades;
	}


	/**
	 * Metodo set do atributo especialidades.
	 *
	 * @param especialidades Novo valor do atributo especialidades.
	 */
	public void setEspecialidades(ArrayList<String> especialidades) {
		this.especialidades = especialidades;
	}
	
	/**
	 * Metodo para adicionar uma nova especialidade a unidade de saude.
	 *
	 * @param especialidade Nova especialidade a ser inserida no atributo ArrayList especialidades.
	 */
	public void addEspecialidade(String especialidade){
		especialidades.add(especialidade);
	}
	
	/**
	 * Metodo para juntar todas as informações da unidade de saúde em uma string.
	 *
	 * @return Retorna uma string contendo todos os atributos da classe.
	 */
	@Override
	public String toString(){
		
		String atributos = "";

		atributos += "ID: " + this.id + "\n";
		atributos += "Nome: " + this.nome + "\n";
		atributos += "Endereco: " + this.endereco + "\n";
		atributos += "Bairro: " + this.bairro + "\n";
		atributos += "Especialidades: ";
		
		Iterator<String> inter1 = especialidades.iterator();
		
		boolean primeiro = true;
		
		while (inter1.hasNext()){
			
			if( primeiro ){
				atributos += inter1.next();
				primeiro = false;
			}
			else
				atributos +=  ", " + inter1.next();
			
		}
		
		return atributos;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		
		boolean result = false;
		 
		if (obj instanceof UnidadeSaude){
			UnidadeSaude c = (UnidadeSaude) obj;
			result = c.getId() == this.getId();
		}
	  
		return result;
	}
	  
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getId() ^ 7;
	}
}
