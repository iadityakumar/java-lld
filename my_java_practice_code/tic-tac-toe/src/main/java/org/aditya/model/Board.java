package org.aditya.model;

public class Board {
    int x;
    int y;
    Piece pieces[][];

    static  final int WINNING_SIZE = 3;
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        this.pieces = new Piece[x][y];

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPiecesAtPos(int x, int y, Piece p) {
        this.pieces[x][y] = p;
    }

    public void printEmptyBoardWithPos() {
        for (int i = 0; i < this.pieces.length; i++) {
            System.out.println();
            for (int j = 0; j < this.pieces[i].length; j++) {

                    System.out.print(String.valueOf(i) + ',' + String.valueOf(j) + " | ");
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < this.pieces.length; i++) {
            System.out.println();
            for (int j = 0; j < this.pieces[i].length; j++) {
                if (this.pieces[i][j] != null) {
                    System.out.print(this.pieces[i][j].getSymbol() + " \t|");
                }
                else {
                    System.out.print("\t|");
                }
            }
        }
    }

    public boolean isGameOver() {
        boolean isGameOver = true;
        for (int i = 0; i < this.pieces.length; i++) {
            for (int j = 0; j < this.pieces[i].length; j++) {
                if (this.pieces[i][j] == null) {
                   isGameOver = false;
                }
            }
        }
        return isGameOver;
    }

    public boolean isValidPos(int x, int y) {
        boolean isValidPos = true;
        if (!((0 <= x && x < this.x) && (0 <= y && y < this.y))){
            return false;
        }

        if (this.pieces[x][y] != null) {
            return false;
        }
        return true;
    }

    public Player getWinner(Player players[]) {
        for (Player p : players) {
//            check rowwise
            boolean isPlayerPWinner = true;
            for (int i = 0; i < this.pieces.length; i++) {
                for (int j = 0; j <= this.pieces[i].length - WINNING_SIZE; j++) {
                    isPlayerPWinner = true;
                    for (int k = 0; k < WINNING_SIZE; k++) {
//                        System.out.print(String.valueOf(i) + " + " + String.valueOf(j) + " " + this.pieces[i][j+k].getSymbol() +" " + p.getPiece().getSymbol() + "\n");
                        if (this.pieces[i][j+k] == null || this.pieces[i][j+k].getSymbol() != p.getPiece().getSymbol()) {
                            isPlayerPWinner = false;
                            break;
                        }
                    }
                    if (isPlayerPWinner)
                        return p;
                }
            }

            //            check columnwise
            for (int j = 0; j < this.pieces[0].length; j++) {
                for (int i = 0; i <= this.pieces.length - WINNING_SIZE; i++) {
                    isPlayerPWinner = true;
                    for (int k = 0; k < WINNING_SIZE; k++) {
                        if (this.pieces[i+k][j] == null || this.pieces[i+k][j] != p.getPiece()) {
                            isPlayerPWinner = false;
                            break;
                        }
                    }
                    if (isPlayerPWinner)
                        return p;
                }
            }

//            check left diagonal wise
            for (int j = 0; j <= this.pieces.length-WINNING_SIZE; j++){
                isPlayerPWinner = true;
                for (int k = 0; k < WINNING_SIZE; k++) {
                    if (this.pieces[j+k][j+k] == null || this.pieces[j+k][j+k] != p.getPiece()) {
                        isPlayerPWinner = false;
                        break;
                    }
                }
                if (isPlayerPWinner)
                    return p;
                isPlayerPWinner = true;
                for (int k = 0; k < WINNING_SIZE; k++) {
                    if (this.pieces[j+k][WINNING_SIZE - (j+k) -1] == null || this.pieces[j+k][WINNING_SIZE - (j+k) -1] != p.getPiece()) {
                        isPlayerPWinner = false;
                        break;
                    }
                }

                if (isPlayerPWinner)
                    return p;
            }
        }

        return null;
    }


}
