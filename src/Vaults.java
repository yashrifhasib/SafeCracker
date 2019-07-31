public class Vaults {

    /**
     * Need to take care of the powerups...
     */


    // instance variables to keep track of during the game.
    private int round, numOfDigits, rangeOfDigits, numOfTurns, prizeMoney, userScore, vaultCode, attempts;
    private boolean alarm;
    private double chanceOfAlarm;

    /**
     * start of the game.
     */
    public Vaults() {
        this.round = 1;
        this.userScore = 0;
        this.chanceOfAlarm = 0.1;
        alarm = false;
        attempts = 0;
        getNumOfDigits();
        getRangeForCombination();
        getNumberOfTurns();
        generatePrizeMoney();
        generateVaultCode();
    }

    //Accessors
    /**
     * round
     * @return the current round
     */
    public int getRound() { return this.round; }

    /**
     * number of turns
     * @return turns left
     */
    public int numberOfTurnsLeft() { return this.numOfTurns; }

    /**
     * prize money
     * @return prize money in vault.
     */
    public int getPrizeMoney() { return this.prizeMoney; }

    /**
     * User money
     * @return the user has in the account.
     */
    public int getUserScore() { return this.userScore; }


    //User interaction

    /**
     * The client is going to use this function to make a move on the call of a player
     * @param move the input of the combination
     *             not going to do anything if length does not match
     * @return a feedback based on the user input.
     */
    public String makeMove(int move) {
        if (this.numOfDigits == Integer.toString(move).length() && this.numOfTurns > 0) {
            if (move == this.vaultCode) {
                nextRound();
                return " perfect!";
            }
            else if (move < this.vaultCode) {
                this.attempts++;
                this.numOfTurns -= generateRandomNumber(0, this.attempts);
                chanceOfAlarm += this.attempts / generateRandomNumber(10, 50);
                if (this.chanceOfAlarm > 0.9) {
                    alarm = true;
                    this.numOfTurns = 3;
                    attempts = 0;
                }
                return " lower than the code";
            }
            else if (move > this.vaultCode) {
                this.attempts++;
                this.numOfTurns -= generateRandomNumber(0, this.attempts);
                chanceOfAlarm += this.attempts / generateRandomNumber(10, 50);
                if (this.chanceOfAlarm > 0.9) {
                    alarm = true;
                    this.numOfTurns = 3;
                    attempts = 0;
                }
                return " higher than the code";
            }
        }
        else if (this.numOfTurns <= 0) {
            endGame();
        }
        return " invalid! You have to put in the exact number of digits.";
    }

    // toString............
    //.....................
    //.....................

    /**
     * toString version for user display on commandline
     * @return the strings...... includes everything not confidential like safe code.
     */
    public String toString() {
        return "Round: " + this.round + "\nNumber of Digits in Code: " + this.numOfDigits +
                "\nRange of Digits: 1 - " + rangeOfDigits + "\nPrize Money: " + this.prizeMoney +
                "\nUser Score: " + this.userScore + "\nAlarm: " + this.alarm + "\nNumber of Turns Left: " +
                this.numOfTurns;
    }





    // |  | ____  |  ____  ____   ____  ___
    // |__| |__|  |  |__|  |__|   |     |__
    // |  | |___  |  |     |___   |      __|

    /**
     * helper method
     * only called if user input is correct
     * if the player succeeds he goes to next round.
     */
    private void nextRound() {
        this.round++;
        this.chanceOfAlarm = 0.1;
        alarm = false;
        attempts = 0;
        getNumOfDigits();
        getRangeForCombination();
        getNumberOfTurns();
        generatePrizeMoney();
        generateVaultCode();
        this.userScore += this.prizeMoney;
    }

    /**
     * helper method
     * only called if the user is out of turns
     * game ends.
     */
    private void endGame() {
        System.out.println("You are out of turns!!");
        System.out.println("You have gotten up to round " + this.round + " with a score of " + this.userScore);
        System.exit(0);
    }

    /**
     * helper method to get the number of turns for the round.
     */
    private void getNumberOfTurns() {
        switch (this.round) {
            case 1:
                this.numOfTurns = 5 + generateRandomNumber(0, this.round);
                break;
            case 2:
                this.numOfTurns = 6 + generateRandomNumber(0, this.round);
                break;
            case 3:
                this.numOfTurns = 7 + generateRandomNumber(0, this.round);
                break;
            case 4:
                this.numOfTurns = 8 + generateRandomNumber(0, this.round);
                break;
            case 5:
                this.numOfTurns = 9 + generateRandomNumber(0, this.round);
                break;
            case 6:
                this.numOfTurns = 10 + generateRandomNumber(0, this.round);
                break;
            case 7:
                this.numOfTurns = 12 + generateRandomNumber(0, this.round);
                break;
            case 8:
                this.numOfTurns = 14 + generateRandomNumber(0, this.round);
                break;
            case 9:
                this.numOfTurns = 16 + generateRandomNumber(0, this.round);
                break;
            case 10:
                this.numOfTurns = 18 + generateRandomNumber(0, this.round);
                break;
            case 11:
                this.numOfTurns = 20 + generateRandomNumber(0, this.round);
                break;
            case 12:
                this.numOfTurns = 22 + generateRandomNumber(0, this.round);
                break;
            case 13:
                this.numOfTurns = 24 + generateRandomNumber(0, this.round);
                break;
            case 14:
                this.numOfTurns = 26 + generateRandomNumber(0, this.round);
                break;
            case 15:
                this.numOfTurns = 28 + generateRandomNumber(0, this.round);
                break;
            case 16:
                this.numOfTurns = 30 + generateRandomNumber(0, this.round);
                break;
            case 17:
                this.numOfTurns = 33 + generateRandomNumber(0, this.round);
                break;
            case 18:
                this.numOfTurns = 36 + generateRandomNumber(0, this.round);
                break;
            case 19:
                this.numOfTurns = 39 + generateRandomNumber(0, this.round);
                break;
            case 20:
                this.numOfTurns = 42 + generateRandomNumber(0, this.round);
                break;
        }
        if (this.round > 20) {
            this.numOfTurns = 42 + ((this.round - 20) * 3) + generateRandomNumber(0, this.round);
        }
    }

    /**
     * helper method
     * the range of the combination is from 1 to the number assigned by the method.
     */
    private void getRangeForCombination() {
        switch (this.round) {
            case 1:
                this.rangeOfDigits = 3;
                break;
            case 2:
                this.rangeOfDigits = 4;
                break;
            case 3:
                this.rangeOfDigits = 5;
                break;
            case 4:
                this.rangeOfDigits = 6;
                break;
            case 5:
                this.rangeOfDigits = 4;
                break;
            case 6:
                this.rangeOfDigits = 5;
                break;
            case 7:
                this.rangeOfDigits = 6;
                break;
            case 8:
                this.rangeOfDigits = 7;
                break;
            case 9:
                this.rangeOfDigits = 5;
                break;
            case 10:
                this.rangeOfDigits = 6;
                break;
            case 11:
                this.rangeOfDigits = 7;
                break;
            case 12:
                this.rangeOfDigits = 6;
                break;
            case 13:
                this.rangeOfDigits = 7;
                break;
            case 14:
                this.rangeOfDigits = 8;
                break;
            case 15:
                this.rangeOfDigits = 7;
                break;
            case 16:
                this.rangeOfDigits = 8;
                break;
            case 17:
                this.rangeOfDigits = 9;
                break;
            case 18:
                this.rangeOfDigits = 8;
                break;
            case 19:
                this.rangeOfDigits = 9;
                break;
            case 20:
                this.rangeOfDigits = 9;
                break;
        }
    }

    /**
     * helper method for getting the number of digits.
     */
    private void getNumOfDigits() {
        if (this.round <= 4 && this.round >= 1)
            this.numOfDigits = 3;
        else if (this.round <= 8 && this.round >= 5)
            this.numOfDigits = 4;
        else if (this.round <= 11 && this.round >= 9)
            this.numOfDigits = 5;
        else if (this.round <= 14 && this.round >= 12)
            this.numOfDigits = 6;
        else if (this.round <= 17 && this.round >= 15)
            this.numOfDigits = 7;
        else if (this.round == 18 || this.round == 19)
            this.numOfDigits = 8;
        else if (this.round == 20)
            this.numOfDigits = 9;
        else if (this.round > 20)
            this.numOfDigits++;
    }

    /**
     * helper method to generate prize money inside vault.
     */
    private void generatePrizeMoney() { this.prizeMoney = this.round * generateRandomNumber(1, 6) * 100; }

    /**
     * helper method for generating vault code.
     */
    private void generateVaultCode() {
        String temp = "";
        for (int i = 1; i < this.numOfDigits; i++) {
            temp += Integer.toString(generateRandomNumber(1, this.rangeOfDigits));
        }
        this.vaultCode = Integer.parseInt(temp);
    }

    /**
     * helper method.
     * Random number generator
     * @param max limit for random number
     * @return the random number
     */
    private int generateRandomNumber(int min, int max) { return (int) (Math.random() * max) + min; }
}