package com.kainos.ea.resources;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.kainos.ea.ConnectionDB;
import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.model.Employee;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Api("Engineering Academy Dropwizard API")
@Path("/api")
public class WebService {
    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.selectAllEmployees(ConnectionDB.getConnection());

        return Response
                .status(Response.Status.OK)
                .entity(employees)
                .build();
    }

    @GET
    @Path("/employee/{employeeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeByID(@PathParam("employeeID") int employeeID) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.selectEmployeeByID(employeeID, ConnectionDB.getConnection());

        return Response
                .status(Response.Status.OK)
                .entity(employee)
                .build();
    }

    @GET
    @Path("/employee/getByName/{employeeName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeByName(@PathParam("employeeName") String employeeName) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.selectEmployeeByName(employeeName, ConnectionDB.getConnection());

        return Response
                .status(Response.Status.OK)
                .entity(employee)
                .build();
    }

    @POST
    @Path("/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.insertEmployee(employee, ConnectionDB.getConnection());
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
}
