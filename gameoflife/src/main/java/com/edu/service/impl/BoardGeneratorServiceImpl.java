package com.edu.service.impl;

import com.edu.model.*;
import com.edu.service.BoardGeneratorService;

import java.util.Random;

public class BoardGeneratorServiceImpl implements BoardGeneratorService {

    public Board generateBoard(Dimension dimension) {
        Board board = new Board();
        board.setCells(new Cell[dimension.getPositionX()][dimension.getPositionY()]);
        for (int i = 0; i < dimension.getPositionX(); i++) {
            for (int j = 0; j < dimension.getPositionY(); j++) {
                board.getCells()[i][j] = createCell(new Position(i,j));
            }
        }
        return board;
    }

    private Cell createCell(Position position) {

        Cell cell;

        Random _random = new Random();
        int randomNumber = _random.nextInt(2);

        if (randomNumber == 0)
            cell = createEmptyCell();
        else
            cell = createLiveCell();

        cell.setPositionX(position.getX());
        cell.setPositionY(position.getY());
        return cell;
    }

    private Cell createEmptyCell() {
        return new EmptyCell();
    }

    private Cell createLiveCell() {
        return new LiveCell();
    }
}
