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
 * This is the class where will store Functions like for clearing the
 * screen,etc...
 *
 * @author nikla
 */
public class LibFuncs {

    private static void clearScrLinux() {
        System.out.print("\033[H\033[2J");
    }

    public static void clearScr() throws IOException, InterruptedException {
        String operatingSystem = System.getProperty("os.name");
        if (operatingSystem.contains("Windows")) {
            clearScrWindows();
        }

        if (operatingSystem.contains("Linux")) {
            clearScrLinux();
        }
    }

   private static void clearScrWindows() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
