package com.nb.dev.todo_list.repositories;

import com.nb.dev.todo_list.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
