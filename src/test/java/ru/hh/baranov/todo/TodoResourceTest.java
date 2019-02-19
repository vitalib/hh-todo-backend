package ru.hh.baranov.todo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import ru.hh.nab.starter.NabApplication;
import ru.hh.nab.testbase.NabTestBase;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = TodoTestConfig.class)
public class TodoResourceTest extends NabTestBase {

  @Inject
  TodoDAO todoDAO;


  @Before
  public void setUp() {
    todoDAO.clearAll();
  }

  @Test
  public void resource() {
    Response response = createRequest("/api/todos").get();
    System.out.println(response.readEntity(String.class));
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
  }

  @Test
  public void resourcePost() {
    Response response = target("/api/todos")
            .request()
            .buildPost(Entity.json(new Todo("kuku")))
            .invoke();
    assertThat(response.readEntity(String.class), containsString("kuku"));
  }

  @Test
  public void resourceGetSingleTodo() {
    Todo newTodo = todoDAO.save(new Todo("kuku"));
    Response response = createRequest("/api/todos/" + newTodo.getId()).get();
    assertThat(response.readEntity(String.class), containsString("kuku"));
  }

  @Test
  public void resourceModifySingle() {
    Todo todo = new Todo("kuku");
    todoDAO.save(todo);
    todo.setTitle("modified");
    Response response =  target("/api/todos/" + todo.getId())
            .request()
            .buildPut(Entity.json(todo))
            .invoke();
    assertThat(response.readEntity(String.class), containsString("modified"));
  }

  @Test
  public void deleteTodo() {
    Todo todo = new Todo("kuku");
    Response response =  target("/api/todos/" + todo.getId())
            .request()
            .delete();
    assertEquals(todoDAO.findAll().toString(), "[]");
  }

  @Override
  protected NabApplication getApplication() {
    return NabApplication.builder().configureJersey().registerResources(TodoResource.class).bindToRoot().build();
  }
}
