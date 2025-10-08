package com.nb.dev.todo_list.services;

import com.nb.dev.todo_list.dtos.TodoDTO;
import com.nb.dev.todo_list.entities.Todo;
import com.nb.dev.todo_list.exceptions.TodoNotFoundException;
import com.nb.dev.todo_list.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> listTodos(){
        return todoRepository
                .findAll()
                .stream()
                .map(todo -> new TodoDTO(
                        todo.getTask(),
                        todo.getPriority(),
                        todo.getReleased()))
                .toList();
    }

    public List<TodoDTO> createTodo(TodoDTO todo){
        Todo todoSaved = new Todo();
        todoSaved.setTask(todo.getTask());
        todoSaved.setPriority(todo.getPriority());
        todoSaved.setReleased(todo.getReleased());
        todoRepository.save(todoSaved);

        return listTodos();

    }

    public List<TodoDTO> deleteTodo(Long id){
        todoRepository.deleteById(findTodoById(id).getId());
        return listTodos();
    }

    private Todo findTodoById(Long id){
        return todoRepository
                .findById(id)
                .orElseThrow(
                        () -> new TodoNotFoundException("Todo de id " + id + " não encontrada no banco de dados"));
    }


}
