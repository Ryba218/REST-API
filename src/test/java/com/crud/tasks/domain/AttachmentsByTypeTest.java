package com.crud.tasks.domain;

import org.junit.Assert;
import org.junit.Test;

public class AttachmentsByTypeTest {

    @Test
    public void getTrello() {
        //Given
        Trello newTrello = new Trello(1, 2);
        AttachmentsByType newAttachment = new AttachmentsByType(newTrello);
        Badges badges = new Badges(3, newAttachment);

        //When & Then
        Assert.assertEquals(badges.getAttachments().getTrello().getBoard(), 1);
    }
}