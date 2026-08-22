package main.java.string.class_problems;

import java.util.*;

public class RpsArcade {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove))
            return "Draw";

        switch (playerMove) {
            case "Rock":
                return computerMove.equals("Scissors") ? "Player Wins" : "Computer Wins";
            case "Paper":
                return computerMove.equals("Rock") ? "Player Wins" : "Computer Wins";
            case "Scissors":
                return computerMove.equals("Paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        String[] moves = { "Rock", "Paper", "Scissors" };
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int rounds = 5;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " — Enter your move (Rock/Paper/Scissors): ");
            String player = sc.nextLine();
            String computer = moves[rand.nextInt(3)];
            String result = playRound(player, computer);

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\nRound | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + results[i]);
        }

        double winPct = (wins * 100.0) / rounds;
        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws +
                " | Win % = " + winPct + "%");

        sc.close();
    }
}