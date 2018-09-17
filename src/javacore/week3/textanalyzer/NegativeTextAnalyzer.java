package javacore.week3.textanalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer{

    private String keywords[] = {":(", "=(", ":|"};

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
        return Label.NEGATIVE_TEXT;
    }
}
