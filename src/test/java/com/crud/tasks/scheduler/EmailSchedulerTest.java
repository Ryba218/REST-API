package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class EmailSchedulerTest {

    @InjectMocks
    private EmailScheduler emailScheduler;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Test
    public void sendEmail() {
        //Given
        Mail mail = new Mail("test@test.com", "Subject","Test");
        //When
        Mockito.when(adminConfig.getAdminMail()).thenReturn(mail.getMailTo());
        Mockito.when(taskRepository.count()).thenReturn(1L);
        emailScheduler.sendInformationEmail();
        //Then
        verify(taskRepository, times(1)).count();
        verify(simpleEmailService, times(1)).send(any(Mail.class));
        verify(simpleEmailService, times(0)).send(mail);
    }




}