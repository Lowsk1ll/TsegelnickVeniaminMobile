package data;

public class SearchWord {

    public static final SearchWord DEFAULT_WORD = new SearchWord("EPAM");

    String word;

    public SearchWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
