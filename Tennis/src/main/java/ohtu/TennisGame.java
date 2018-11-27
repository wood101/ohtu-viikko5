package ohtu;

public class TennisGame {
    
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;
    private final String firstPlayerName;
    private final String secondPlayerName;
    private final int POINT = 1;
    private final int SCORE_LIMIT = 4;
    private final int FIRST_PLAYER_ADVANTAGE = 1;
    private final int SECOND_PLAYER_ADVANTAGE = -1;
    private final int FIRST_PLAYER_WIN = 2;

    public TennisGame(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public void wonPoint(String playerName) {
        if (firstPlayerName.equals(playerName))
            firstPlayerScore += POINT;
        else
            secondPlayerScore += POINT;
    }

    public String getScore() {
        String score = "";
        if (firstPlayerScore==secondPlayerScore) {
            score = equalScore();
        }
        else if (firstPlayerScore >= SCORE_LIMIT || secondPlayerScore >= SCORE_LIMIT) {
            score = roundEndMessage();
        } else {
            score = unequalScore(score);
        }
        return score;
    }
    
    private String equalScore() {
        String score;
        switch (firstPlayerScore) {
            case 0:
                    return score = "Love-All";
            case 1:
                    return score = "Fifteen-All";
            case 2:
                    return score = "Thirty-All";
            case 3:
                    return score = "Forty-All";
            default:
                    return score = "Deuce";
        }
    }
    
    private String unequalScore(String score) {
        int tempScore = firstPlayerScore;
        for (int i = 1; i < 3; i++) {
            if (i > 1) {
                score += "-" ;
                tempScore = secondPlayerScore;
            }
            switch(tempScore) {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
    
    private String roundEndMessage() {
        String scoreMessage;
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == FIRST_PLAYER_ADVANTAGE) return scoreMessage = "Advantage " + firstPlayerName;
        else if (minusResult ==SECOND_PLAYER_ADVANTAGE) return scoreMessage = "Advantage " + secondPlayerName;
        else if (minusResult>=FIRST_PLAYER_WIN) return scoreMessage = "Win for " + firstPlayerName;
        else return scoreMessage = "Win for " + secondPlayerName;
    }
}