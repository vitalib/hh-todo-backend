package ru.hh.baranov.todo.resources;

import ru.hh.baranov.todo.TodoDAO;
import ru.hh.baranov.todo.entities.Todo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api")
public class TodoResource {

    @Inject
    TodoDAO todoDAO;

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTodos() {
        return Response.ok()
                .entity(todoDAO.findAll())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/todos")
    public Response createTodo(Todo todo) {
        return Response.ok()
            .entity(todoDAO.save(todo))
            .build();

    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/todos/{id}")
    public Response getTodoById(@PathParam("id") String id) {
        return Response.ok()
                .entity(todoDAO.findById(id))
                .build();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    @Path("/todos/{id}")
    public Response updateTodo(@PathParam("id") String id, Todo todo) {
        Todo savedTodo = todoDAO.findById(id);
        savedTodo.setTitle(todo.getTitle());
        savedTodo.setCompleted(todo.getCompleted());
        todoDAO.save(savedTodo);
        return Response.ok()
                .entity(savedTodo)
                .build();
    }

    @DELETE
    @Path("/todos/{id}")
    public Response deleteTodo(@PathParam("id") String id) {
        todoDAO.deleteById(id);
        return Response.ok().build();
    }
}
