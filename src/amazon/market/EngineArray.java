package amazon.market;

public class EngineArray implements Engine {
    @Override
    public boolean process(String[] customer, String[][] market) {
        int wordCount = 0;
        int backedCount = 0;
        for (int i = 0; i < customer.length; i++) {
            String word = customer[i];
            String backedWord = market[backedCount][wordCount];
            if (backedWord.equals("anything") || backedWord.equals(word)) {
                wordCount++;
                if (wordCount >= market[backedCount].length) {
                    wordCount = 0;
                    backedCount++;
                }
                if (backedCount >= market.length) {
                    i = customer.length;
                }
            } else {
                wordCount = 0;
            }
        }

        return backedCount >= market.length;
    }
}
