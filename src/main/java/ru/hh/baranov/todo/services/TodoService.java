package ru.hh.baranov.todo.services;

import ru.hh.baranov.todo.entities.Todo;
import ru.hh.baranov.todo.TodoDAO;
import ru.hh.baranov.todo.exceptions.TodoNotFoundException;

import javax.inject.Inject;

public class TodoService {

    @Inject
    private TodoDAO todoDAO;

    @Inject TodoService todoService;
//
//    public TodoService(TodoDAO todoDAO) {
//        todoDAO = new TodoDAO();
//    }

    public Todo getTodoById(String id) {
        Todo todo = todoDAO.findById(id);
        if (todo == null) {
            throw new TodoNotFoundException(String.format("Todo with id = %s does not exists", id));
        }
        return todo;
    }
}
