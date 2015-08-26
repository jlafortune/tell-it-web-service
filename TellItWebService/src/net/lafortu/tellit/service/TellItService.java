package net.lafortu.tellit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
@Stateless
public class TellItService {
	@EJB
    private ArticleManager articleManager;

    /**
     * Retrieves representation of an instance of TellItService
     * @return an instance of String
     */
    @GET
    @Path("/articles")
    @Produces("application/json")
    public List<Article> getArticles() {
        return articleManager.findAll();
    }
    
    /**
     * Saves a new article.
     */
    @POST
    @Path("/articles")
    @Consumes("application/json") 
    public Response createArticle(Article article) {
    	try { 
    		articleManager.saveArticle(article);
    	} catch (Exception e) {
    		return Response.serverError().build();
    	}
    	return Response.ok().build();
    }
}