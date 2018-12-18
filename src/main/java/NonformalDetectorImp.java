import java.util.Set;

public class NonformalDetectorImp implements NonformalDetector {
    private String[] regexRules = {
            "(.*)in$",
            "^n(.*)[^kan, ^an]$",
            "^n(.*)in$",
            "^ke(.*)",
            "^m[^e](.*)",
    };


    @Override
    public boolean isNonFormal(String word) {
//        Set<String> dict = SastrawiWrapper.getInstance().getDictionary();

//        if (dict.contains(word)) {
//            return false;
//        }
//
//        for (String rule : regexRules) {
//            if (word.matches(rule)) {
//                return true;
//            }
//        }

        return false;
    }
}
