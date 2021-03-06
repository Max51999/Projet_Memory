package fr.ensma.a3.ia.mymultichat.server.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.ensma.a3.ia.mymultichat.api.canal.ChatCanalDesc;
import fr.ensma.a3.ia.mymultichat.server.business.ChatCanalAdmin;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("multichat")
public class MultiChatServices {
	
	@GET
	@Path("{canalId}")
	public Response getCanalAmis(@PathParam("canalId") int canalId) {
		List<ChatCanalDesc> listcan = ChatCanalAdmin.getAllCanal();		
        try {
        	ChatCanalDesc cc = listcan.get(canalId);
    		return Response.ok(cc).build();
        } catch (IndexOutOfBoundsException ex) {
        	return Response.noContent().build();
        }
	}
	
	
	@GET
	public Response getCanalAmis() {
		List<ChatCanalDesc> listcan = ChatCanalAdmin.getAllCanal();
		return Response.ok(listcan).build();
	}
	
	@POST
	public void createCanal(ChatCanalDesc chat) {
		ChatCanalAdmin.createCanal(chat);
	}
	
	
}
