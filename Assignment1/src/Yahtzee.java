public class Yahtzee {
    // attributes
    private Dice[] dice = new Dice[5];

    // constructors
    public Yahtzee() {
        for (int j = 0; j < 5; ++j) {
            dice[j] = new Dice();
            dice[j].roll();
        }
    }

    public Yahtzee(Dice[] dice1) {
        dice = dice1;
    }

    // methods
    public int[] getValueCount() {
        int[] repeat = new int[6];
        for (int i = 0; i < 5; i++) {
            if (dice[i].getValue() == 1) repeat[0]++;
            if (dice[i].getValue() == 2) repeat[1]++;
            if (dice[i].getValue() == 3) repeat[2]++;
            if (dice[i].getValue() == 4) repeat[3]++;
            if (dice[i].getValue() == 5) repeat[4]++;
            if (dice[i].getValue() == 6) repeat[5]++;
        }
        return repeat;
    }

    public boolean aKind(int c) {
        int[] aKindAfter = new int[5];
        for (int i = 0; i < 5; i++) {
            int targetSide = dice[i].getValue();
            for (int j = i ; j < 5; j++) {
                if (targetSide == dice[j].getValue()) aKindAfter[i]++;
            }
        }
        if (c >= 3) {
            // find the maxRepeat
            int maxRepeat = 0;
            for (int a = 0; a < 5; a++) {
                if (aKindAfter[a] > maxRepeat) maxRepeat = aKindAfter[a];
            }
            return (maxRepeat == c);
        } else {
            // check appearing pair
            int pair_num = 0;
            for (int a = 0; a < 5; a++) {
                if (aKindAfter[a] == 2) pair_num++;
            }
            return pair_num == 2;
        }
    }



    public int SumSides() {
        int total = 0;
        for (int i = 0; i < 5; i++) total = total + dice[i].getValue();
        return total;
    }

    public boolean straight(int c) {
        int[] conditions = new int[6];
        for (int i = 0; i < 5; i++) {
            if (dice[i].getValue() == 1) conditions[0] = 1;
            if (dice[i].getValue() == 2) conditions[1] = 1;
            if (dice[i].getValue() == 3) conditions[2] = 1;
            if (dice[i].getValue() == 4) conditions[3] = 1;
            if (dice[i].getValue() == 5) conditions[4] = 1;
            if (dice[i].getValue() == 6) conditions[5] = 1;
        }
        boolean answer = false;
        for (int i = 0; i < (5 - c + 2); i++) {
            int trueConditions = 0;
            for (int j = i; j < (i + c); j++) {
                trueConditions = trueConditions + conditions[j];
                if (trueConditions == c) answer = true;
            }
        }
        return answer;
    }

    public int[] getScoreOptions() {
        int[] scores = new int[13];
        // calculating the first 6 score with getValueCount
        int[] valueCount = getValueCount();
        for (int i = 0; i < 6; i++) scores[i] = valueCount[i] * (i + 1);
        // score[6]=sum(dices), 3 of a kind
        if (aKind(3)) scores[6] = SumSides();
        // score[7]=sum(dices), 4 of a kind
        if (aKind(4)) {scores[6] = SumSides(); scores[7] = SumSides();}
        // score[8]=25, 3 of a king and a pair
        if (aKind(3) && aKind(2)) scores[8] = 25;
        // score[9]=30, small straight (sequence of 4 dice)
        if (straight(4)) scores[9] = 30;
        // score[10]=40, large straight (sequence of 5 dice)
        if (straight(5)) scores[10] = 40;
        // score[11]=50, 5 of a kind
        if (aKind(5)) { scores[11] = 50; scores[6] = SumSides(); scores[7] = SumSides();}
                // score[12]: no pattern
//        int otherConditions = 0;
//        for (int i = 8; i < 12; i++) otherConditions = otherConditions + scores[i];
//        if (otherConditions == 0)
        scores[12] = SumSides();

        return scores;
    }

    public int[] score() {
        int[] scores = getScoreOptions();
        int maxScore = 0;
        int maxPlace = 0;
        for (int i = 0; i < 13; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxPlace = i;
            }
        }
        int[] result = new int[2];
        result[0] = maxScore;
        result[1] = maxPlace;
        return result;
    }

    public int[] sort() {
        int smallest = 0;
        int[] sorted = new int[5];
        for (int i = 0; i < 5; i++) {
            smallest = dice[i].getValue();
            for (int j = 0; j < 5; j++) {
                if (dice[j].getValue() < smallest) smallest = dice[j].getValue();
            }
            sorted[i] = smallest;
        }
        return sorted;
    }

    public boolean equals(Yahtzee other) {
        int[] dice1 = this.sort();
        int[] dice2 = other.sort();
        boolean eq = true;
        int i = 0;
        while (i < 5 && eq) {
            if (dice1[i] != dice2[i]) eq = false;
            ++i;
        }
        return eq;
    }
    public int[] toList() {
        int[] diceValues = new int[5];
        for (int i = 0; i < 5; i++) diceValues[i] = dice[i].getValue();
        return diceValues;
    }

    public String toString() {
       return "Dice: {"+dice[0].getValue()+", "+ dice[1].getValue() +", "+
               dice[2].getValue()+", "+dice[3].getValue()+", "+dice[4].getValue()+"}";
    }


}

