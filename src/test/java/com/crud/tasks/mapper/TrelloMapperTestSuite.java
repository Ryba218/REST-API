package com.crud.tasks.mapper;

import static org.junit.Assert.*;

import com.crud.tasks.domain.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoards() {
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(testDataForBoards());

        //Then
        assertEquals(2, trelloBoards.size());
        assertEquals("1", trelloBoards.get(0).getId());
        assertEquals("List2", trelloBoards.get(0).getLists().get(1).getName());
        assertEquals(true, trelloBoards.get(0).getLists().get(2).isClosed());
    }

    @Test
    public void mapToBoardsDto() {
        //When
        List<TrelloBoardDto> trelloBoards = trelloMapper.mapToBoardsDto(trelloMapper.mapToBoards(testDataForBoards()));

        //Then
        assertEquals(2, trelloBoards.size());
        assertEquals("2", trelloBoards.get(1).getId());
        assertEquals("List2", trelloBoards.get(0).getLists().get(1).getName());
        assertEquals(true, trelloBoards.get(0).getLists().get(2).isClosed());
    }

    @Test
    public void mapToList() {
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(testDataForLists());
        //Then
        assertEquals(3,trelloLists.size());
    }

    @Test
    public void mapToListDto() {
        //When
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloMapper.mapToList(testDataForLists()));
        //Then
        assertEquals(3,trelloListsDto.size());
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Name","Description","top","1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Name", trelloCardDto.getName());
        assertEquals("Description",trelloCardDto.getDescription());
        assertEquals("top",trelloCardDto.getPos());
        assertEquals("1",trelloCardDto.getListId());
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto CardDto = new TrelloCardDto("Name","Description","top","1");
        //When
        TrelloCard card = trelloMapper.mapToCard(CardDto);
        //Then
        assertEquals("Name", card.getName());
        assertEquals("Description",card.getDescription());
        assertEquals("top",card.getPos());
        assertEquals("1",card.getListId());
    }

    private List<TrelloListDto> testDataForLists() {
        List<TrelloListDto> list = new ArrayList<>();
        list.add(new TrelloListDto("1","List1", false));
        list.add(new TrelloListDto("2","List2", false));
        list.add(new TrelloListDto("3","List3", true));
        return list;
    }

    private List<TrelloBoardDto> testDataForBoards() {

        List<TrelloListDto> trelloListDtos1 = testDataForLists();

        List<TrelloListDto> trelloListDtos2 = new ArrayList<>();
        trelloListDtos1.add(new TrelloListDto("1","list1", false));
        trelloListDtos1.add(new TrelloListDto("2","list2", false));
        trelloListDtos1.add(new TrelloListDto("3","list3", false));

        TrelloBoardDto boardDto1 = new TrelloBoardDto("1","Board1",trelloListDtos1);
        TrelloBoardDto boardDto2 = new TrelloBoardDto("2","Board1",trelloListDtos2);

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();

        trelloBoardDtoList.add(boardDto1);
        trelloBoardDtoList.add(boardDto2);

        return trelloBoardDtoList;

    }
}
