package ru.hh.nab.example;

import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    private static int counter = 0;

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> findAll() {
        return todos;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(Integer.toString(counter++));
            todos.add(todo);
        } else {
            Todo saved = todos.stream().filter(aTodo -> todo.getId().equals(aTodo.getId())).findFirst().orElse(null);
            if (saved != null) {
                int ind = todos.indexOf(saved);
                todos.set(ind, todo);
            }
        }
        return todo;
    }

    public void clearAll() {

        todos = new ArrayList<>();
        counter = 0;
    }

    public Todo findById(String id) {
        return todos.stream().filter(todo -> id.equals(todo.getId())).findFirst().orElse(null);
    }

    public void deleteById(String id) {
        Todo todo = findById(id);
        todos.remove(todo);
    }

}
