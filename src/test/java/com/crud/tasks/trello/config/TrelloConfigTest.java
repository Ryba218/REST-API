package com.crud.tasks.trello.config;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TrelloConfig.class)
@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void getTrelloApiEndpoint() {
        //Given & When
        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();
        //Then
        Assert.assertEquals("https://api.trello.com/1", trelloApiEndpoint);
    }

    @Test
    public void getTrelloAppKey() {
        //Given & When
        String trelloAppKey = trelloConfig.getTrelloAppKey();
        //Then
        Assert.assertEquals("aee02b6d54187a3c214baaf1c4e6f01d", trelloAppKey);
    }

    @Test
    public void getTrelloToken() {
        //Given & When
        String trelloToken = trelloConfig.getTrelloAppToken();
        //Then
        Assert.assertEquals("f3e158da8bbec92079a21753d3dd02a45a66ad649bd4535e1fe3ec5284bd205e", trelloToken);
    }


}