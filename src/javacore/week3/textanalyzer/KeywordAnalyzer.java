package javacore.week3.textanalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer{
    @Override
    public Label processText(String text) {
        return null;
    }

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();
}
