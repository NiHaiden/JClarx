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
    
    public static void main(String... args) throws IOException, InterruptedException {
        LibFuncs.clearScr();
        clarxMain();
        
    }
    public static void clarxMain() throws IOException, InterruptedException {
   
        char[][] field = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
     
        int won = 0;
        char player = 0;
        boolean xplayerdone = false;
        boolean oplayerdone = false;

        do {
            while (xplayerdone == false) {
                LibFuncs.clearScr();  ///Clearing the console Window for better viewing experience
                UserUIFuncs.showField(field);
                //   won = 1;
                player = 'X';

                xplayerdone = UserUIFuncs.userInput(field, player);
                if (GameLogic.checkIfWon(field, player) == 1) {
                    UserUIFuncs.showField(field);
                    System.out.println("Player " + player + " hat gewonnen! Glueckwunsch!");
                    return;
                }
            }

            while (oplayerdone == false) {
                LibFuncs.clearScr();
                UserUIFuncs.showField(field);
                player = 'O';
                oplayerdone = UserUIFuncs.userInput(field, player);
                if (GameLogic.checkIfWon(field, player) == 1) {
                    UserUIFuncs.showField(field);
                    System.out.println("Player " + player + " hat gewonnen! Glueckwunsch!");
                    return;
                }
            }
            xplayerdone = false;
            oplayerdone = false;
        } while (won != 1);

    }

}
