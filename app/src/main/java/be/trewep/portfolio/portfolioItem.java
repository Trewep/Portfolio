package be.trewep.portfolio;


public class portfolioItem {
    private String mTitle;
    private String mOmschrijving;
    private String mTag;
    private String mLink;

    public portfolioItem(String Title, String Omschrijving, String Tag, String Link){
        mTitle = Title;
        mOmschrijving = Omschrijving;
        mTag= Tag;
        mLink= Link;
    }


    public String getTitle(){
        return mTitle;
    }
    public String getOmschrijving(){
        return mOmschrijving;
    }
    public String getTag(){
        return mTag;
    }
    public String getLink(){
        return mLink;
    }
}
