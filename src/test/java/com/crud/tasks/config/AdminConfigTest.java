package com.crud.tasks.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class AdminConfigTest {


        @InjectMocks
        private AdminConfig adminConfig;

        @Test
        public void getAdminMail() {
            //Given & When
            String mail = adminConfig.getAdminMail();

            //Then
            Assert.assertNull(mail);
        }

}