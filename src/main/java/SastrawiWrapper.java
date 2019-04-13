import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;
import jsastrawi.tokenization.HeuristicTokenizer;
import jsastrawi.tokenization.Tokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SastrawiWrapper {
    private static final String TAG = SastrawiWrapper.class.getSimpleName();
    private static SastrawiWrapper instance = new SastrawiWrapper();
    private Lemmatizer lemmatizer;
    private Tokenizer tokenizer;
    private Set<String> dictionary = new HashSet<String>();
    private NonformalDetector nonformalDetector;

    public static SastrawiWrapper getInstance() {
        return instance;
    }

    private SastrawiWrapper() {
        InputStream in = Lemmatizer.class.getResourceAsStream("/root-words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tokenizer = new HeuristicTokenizer();
        nonformalDetector = new NonformalDetectorImp();
    }

    public NonformalDetector getNonformalDetector() {
        return nonformalDetector;
    }

    public Set<String> getDictionary() {
        return dictionary;
    }

    public Tokenizer getTokenizer() {
        return this.tokenizer;
    }
    public Lemmatizer getLemmatizer() {
        lemmatizer = new DefaultLemmatizer(dictionary);
        return this.lemmatizer;
    }
}