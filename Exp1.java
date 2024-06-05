public class Exp1 {

    public static int bigramCount(String[] corpus, String word1, String word2) {
        int count = 0;
        for (int i = 0; i < corpus.length; i++) {
            String[] corpusTokens = corpus[i].split(" ");
            for (int j = 0; j < corpusTokens.length - 1; j++) {
                if (word1.equals(corpusTokens[j]) && word2.equals(corpusTokens[j + 1])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int unigramCount(String[] corpus, String word) {
        int count = 0;
        for (int i = 0; i < corpus.length; i++) {
            String[] corpusTokens = corpus[i].split(" ");
            for (int j = 0; j < corpusTokens.length - 1; j++) {
                if (word.equals(corpusTokens[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] corpus = { "I like to play cricket", "I play on sunny day", "I like to play chess" };
        String test = "I like football";
        String[] testTokens = test.split(" ");
        double probability = 1;
        int corpusSize = 9;
        for (int i = 0; i < testTokens.length - 1; i++) {
            probability *= (double) (bigramCount(corpus, testTokens[i], testTokens[i + 1]))
                    / (unigramCount(corpus, testTokens[i]));
        }

        System.out.format("Probability: %.4f", probability);
    }
}