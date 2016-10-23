package com.edu.main;

import com.edu.model.Board;
import com.edu.model.Cell;
import com.edu.model.Dimension;
import com.edu.service.BoardKillerService;
import com.edu.service.impl.BoardGeneratorServiceImpl;
import com.edu.service.impl.BoardKillerServiceImpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameOfLifeTest
{
    @Test
    public void givenInputSize_whenGenerateBoard_thenReturnBoard(){
        BoardGeneratorServiceImpl boardGeneratorService=new BoardGeneratorServiceImpl();
        Board board=boardGeneratorService.generateBoard(new Dimension(5,5));
        assertNotNull(board);
    }

    @Test
    public void test_AllCellsHasValidPosition() {
        BoardGeneratorServiceImpl boardGeneratorService=new BoardGeneratorServiceImpl();
        Board board=boardGeneratorService.generateBoard(new Dimension(5,5));
        for (int i = 0; i < board.getCells()[0].length; i++) {
            for (int j = 0; j < board.getCells()[0].length; j++) {
                assertEquals(i, board.getCells()[i][j].getPositionX());
                assertEquals(j, board.getCells()[i][j].getPositionY());
            }
        }

    }

    @Test
    public void kill_lonely_cells() {
        BoardGeneratorServiceImpl boardGeneratorService=new BoardGeneratorServiceImpl();
        Board board=boardGeneratorService.generateBoard(new Dimension(5,5));

        BoardKillerService boardKillerService = new BoardKillerServiceImpl();
        boardKillerService.killLonelyCells(board);
    }



}
