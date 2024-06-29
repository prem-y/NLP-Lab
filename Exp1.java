/*
Consider the following Corpus of three sentences
a)	There is a big garden.
b)	Children play in a garden
c)	They play inside beautiful garden
Calculate P for the sentence “They play in a big Garden” assuming a bi-gram language model.
 */

public class Exp1 {

    public static int bigramCount(String[] corpus, String word1, String word2) {
        int count = 0;
        for (int i = 0; i < corpus.length; i++) {
            String[] corpusTokens = corpus[i].split(" ");
            for (int j = 0; j < corpusTokens.length - 1; j++) {
                if (word1.equalsIgnoreCase(corpusTokens[j]) && word2.equals(corpusTokens[j + 1])) {
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
                if (word.equalsIgnoreCase(corpusTokens[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] corpus = { "There is a big garden", "Children play in a garden", "They play inside beautiful garden" };
        String test = "They play in a big Garden";
        String[] testTokens = test.split(" ");
        double probability = 1;
        int corpusSize = 9;
        for (int i = 0; i < testTokens.length - 1; i++) {
            probability *= (double) (bigramCount(corpus, testTokens[i], testTokens[i + 1]))
                    / (unigramCount(corpus, testTokens[i])+corpusSize);
        }

        System.out.format("Probability: %.4f", probability);
    }
}