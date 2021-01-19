package com.login.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.login.model.ToDo;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<ToDo>();
    private static int todoCount = 3;

    static {
        todos.add(new ToDo(1, "mmdu", "SpringBoot Session-1", new Date(),
                false));
        todos.add(new ToDo(2, "mmdu", "SpringBoot Session-1", new Date(), false));
        todos.add(new ToDo(3, "mmdu", "SpringBoot Session-1", new Date(),
                false));
    }

    public List<ToDo> retrieveTodos(String user) {
        List<ToDo> filteredTodos = new ArrayList<ToDo>();
        for (ToDo todo : todos) {
          //  if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
          //  }
        }
        return filteredTodos;
    }
}
