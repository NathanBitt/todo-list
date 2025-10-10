package com.nb.dev.todo_list.repositories;

import com.nb.dev.todo_list.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    @Query(value = "SELECT id, task, priority, is_released FROM tbl_todo WHERE is_released = true", nativeQuery = true)
    List<Todo> findTodosReleased();
}
