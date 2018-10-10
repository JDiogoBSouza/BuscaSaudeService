package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import model.UnidadeSaude;

//import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.core.Response;


/**
 * Class UnidadeSaudeDAO Definida para simular um Banco de dados.
 */
public class UnidadeSaudeDAO {
	
	/** The Constant unidadesSaude. */
	private static final List<UnidadeSaude> unidadesSaude = new ArrayList<UnidadeSaude>();	
	private static final AtomicInteger counter = new AtomicInteger(0);
	
	/**
	 * Retorna uma unidade de saude a partir do id que foi passado por parametro
	 *
	 * @param id the id
	 * @return result the result
	 */
	public synchronized static UnidadeSaude getById(int id) {
		UnidadeSaude result = null;
		
		for (UnidadeSaude unidade : unidadesSaude)
		{
			if (unidade.getId() == id)
			{
				result = unidade;
				break;
			}
		}
		
		return result;
	}
	
	private synchronized static int getIndex( int id )
	{
		int result = -1;
		
		for (UnidadeSaude unidade : unidadesSaude)
		{
			if (unidade.getId() == id)
			{
				result = unidadesSaude.indexOf(unidade);
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Operaçao feita para retornar a lista de unidades de saude composta no DAO
	 *
	 * @return the Lista de unidadesSaude
	 */
	public synchronized static List<UnidadeSaude> list() {
		return unidadesSaude;
	}
	
	/**
	 * Encontra uma unidade de saude espefica a parti de um criterio informado.
	 *
	 * @param name the criterio ( EX: nome, endereco, bairro )
	 * @param type the tipo selecionado do criterio selecionado a partir da interface
	 * @return the list de unidades de saude.
	 */
	public synchronized static List<UnidadeSaude> findByType(String name, int type) {
		List<UnidadeSaude> result = new ArrayList<UnidadeSaude>();
		
		switch (type) {
			case 1:
				// Nome
				for (UnidadeSaude unidade : unidadesSaude) {
					if (unidade.getNome() != null && unidade.getNome().toLowerCase().contains(name.toLowerCase()))
					{
						result.add(unidade);
					}
				}
			break;
			
			case 2:
				// Endereco
				for (UnidadeSaude unidade : unidadesSaude) {
					if (unidade.getEndereco() != null && unidade.getEndereco().toLowerCase().contains(name.toLowerCase()))
					{
						result.add(unidade);
					}
				}
			break;
			
			case 3:
				// Bairro
				for (UnidadeSaude unidade : unidadesSaude) {
					if (unidade.getBairro() != null && unidade.getBairro().toLowerCase().contains(name.toLowerCase()))
					{
						result.add(unidade);
					}
				}
			break;
			
			case 4:
				// Especialidade
				for (UnidadeSaude unidade : unidadesSaude) {
					for( String especialidade : unidade.getEspecialidades() )
					{
						if (especialidade != null && especialidade.toLowerCase().contains(name.toLowerCase()))
						{
							result.add(unidade);
							break;
						}
					}
				}
			break;
			
			default:
		}
		
		return result;
	}
	
	/**
	 * Adiciona uma unidade de saude no DAO
	 *
	 * @param unidade the unidade a ser adicionada no DAO
	 * @return the unidade saude
	 * @throws WebApplicationException the web application exception
	 */
	public synchronized static UnidadeSaude add(UnidadeSaude unidade)
	{
		unidadesSaude.add(unidade);
		unidade.setId( counter.getAndIncrement() );

		System.out.println("Adicionando Unidade: " + unidade.getId() );
		
		return unidade;
	}
	
	/**
	 * Atualiza  no DAO os dados de uma unidade de saude existente
	 *
	 * @param unidade the unidade de saude
	 * @param id the id
	 */
	public synchronized static void update(UnidadeSaude unidade, int id) {
		

		
		UnidadeSaude unidadeOld = getById( id );
		
		if( unidadeOld != null )
		{
			System.out.println("Atualizando Unidade com ID: " + id);
			
			unidadeOld.setNome( unidade.getNome() );
			unidadeOld.setEspecialidades( unidade.getEspecialidades() );
			unidadeOld.setEndereco( unidade.getEndereco() );
			unidadeOld.setBairro( unidade.getBairro() );
		}
		else
		{
			System.out.println("Tentou Atualizar Unidade com ID: " + id + ", INEXISTENTE !");
		}

	}
	
	/**
	 * Deleta uma unidade de saude a partir do seu id passado como parÃ¢metro
	 *
	 * @param id the id
	 */
	public synchronized static void delete(int id) {
		
		if( !unidadesSaude.isEmpty())
		{
			int index = getIndex(id);
			
			if( index >= 0 )
			{
				System.out.println("Removendo Posicao: " + index);
				unidadesSaude.remove(index);
			}
			else
				System.out.println("Tentou Remover a Unidade com ID: "+ id + " da posição " + index + ", INEXISTENTE !");
		}
	}
}
