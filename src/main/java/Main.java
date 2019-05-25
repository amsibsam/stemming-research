import jsastrawi.morphology.defaultimpl.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        String[] tokenizedFormalDoc = SastrawiWrapper.getInstance().getTokenizer().tokenize(formalDocumentIphone);
//        System.out.println(tokenizedFormalDoc.length);
//
////        for (String docWord:
////                tokenizedFormalDoc) {
////            System.out.println(SastrawiWrapper.getInstance().getLemmatizer().lemmatize(docWord.toLowerCase()));
////        }
//
////        System.out.println("Formal Word stemming");
////        double wrong = 0;
////        double correct = 0;
////        double TP = 0;
////        double TN = 0;
////        double FP = 0;
////        double FN = 0;
////
////        for (int i = 0; i < tokenizedFormalDoc.length; i++) {
////            String docWord = tokenizedFormalDoc[i];
////            String rootWord = formalRootIphone[i];
////            String stemmingResult = SastrawiWrapper.getInstance().getLemmatizer().lemmatize(docWord);
////            boolean isValid = rootWord.toLowerCase().equals(stemmingResult.toLowerCase());
////
////            if (isValid) {
////                correct++;
////            } else {
////                wrong++;
////            }
////
////
////            //Di stemming benar TP
////            if (!stemmingResult.equals(docWord) && stemmingResult.equals(rootWord)) {
////                TP++;
////            }
////
////            //Di stemming tidak benar FP
////            if (!stemmingResult.equals(docWord) && !stemmingResult.equals(rootWord)) {
////                FN++;
////            }
////
////            //Tidak di stemming benar tapi di stemming FN
////            if (!stemmingResult.equals(rootWord) && rootWord.equals(docWord)) {
////                FP++;
////            }
////
////            //Tidak di stemming dan benar
////            if (docWord.equals(rootWord)) {
////                TN++;
////            }
////
////
////            System.out.println(stemmingResult + " " + isValid);
////        }
////
//////        System.out.println("TP: " + TP);
//////        System.out.println("FN: " + FN);
//////        System.out.println("FP: " + TP);
//////        System.out.println("TN: " + TN);
////        System.out.println("correct: " + correct + " wrong: " + wrong);
////        System.out.println("accuracy: " + correct/tokenizedFormalDoc.length);
//
////
////        System.out.println("Non Formal Word\tStemming Result\tValidRootWord\tisValid");
////        double wrong = 0;
////        double correct = 0;
////        double TP = 0;
////        double FP = 0;
////        double TN = 0;
////        double FN = 0;
////        for (int i = 0; i < validRootWords.length; i++) {
////
////
////            String nonFormalWord = nonFormalWords[i].toLowerCase();
////            String validRootWord = validRootWords[i].toLowerCase();
////            String stemmingResult = SastrawiWrapper.getInstance().getLemmatizer().lemmatize(nonFormalWord).toLowerCase();
//////                String stemmingResult = stemmingNaziefAndriani.KataDasar(nonFormalWord);
////
////            boolean isValid = validRootWord.toLowerCase().equals(stemmingResult.toLowerCase());
////
////            if (isValid) {
////                correct++;
////            } else {
////                wrong++;
////            }
////
////            //Di stemming benar TP
////            if (!stemmingResult.equals(nonFormalWord) && stemmingResult.equals(validRootWord)) {
////                TP++;
////            }
////
////            //Di stemming tidak benar FP
////            if (!stemmingResult.equals(nonFormalWord) && !stemmingResult.equals(validRootWord)) {
////                FN++;
////            } else if (stemmingResult.equals(nonFormalWord) && !stemmingResult.equals(validRootWord)) {
////                FN++;
////            }
////
////            //Tidak di stemming benar tapi di stemming FN
////            if (!stemmingResult.equals(validRootWord) && validRootWord.equals(nonFormalWord)) {
////                FP++;
////            }
////
////            //Tidak di stemming dan benar
////            if (nonFormalWord.equals(validRootWord)) {
////                TN++;
////            }
////
////
////            System.out.println(nonFormalWord + "\t" + stemmingResult + "\t" + validRootWord + "\t" + isValid);
////        }
////
//////        System.out.println("TP: " + TP);
//////        System.out.println("FN: " + FN);
//////        System.out.println("FP: " + FP);
//////        System.out.println("TN: " + TN);
////        System.out.println("correct: " + correct + " wrong: " + wrong);
////        System.out.println("accuracy: " + correct / nonFormalWords.length);
//        System.out.println("stemming result: " + SastrawiWrapper.getInstance().getLemmatizer().lemmatize("nyimpen"));
//
//
////        System.out.println("----------- non-formal affix stemming NA --------------------");
////        double startTime = System.currentTimeMillis();
////        System.out.println(SastrawiWrapper.getInstance().getLemmatizer().lemmatize("diselipin"));
////        System.out.println(SastrawiWrapper.getInstance().getNonformalDetector().isNonFormal("temenan"));
////        double endTime = System.currentTimeMillis();
////        System.out.println("code duration: " + ((endTime - startTime)/1000));
////
////        Levenshtein levenshtein = new Levenshtein();
////        System.out.println("distance " + levenshtein.distance("temen", "teman"));
////
////        NGram nGram = new NGram(2);
////        System.out.println("ngram " + nGram.distance("crita", "cerita"));
////        System.out.println("ngram " + nGram.distance("crita", "cita"));
//
//        boolean isContinue = true;
//        while (isContinue) {
//            System.out.println("Masukkan kata untuk dicari kata dasarnya");
//            System.out.printf("input kata: ");
//            Scanner in = new Scanner(System.in);
//            String kata = in.nextLine();
//            System.out.println("kata dasarnya adalah: " + SastrawiWrapper.getInstance().getLemmatizer().lemmatize(kata));
//
//        }


        List<String> tweets = new ArrayList<>();

        InputStream in = Main.class.getResourceAsStream("/usernames.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        int lineCount = 0;
        try {
            while ((line = br.readLine()) != null) {
                tweets.add(line);
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int formal = 0;
        int nonformal = 0;
        int unknown = 0;
        for (String token: tweets) {
            SastrawiWrapper.getInstance().getLemmatizer().lemmatize(token);
            System.out.println("is " + token + " formal word? " + Context.isFormal);
            if (Context.isFormal == Context.wordType.unknown) {
                unknown++;
            } else if (Context.isFormal == Context.wordType.formal) {
                formal++;
            } else if (Context.isFormal == Context.wordType.nonformal) {
                nonformal++;
            }
        }

        System.out.println("formal " + formal + " nonformal " + nonformal + " unknown" + unknown);
    }
}
