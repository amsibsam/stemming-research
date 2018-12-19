import info.debatty.java.stringsimilarity.Levenshtein;
import info.debatty.java.stringsimilarity.NGram;
import info.debatty.java.stringsimilarity.QGram;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("----------- original stemming NA --------------------");
            StemmingNaziefAndriani stemmingNaziefAndriani = new StemmingNaziefAndriani();
            System.out.println("kemarin "+stemmingNaziefAndriani.KataDasar("nyeberang"));

        } catch (IOException e) {
            e.printStackTrace();
        }


//        System.out.println("----------- non-formal affix stemming NA --------------------");
        double startTime = System.currentTimeMillis();
        System.out.println(SastrawiWrapper.getInstance().getLemmatizer().lemmatize("temen"));
        System.out.println(SastrawiWrapper.getInstance().getNonformalDetector().isNonFormal("temenan"));
        double endTime = System.currentTimeMillis();
        System.out.println("code duration: " + ((endTime - startTime)/1000));

        Levenshtein levenshtein = new Levenshtein();
        System.out.println("distance " + levenshtein.distance("temen", "teman"));

        NGram nGram = new NGram(2);
        System.out.println("ngram " + nGram.distance("crita", "cerita"));
        System.out.println("ngram " + nGram.distance("crita", "cita"));
    }
}
