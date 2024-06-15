package game.paper_scissors_stone;

public class Judge {
    public String player1String;
    public String player2String;

    public String determineWinner(String player1Choice, String player2Choice) {
        if (player1Choice == null && player2Choice == null) {
            player1String = "slowly";
            player2String = "slowly";
            return "Tie";
        }

        if (player1Choice == null && player2Choice != null) {
            player1String = "slowly";
            player2String = "win";
            return "Player2";
        }

        if (player1Choice != null && player2Choice == null) {
            player1String = "win";
            player2String = "slowly";
            return "Player1";
        }

        if (player1Choice.equals(player2Choice)) {
            player1String = "tie";
            player2String = "tie";
            return "Tie";
        }

        if (player1Choice != null && player2Choice != null && !(player1Choice.equals(player2Choice))) {
            switch (player1Choice) {
                case "scissors":
                    if (player2Choice.equals("paper")) {
                        player1String = "win";
                        player2String = "lose";
                        return "Player1";
                    } else {
                        player1String = "lose";
                        player2String = "win";
                        return "Player2";
                    }
                case "stone":
                    if (player2Choice.equals("scissors")) {
                        player1String = "win";
                        player2String = "lose";
                        return "Player1";
                    } else {
                        player1String = "lose";
                        player2String = "win";
                        return "Player2";
                    }
                case "paper":
                    if (player2Choice.equals("stone")) {
                        player1String = "win";
                        player2String = "lose";
                        return "Player1";
                    } else {
                        player1String = "lose";
                        player2String = "win";
                        return "Player2";
                    }
                default:
                    return "";
            }
        }
        return "";
    }
}