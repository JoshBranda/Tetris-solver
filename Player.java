package com.company;

/**
 * Created by joshuasander on 4/5/17.
 */
public class Player {
    private char [] tetrominos;
    private int horizontal, vertical;

    public Player(String toAdd, int horiz, int vert) {

        horizontal = horiz;
        vertical = vert;

        char [] array = toAdd.toCharArray();
        tetrominos = new char[array.length];

        int y = 0;

        for (int x = 0; x < array.length; x++) {
            tetrominos[x] = array[x];
        }
    }


    public boolean printSolution (Board myBoard) {
        int v = horizontal * vertical;

        if ( (v % 4) != 0) {
            System.out.println("?");
            return false;
        }

        int w = 0;
        int t = 0;

        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == 'T')
                w++;
            t++;
        }

        if (t * 4 != v) {
            System.out.println("?");
            return false;
        }

        if ( (w % 2) != 0) {
            System.out.println("?");
            return false;
        }

        if (printSolutionRec(myBoard, 0, 0) == true) {
            System.out.println("Your solution is: ");
            myBoard.printBoard();
            return true;
        }

        System.out.println("?");
        return false;

    }

    public boolean printSolutionRec (Board myBoard, int x, int y) {
//        myBoard.printBoard();

        if (x >= horizontal)
            return true;

        if (myBoard.freeSpot(x, y) == false) {
            if (y+1 < vertical)
                return (printSolutionRec(myBoard, x, ++y));
            return (printSolutionRec(myBoard, ++x, 0));
        }

        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == 'O') {
                if (myBoard.insertO(x, y)) {
                    tetrominos[z] = '*';
                    if ( y + 2 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 2) == true) {
                            return true;
                        }
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true) {
                            return true;
                        }
                    }
                    myBoard.removeO(x,y);
                }
                tetrominos[z] = 'O';

                break;
            }
        }

        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == 'I') {
                if (myBoard.insertHorizI(x, y)) {
                    tetrominos[z] = '*';
                    if ( y + 4 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 4) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeHorizI(x,y);
                }

                if (myBoard.insertVertI(x, y)) {
                    tetrominos[z] = '*';

                    if ( y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y+1) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeVertI(x,y);
                }
                tetrominos[z] = 'I';

                break;
            }
        }


        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == 'P') {
                if (myBoard.insertSouthP(x, y)) {
                    tetrominos[z] = '*';
                    if ( y + 3 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 3) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeSouthP(x,y);
                }

                if (myBoard.insertEastP(x, y)) {
                    tetrominos[z] = '*';

                    if ( y + 2 < vertical) {
                        if (printSolutionRec(myBoard, x, y+2) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeEastP(x,y);
                }

                if (myBoard.insertNorthP(x, y)) {
                    tetrominos[z] = '*';

                    if ( y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y+1) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeNorthP(x,y);
                }

                if (myBoard.insertWestP(x, y)) {
                    tetrominos[z] = '*';

                    if ( y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y+1) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeWestP(x,y);
                }

                tetrominos[z] = 'P';
                break;
            }
        }

        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == 'L') {
                if (myBoard.insertSouthL(x, y)) {
                    tetrominos[z] = '*';
                    if (y + 3 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 3) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeSouthL(x, y);
                }

                if (myBoard.insertEastL(x, y)) {
                    tetrominos[z] = '*';

                    if (y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 1) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeEastL(x, y);
                }

                if (myBoard.insertNorthL(x, y)) {
                    tetrominos[z] = '*';

                    if (y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 1) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeNorthL(x, y);
                }

                if (myBoard.insertWestL(x, y)) {
                    tetrominos[z] = '*';

                    if (y + 2 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 2) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeWestL(x, y);
                }
                tetrominos[z] = 'L';

                break;
            }
        }

        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == '5') {
                if (myBoard.insertHoriz5(x, y)) {
                    tetrominos[z] = '*';
                    if ( y + 2 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 2) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeHoriz5(x,y);
                }

                if (myBoard.insertVert5(x, y)) {
                    tetrominos[z] = '*';

                    if ( y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y+1) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeVert5(x,y);
                }
                tetrominos[z] = '5';

                break;
            }
        }

        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == '2') {
                if (myBoard.insertHoriz2(x, y)) {
                    tetrominos[z] = '*';
                    if ( y + 2 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 2) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeHoriz2(x,y);
                }

                if (myBoard.insertVert2(x, y)) {
                    tetrominos[z] = '*';

                    if ( y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y+1) == true)
                            return true;
                    }

                    else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeVert2(x,y);
                }
                tetrominos[z] = '2';

                break;
            }
        }

        for (int z = 0; z < tetrominos.length; z++) {
            if (tetrominos[z] == 'T') {
                if (myBoard.insertSouthT(x, y)) {
                    tetrominos[z] = '*';
                    if (y + 3 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 3) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeSouthT(x, y);
                }

                if (myBoard.insertEastT(x, y)) {
                    tetrominos[z] = '*';

                    if (y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 1) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeEastT(x, y);
                }

                if (myBoard.insertNorthT(x, y)) {
                    tetrominos[z] = '*';

                    if (y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 1) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeNorthT(x, y);
                }

                if (myBoard.insertWestT(x, y)) {
                    tetrominos[z] = '*';

                    if (y + 1 < vertical) {
                        if (printSolutionRec(myBoard, x, y + 1) == true)
                            return true;
                    } else {
                        if (printSolutionRec(myBoard, x + 1, 0) == true)
                            return true;
                    }
                    myBoard.removeWestT(x, y);
                }
                tetrominos[z] = 'T';

                break;
            }
        }
        return false;
    }
}
