package com.nb.dev.todo_list.controllers;

import com.nb.dev.todo_list.dtos.TodoDTO;
import com.nb.dev.todo_list.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;


    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<List<TodoDTO>> createTodo(@Valid @RequestBody TodoDTO todo){
       List<TodoDTO> todos = todoService.createTodo(todo);
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(todos);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<TodoDTO>> deleteTodo(@PathVariable Long id){
        List<TodoDTO> todos = todoService.deleteTodo(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(todos);

    }

    @GetMapping()
    public List<TodoDTO> listTodos(){
        return todoService.listTodos();
    }

    @GetMapping("/released")
    public List<TodoDTO> listTodosReleased(){
        return todoService.releasedTodos();
    }





}
