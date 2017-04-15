package com.company;

/**
 * Created by joshuasander on 4/5/17.
 */
public class Board {
    private char [][]   myBoard;
    private int         horizontal, vertical;
    private char        letter;

    public Board(int horiz, int vert) {

        horizontal =    horiz;
        vertical =      vert;
        letter =        'a';

        myBoard = new char[horizontal][vertical];

        for (int x = 0; x < horizontal; x++) {
            for (int y = 0; y < vertical; y++) {
                myBoard[x][y] = 'X';
            }
        }
    }

    public Board(Board toCopy) {
        for (int x = 0; x < horizontal; x++) {
            for (int y = 0; y < vertical; y++) {
                myBoard[x][y] = toCopy.myBoard[x][y];
            }
        }
    }

    public boolean freeSpot(int x, int y) {
        if (myBoard[x][y] == 'X')
            return true;

        return false;
    }

    public void printBoard() {
        for (char[] chars : myBoard) {
            for (char x : chars) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public boolean insertO(int x, int y) {
        if ((y + 1 ) >= vertical || (x + 1) >= horizontal)
            return false;

        if (myBoard[x + 1][y] != 'X' || myBoard[x][y+1] != 'X' || myBoard[x+1][y+1] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x][y+1] = letter;
        myBoard[x+1][y+1] = letter;

  //      printBoard();
        letter++;

        return true;
    }

    public void removeO(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x+1][y+1] = 'X';

        letter--;

    }

    public boolean insertHorizI(int x, int y) {
        if ((y + 3) >= vertical)
            return false;

        if (myBoard[x][y+1] != 'X' || myBoard[x][y+2] != 'X' || myBoard[x][y+3] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x][y+1] = letter;
        myBoard[x][y+2] = letter;
        myBoard[x][y+3] = letter;

        letter++;

        return true;
    }

    public void removeHorizI(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x][y+2] = 'X';
        myBoard[x][y+3] = 'X';

        letter--;
    }

    public boolean insertVertI(int x, int y) {
        if (x + 3 >= horizontal)
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+2][y] != 'X' || myBoard[x+3][y] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+2][y] = letter;
        myBoard[x+3][y] = letter;

        letter++;

        return true;
    }

    public void removeVertI(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+2][y] = 'X';
        myBoard[x+3][y] = 'X';

        letter--;
    }

    public boolean insertSouthP(int x, int y) {
        if ( (x+1) >= horizontal || (y+2) >= vertical)
            return false;

        if (myBoard[x][y+1] != 'X' || myBoard[x][y+2] != 'X' || myBoard[x+1][y+2] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x][y+1] = letter;
        myBoard[x][y+2] = letter;
        myBoard[x+1][y+2] = letter;

        letter++;

        return true;
    }

    public void removeSouthP(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x][y+2] = 'X';
        myBoard[x+1][y+2] = 'X';

        letter--;
    }

    public boolean insertEastP(int x, int y) {
        if (y+1 >= vertical || x+2 >= horizontal)
            return false;

        if (myBoard[x][y+1] != 'X' || myBoard[x+1][y] != 'X' || myBoard[x+2][y] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x][y+1] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+2][y] = letter;

        letter++;

        return true;
    }

    public void removeEastP(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+2][y] = 'X';

        letter--;
    }

    public boolean insertNorthP(int x, int y) {
        if (y - 2 < 0 || x + 1 >= horizontal)
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+1][y-1] != 'X' || myBoard[x+1][y-2] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y-1] = letter;
        myBoard[x+1][y-2] = letter;

        letter++;

        return true;
    }

    public void removeNorthP(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y-1] = 'X';
        myBoard[x+1][y-2] = 'X';

        letter--;
    }

    public boolean insertWestP(int x, int y) {
        if (x+2 >= horizontal || y - 1 < 0)
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+2][y] = letter;
        myBoard[x+2][y-1] = letter;

        letter++;

        return true;
    }

    public void removeWestP(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+2][y] = 'X';
        myBoard[x+2][y-1] = 'X';

        letter--;
    }

    public boolean insertSouthL(int x, int y) {
        if ( (x+1) >= horizontal || (y+2) >= vertical)
            return false;

        if (myBoard[x][y+1] != 'X' || myBoard[x][y+2] != 'X' || myBoard[x+1][y] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x][y+1] = letter;
        myBoard[x][y+2] = letter;
        myBoard[x+1][y] = letter;

        letter++;

        return true;
    }

    public void removeSouthL(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x][y+2] = 'X';
        myBoard[x+1][y] = 'X';

        letter--;
    }

    public boolean insertEastL(int x, int y) {
        if (x+2 >= horizontal || y+1 >= vertical)
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+2][y] != 'X' || myBoard[x+2][y+1] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+2][y] = letter;
        myBoard[x+2][y+1] = letter;

        letter++;

        return true;
    }

    public void removeEastL(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+2][y] = 'X';
        myBoard[x+2][y+1] = 'X';

        letter--;
    }

    public boolean insertNorthL(int x, int y) {
        if (x+1 >= horizontal || y-2 < 0 )
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+1][y-1] != 'X' || myBoard[x+1][y-2] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y-1] = letter;
        myBoard[x+1][y-2] = letter;

        letter++;

        return true;
    }

    public void removeNorthL(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y-1] = 'X';
        myBoard[x+1][y-2] = 'X';

        letter--;
    }

    public boolean insertWestL(int x, int y) {
       if (x+2 >= horizontal || y+1 >= vertical)
           return false;

       if (myBoard[x][y+1] != 'X' || myBoard[x+1][y+1] != 'X' || myBoard[x+2][y+1] != 'X')
           return false;

       myBoard[x][y] = letter;
       myBoard[x][y+1] = letter;
       myBoard[x+1][y+1] = letter;
       myBoard[x+2][y+1] = letter;

       letter++;

       return true;
    }

    public void removeWestL(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x+1][y+1] = 'X';
        myBoard[x+2][y+1] = 'X';

        letter--;
    }

    public boolean insertHoriz5(int x, int y) {
        if (y+1 >= vertical || x+1 >= horizontal || y-1 < 0)
            return false;

        myBoard[x][y] = letter;
        myBoard[x][y+1] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y-1] = letter;

        letter++;

        return true;
    }

    public void removeHoriz5(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y-1] = 'X';

        letter--;
    }

    public boolean insertVert5(int x, int y) {
       if (y+1 >= vertical || x+2 >= horizontal)
           return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y+1] = letter;
        myBoard[x+2][y+1] = letter;

        letter++;

        return true;
    }

    public void removeVert5(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y+1] = 'X';
        myBoard[x+2][y+1] = 'X';

        letter--;
    }

    public boolean insertHoriz2(int x, int y) {
        if (x+1 >= horizontal || y+2 >= vertical)
            return false;

        if (myBoard[x][y+1] != 'X' || myBoard[x+1][y+1] != 'X' || myBoard[x+1][y+2] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x][y+1] = letter;
        myBoard[x+1][y+1] = letter;
        myBoard[x+1][y+2] = letter;

        letter++;

        return true;
    }

    public void removeHoriz2(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x+1][y+1] = 'X';
        myBoard[x+1][y+2] = 'X';

        letter--;
    }

    public boolean insertVert2(int x, int y) {
        if (x+2 >= horizontal || y-1 < 0)
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+1][y-1] != 'X' || myBoard[x+2][y-1] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y-1] = letter;
        myBoard[x+2][y-1] = letter;

        letter++;

        return true;
    }

    public void removeVert2(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y-1] = 'X';
        myBoard[x+2][y-1] = 'X';

        letter--;
    }

    public boolean insertSouthT(int x, int y) {
       if (x+1 >= horizontal || y+2 >= vertical)
           return false;

       if (myBoard[x+1][y+1] != 'X' || myBoard[x][y+1] != 'X' || myBoard[x][y+2] != 'X')
           return false;

       myBoard[x][y] = letter;
       myBoard[x+1][y+1] = letter;
       myBoard[x][y+1] = letter;
       myBoard[x][y+2] = letter;

       letter++;

       return true;
    }

    public void removeSouthT(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y+1] = 'X';
        myBoard[x][y+1] = 'X';
        myBoard[x][y+2] = 'X';

        letter--;
    }

    public boolean insertEastT(int x, int y) {
        if (x+2 >= horizontal || y+1 >= vertical)
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+1][y+1] != 'X' || myBoard[x+2][y] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y+1] = letter;
        myBoard[x+2][y] = letter;

        letter++;

        return true;
    }

    public void removeEastT(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y+1] = 'X';
        myBoard[x+2][y] = 'X';

        letter--;
    }

    public boolean insertNorthT(int x, int y) {
        if (x+1 >= horizontal || y+1 >= vertical || y-1 < 0)
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+1][y-1] != 'X' || myBoard[x+1][y+1] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y-1] = letter;
        myBoard[x+1][y+1] = letter;

        letter++;

        return true;
    }

    public void removeNorthT(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y-1] = 'X';
        myBoard[x+1][y+1] = 'X';

        letter--;
    }

    public boolean insertWestT(int x, int y) {
        if (x+2 >= horizontal || y-1 < 0)
            return false;

        if (myBoard[x+1][y] != 'X' || myBoard[x+1][y-1] != 'X' || myBoard[x+2][y] != 'X')
            return false;

        myBoard[x][y] = letter;
        myBoard[x+1][y] = letter;
        myBoard[x+1][y-1] = letter;
        myBoard[x+2][y] = letter;

        letter++;

        return true;
    }

    public void removeWestT(int x, int y) {
        myBoard[x][y] = 'X';
        myBoard[x+1][y] = 'X';
        myBoard[x+1][y-1] = 'X';
        myBoard[x+2][y] = 'X';

        letter--;
    }
}
