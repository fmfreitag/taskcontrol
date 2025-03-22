package br.com.freitag.taskcontrol.controller;

import br.com.freitag.taskcontrol.model.Task;
import br.com.freitag.taskcontrol.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> list() {
        return taskRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable("id") long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskRequest) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setNome(taskRequest.getNome());
            task.setDescricao(taskRequest.getDescricao());
            task.setStatus(taskRequest.getStatus());
            return taskRepository.save(task);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        taskRepository.deleteById(id);
    }

}
