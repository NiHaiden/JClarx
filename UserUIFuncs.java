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
import java.util.Scanner;

/**
 * In this class we will store all the UI Elements and interactions with the
 * user of the game
 *
 * @author Niklas
 */
public class UserUIFuncs {

    /**
     * Used to display the game field.
     *
     * @param field
     */
    public static void showField(char field[][]) {
        showVersion();
        System.out.printf("\t   |  1   |  2   |  3   |\n");
        System.out.printf("\t-------------------------\n");
        System.out.printf("\t A |  %c   |  %c   |  %c   |\n", field[0][0], field[0][1], field[0][2]);
        System.out.printf("\t-------------------------\n");
        System.out.printf("\t B |  %c   |  %c   |  %c   |\n", field[1][0], field[1][1], field[1][2]);
        System.out.printf("\t-------------------------\n");
        System.out.printf("\t C |  %c   |  %c   |  %c   |\n", field[2][0], field[2][1], field[2][2]);
        System.out.printf("\t-------------------------\n");
    }

    public static void showVersion() {
        String ver = "v0.1.20";
        String code = "Ares";
        System.out.printf("\n\tJClarx %s \"%s\" Beta", ver, code);
        System.out.printf("\n\t======================\n\n");
    }

    /**
     * gets User-Input and returns it
     * 
     * @param field Game-Feld
     * @param player The player who is now playing
     * @return 
     * 
     */
    public static boolean userInput(char field[][], char player) throws IOException, InterruptedException {
        GameLogic logic = new GameLogic();
        LibraryFunctions lib = new LibraryFunctions();
        Scanner sc = new Scanner(System.in);
        Boolean done = false;
        char zeile;
        int col;

        int retsetze = 0;

        while (done == false) {
            System.out.print("\n\tPlayer " + player + ", bitte geben Sie Ihre gewuenschte Position ein (z.B: A-1) --> ");
            String s = sc.nextLine();
            if (s.length() == 3) {
                zeile = GameLogic.extractZeile(s);
                if (zeile == 0) {
                    printFehler("Die Zeile " + zeile + "gibt es nicht!");
                }
                col = GameLogic.extractCol(s);
                if (col == 0) {
                    printFehler("Die Spalte " + col + "gibt es nicht!");
                } else {
                    retsetze = GameLogic.setPos(field, col, zeile, player);
                    if (retsetze == 0) {
                        printFehler("Diese Position gibt es nicht!");
                        done = false;
                    } else {
                        done = true;
                    }

                }
//                return s;
            } else {
                lib.clearScr();
                showField(field);
                printFehler("Eingabefehler! Bitte wiederholen Sie Ihre Eingabe!");
            }

        }
        return true;
//        return null;
    }

    /**
     *
     * @param fehler String, Where the message is
     */
    public static void printFehler(String fehler) {
        System.out.println("Ein Fehler ist aufgetreten: " + fehler);
    }
}
