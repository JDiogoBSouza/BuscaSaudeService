package service;
  
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import dao.UnidadeSaudeDAO;
import model.UnidadeSaude;


/**
 * The Class BuscaSaudeCRUD.
 */
@Stateless
@Path("/")
public class BuscaSaudeCRUD implements IBuscaSaudeCRUD {
	
	/* (non-Javadoc)
	 * @see service.IBuscaSaudeCRUD#getUnidade(int)
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{unidadeId}")
	public UnidadeSaude getUnidade(@PathParam("unidadeId") int id) {
		UnidadeSaude result = UnidadeSaudeDAO.getById(id);
		
		return result;
	}
	  
	/* (non-Javadoc)
	 * @see service.IBuscaSaudeCRUD#list()
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UnidadeSaude> list() {
		return UnidadeSaudeDAO.list();
	}
	  
	/* (non-Javadoc)
	 * @see service.IBuscaSaudeCRUD#findByName(java.lang.String, int)
	 */
	@GET
	@Path("/find/{name}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UnidadeSaude> findBy(@PathParam("name") String name, @PathParam("type") int type) {
		List<UnidadeSaude> result = UnidadeSaudeDAO.findByType(name, type);
	  
		return result;
	}
	  
	/* (non-Javadoc)
	 * @see service.IBuscaSaudeCRUD#add(model.UnidadeSaude)
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UnidadeSaude add(UnidadeSaude unidade) {
		try
		{
			UnidadeSaudeDAO.add(unidade);
		}
		catch(WebApplicationException e)
		{
			e.printStackTrace();
		}
		
		return unidade;
	}
	  
	/* (non-Javadoc)
	 * @see service.IBuscaSaudeCRUD#update(int, model.UnidadeSaude)
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") int id, UnidadeSaude unidade){
		UnidadeSaudeDAO.update(unidade, id);
	}
	  
	/* (non-Javadoc)
	 * @see service.IBuscaSaudeCRUD#delete(int)
	 */
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) 
	{
		try
		{
			UnidadeSaudeDAO.delete(id);
		}
		catch(Exception e)
		{
			
		}
	}
  
}