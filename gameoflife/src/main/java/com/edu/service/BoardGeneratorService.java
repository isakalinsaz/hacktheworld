package com.edu.service;

import com.edu.model.Board;
import com.edu.model.Cell;
import com.edu.model.Dimension;

/**
 * Created by merku on 22/10/2016.
 */
public interface BoardGeneratorService {

    Board generateBoard(Dimension dimension);

}
