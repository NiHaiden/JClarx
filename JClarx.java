/*
 * Copyright (C) 2018 nikla
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jclarx;

import java.io.IOException;

/**
 * This is the main Class where the functions are gonna be called
 *
 * @author nikla
 */
public class JClarx {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int cols = 3;
        char[][] field = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        LibraryFunctions lib = new LibraryFunctions();
        UserUIFuncs ui = new UserUIFuncs();
        GameLogic gl = new GameLogic();
        int won = 0;
        int xfertig = 0, ofertig = 0;
        char player = 0;
        int fehlwert;
        int retarn;
        char dummy;
        int unentcounter = 0;
        boolean xplayerdone = false;
        boolean oplayerdone = false;
        String returninput;

        do {
            while (xplayerdone == false) {
                lib.clearScr();  ///Clearing the console Window for better viewing experience
                ui.showField(field);
                //   won = 1;
                player = 'X';

                xplayerdone = ui.userInput(field, player);
                if (gl.checkIfWon(field, player) == 1) {
                    System.out.println("Player " + player + " hat gewonnen! Glueckwunsch!");
                    return;
                }
            }
           
            while (oplayerdone == false) {
                lib.clearScr();
                ui.showField(field);
                player = 'O';
                oplayerdone = ui.userInput(field, player);
                if (gl.checkIfWon(field, player) == 1) {
                    System.out.println("Player " + player + " hat gewonnen! Glueckwunsch!");
                    return;
                }
            }
             xplayerdone = false;
             oplayerdone = false;
        } while (won != 1);

    }

}
