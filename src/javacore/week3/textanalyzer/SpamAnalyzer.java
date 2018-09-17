package javacore.week3.textanalyzer;

public class SpamAnalyzer extends KeywordAnalyzer{

    private String keywords[];

    public SpamAnalyzer(String str[]){
        this.keywords = str;
    }

    @Override
    public Label processText(String text) {
        for(String s : keywords){
            if (text.contains(s)){
                return getLabel();
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
