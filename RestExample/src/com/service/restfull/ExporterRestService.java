package com.service.restfull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.service.controller.ExportServiceImpl;
import com.service.model.RestObject;

@Path(value = "/exporter")
public class ExporterRestService {

	ExportServiceImpl exportServiceImpl = new ExportServiceImpl();

	@GET
	@Path("/{password}/{}")
	public Response getResponse() {

		String result = exportServiceImpl.makeRequest();
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path(value = "{value}")
	@Produces("application/json")
	public String generateJsonValue(@PathParam("value") Integer param) {

		RestObject jsonObject = new RestObject();
		jsonObject.setId(param);
		jsonObject.setValue(String.valueOf(Math.random()));

		return jsonObject.toString();
	}
}
