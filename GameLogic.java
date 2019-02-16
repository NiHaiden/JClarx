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

/**
 * This class includes all the logic that the game requires, like player
 * position setting and checking if one player has won
 *
 * @author nikla
 */
public class GameLogic {
    
    private static int col;
    private static char zeile;
    /**
     *
     * @param field
     * @param colwahl
     * @param zwahl
     * @param player
     * @return
     */
    public static int setPos(char field[][], int colwahl, char zwahl, char player) {
        int zeile = 0;

        switch (zwahl) {
            case 'a':
                zeile = 0;
                break;
            case 'A':
                zeile = 0;
                break;
            case 'b':
                zeile = 1;
                break;
            case 'B':
                zeile = 1;
                break;
            case 'c':
                zeile = 2; 
                break; 
            case 'C':
                zeile = 2;
                break;
            default:
                return 2;
        }

        if (colwahl > 3) {
            return 2;
        }

        if (field[zeile][colwahl - 1] != ' ') {
            return 0;
        } else {
            field[zeile][colwahl - 1] = player;
            return 1;
        }

    }

    /**
     *
     * @param field
     * @param player
     * @return
     */
    public static int checkIfWon(char field[][], char player) {
        //Zeile
        if (field[0][0] == player && field[0][1] == player && field[0][2] == player) {
            return 1;
        } else if (field[1][0] == player && field[1][1] == player && field[1][2] == player) {
            return 1;
        } else if (field[2][0] == player && field[2][1] == player && field[2][2] == player) {
            return 1;
        }
        //-----
        //Spalten
        if (field[0][0] == player && field[1][0] == player && field[2][0] == player) {
            return 1;
        } else if (field[0][1] == player && field[1][1] == player && field[2][1] == player) {
            return 1;
        } else if (field[0][2] == player && field[1][2] == player && field[2][2] == player) {
            return 1;
        }
        //--------------------------------------------------------------------------
        //Diagonal
        if (field[0][0] == player && field[1][1] == player && field[2][2] == player) {
            return 1;
        } else if (field[0][2] == player && field[1][1] == player && field[2][0] == player) {
            return 1;
        }

        return 0;
    }

    public static char extractZeile(String s) {

        if (s.indexOf('A') == 0) {
            return 'A';
        }

        if (s.indexOf('B') == 0) {
            return 'B';
        }

        if (s.indexOf('C') == 0) {
            return 'C';
        }
        return 0;
    }
    
    public static int extractCol(String s){
        if(s.indexOf('1') == 2){
            return 1;
        }
        if (s.indexOf('2')==2) {
            return 2;
        }
        
        if (s.indexOf('3')==2) {
            return 3;
        }
        return 0;
    }
    /**
     * 
     * @param c The char to be set
     */
    public static void setZeile(char c){
        zeile = c;
    }
    
    /**
     * 
     * @param z The Zeile to be set 
     */
    public static void setCol(int z){
        col = z;
    }
}
