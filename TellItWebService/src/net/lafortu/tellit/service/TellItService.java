package net.lafortu.tellit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
}