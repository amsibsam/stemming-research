import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            StemmingNaziefAndriani stemmingNaziefAndriani = new StemmingNaziefAndriani();
            System.out.println("kemarin "+stemmingNaziefAndriani.KataDasar("nyeberang"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        double startTime = System.currentTimeMillis();
        System.out.println(SastrawiWrapper.getInstance().getLemmatizer().lemmatize("nyeberang"));
        System.out.println(SastrawiWrapper.getInstance().getNonformalDetector().isNonFormal("temenan"));
        double endTime = System.currentTimeMillis();
        System.out.println("code duration: " + ((endTime - startTime)/1000));


        int[] rank = {83, 86, 87};


        int[] sortedRank = rank;
        Arrays.sort(sortedRank);

        List<Integer> positiveDiff = new ArrayList();

        for (int i = sortedRank.length - 1; i > 0; i--) {
            if (sortedRank[i] - sortedRank[(i - (sortedRank.length - 1)) + 1] > 0) {
                positiveDiff.add(sortedRank[i] - sortedRank[(i - (sortedRank.length - 1)) + 1]);
            }
        }

        for (int diff: positiveDiff) {
            System.out.println("diff "+diff);
        }

        int value = 5 | 1;
        System.out.println(value);

        HashMap<String, Integer> a = new HashMap<>();

    }
}
