public class Exp3 {
    
        public static int trigramCount(String[] corpus, String word1, String word2, String word3){
        int count = 0;
        for(int i=0;i<corpus.length;i++){
            String[]  corpusTokens = corpus[i].split(" ");
            for(int j=0;j<corpusTokens.length-2;j++){
                if(word1.equals(corpusTokens[j]) && word2.equals(corpusTokens[j+1]) && word3.equals(corpusTokens[j+2])){
                    count++;
                }
            }
        }
        return count;
    }
   
    public static int bigramCount(String[] corpus, String word1, String word2){
        int count = 0;
        for(int i=0;i<corpus.length;i++){
            String[]  corpusTokens = corpus[i].split(" ");
            for(int j=0;j<corpusTokens.length-1;j++){
                if(word1.equals(corpusTokens[j]) && word2.equals(corpusTokens[j+1])){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int unigramCount(String[] corpus, String word){
        int count = 0;
        for(int i=0;i<corpus.length;i++){
            String[]  corpusTokens = corpus[i].split(" ");
            for(int j=0;j<corpusTokens.length-1;j++){
                if(word.equals(corpusTokens[j])){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] corpus = {"There is a big garden","Children play in the garden", "They play inside beautiful garden"};
        String test = "They play in a big garden";
        String[] testTokens = test.split(" ");
        double probability = 1;
        int corpusSize= 12;
        for(int i=0; i<testTokens.length-2;i++){
            probability *= (double) (trigramCount(corpus, testTokens[i], testTokens[i+1], testTokens[i+2])+1)/(bigramCount(corpus,testTokens[i], testTokens[i+1])+ corpusSize);
        }
       
        System.out.format("Probability: %.4f",probability);
    }
}