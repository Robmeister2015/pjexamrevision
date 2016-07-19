import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/modules")
public class ModuleResource {
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Module> getModules(){
		System.out.println("MODULES, YEAH!");
		return moduleDao.instance.getAllModules();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{moduleId}")
	public Module getAModule(@PathParam("moduleId") String id){
		return moduleDao.instance.getModule(id);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postModule(@FormParam("id") String id,
			@FormParam("name") String name, 
			@FormParam("lecturer") String lecturer,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("Inside POST id = " + id);
		System.out.println("title = " + name);

		Module module = new Module();
		module.setLecturer(lecturer);
		module.setModuleCode(id);
		module.setModuleName(name);
		moduleDao.instance.create(module);

		servletResponse.sendRedirect("../createModule.html");
	}
	
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("{moduleId}")
	public void deleteModule(@PathParam("moduleId") String id) throws IOException {
		System.out.println("Delete id = " + id);

		moduleDao.instance.delete(id);
	}

	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("{moduleId}")
	public void putModule(@PathParam("moduleId") String id,
			@FormParam("name") String name, @FormParam("lecturer") String lecturer,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("PUT id = " + id);

		Module module = new Module();
		module.setLecturer(lecturer);
		module.setModuleCode(id);
		module.setModuleName(name);
		moduleDao.instance.create(module);
	}
}
