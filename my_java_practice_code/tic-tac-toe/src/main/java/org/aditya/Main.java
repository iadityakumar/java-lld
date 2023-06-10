package org.aditya;

import org.aditya.model.Board;
import org.aditya.model.Piece;
import org.aditya.model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Player[] p = new Player[2];
        for (int i = 0; i < 2; i++) {

            System.out.println("Enter the name of player " + i);
            String n = br.readLine();
            System.out.println("Enter the symbol of player " + i);
            Character c = (Character) br.readLine().charAt(0);
            p[i] = new Player(n, new Piece(c));

        }

        Board board = new Board(3, 3);
        while (!board.isGameOver()) {
            System.out.println("\nBoard position: ");
            board.printEmptyBoardWithPos();
            System.out.println("\nCurrent Board: ");
            board.printBoard();

            for (int i = 0; i < 2; i++) {
                int x, y;
                do {
                    System.out.println("\nEnter the position for player: " + i);
                    String s = br.readLine();
                    String[] positions = s.split(",");
                    x = Integer.parseInt(positions[0]);
                    y = Integer.parseInt(positions[1]);
                    if (!board.isValidPos(x, y)) {
                        System.out.println("\nInvalid position, please try again ");
                    }
                }
                while (!board.isValidPos(x, y) || board.isGameOver());
                if (board.isValidPos(x, y)) {
                    board.setPiecesAtPos(x, y, p[i].getPiece());
                }
                Player winner = board.getWinner(p);
                System.out.println("\nWinner: " + winner);
                if ( winner != null) {
                    System.out.println(winner.getName() + "\nhas won the game");
                    System.exit(1);
                }
                if (board.isGameOver()) {
                    System.out.println("\nGame is drawn");
                    System.exit(1);
                }

                System.out.println("\nNew Board: ");
                board.printBoard();
            }
        }



//        Integer n2 = Integer.parseInt(br.readLine());
//        System.out.println("Value of sum :"+(n+n2));


    }
}