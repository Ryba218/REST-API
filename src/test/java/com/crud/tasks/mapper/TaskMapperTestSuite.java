package com.crud.tasks.mapper;

import static org.junit.Assert.*;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test title", "Test content");

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertTrue(mappedTask.getClass().equals(Task.class));
        assertTrue(mappedTask.getId() == 1);
        assertTrue(mappedTask.getTitle().equals("Test title"));
        assertTrue(mappedTask.getContent().equals("Test content"));
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test title", "Test content");

        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);

        //Then
        assertTrue(mappedTask.getClass().equals(TaskDto.class));
        assertTrue(mappedTask.getId() == 1);
        assertTrue(mappedTask.getTitle().equals("Test title"));
        assertTrue(mappedTask.getContent().equals("Test content"));
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Test title 1", "Test content 1"));
        taskList.add(new Task(2L, "Test title 2", "Test content 2"));
        taskList.add(new Task(3L, "Test title 3", "Test content 3"));
        //When
        List<TaskDto> mappedList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertTrue(mappedList.size() == 3);
        assertTrue(mappedList.get(0).getClass().equals(TaskDto.class));
        assertEquals(1, mappedList.get(0).getId().longValue());
        assertEquals("Test title 2", mappedList.get(1).getTitle());
        assertEquals("Test content 3", mappedList.get(2).getContent());
    }

    @Test
    public void mapToTaskDtoListEpmtyList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(0,taskDtoList.size());
    }























}



