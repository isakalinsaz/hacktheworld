package com.service.restfull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.service.model.EmployeeVO;
import com.service.model.Employees;

@Path(value = "/exporter")
public class ExporterRestService {

	@GET
	@Path("/sayHelloWorld")
	@Produces("text/html")
	public Response getResponse() {

		String result = "Hello World";
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path(value = "/employees")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public static Response getAllEmployeesJSON() throws JsonGenerationException, JsonMappingException, IOException {
		List<EmployeeVO> listOfEMployee = new ArrayList<>();

		EmployeeVO empOne = new EmployeeVO(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
		EmployeeVO empTwo = new EmployeeVO(2, "Amit", "Singhal", "asinghal@yahoo.com");
		EmployeeVO empThree = new EmployeeVO(3, "Kirti", "Mishra", "kmishra@gmail.com");

		listOfEMployee.add(empOne);
		listOfEMployee.add(empTwo);
		listOfEMployee.add(empThree);

		Employees employees = new Employees();
		employees.setEmployees(listOfEMployee);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(employees);

		return Response.ok() // 200
				.entity(jsonInString).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();

	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println(getAllEmployeesJSON());
	}
}
