package be.trewep.portfolio;

public class portfolioItem {
    int id;
    String field_title;
    String field_omschrijving;
    String field_afbeelding;
    String field_tags;
    String field_url;

    public String getField_title(){
        return field_title;
    }

    public String getField_omschrijving(){
        return field_omschrijving;
    }

    public String getField_tags(){
        return field_tags;
    }

    public String getField_url(){
        return field_url;
    }

    public int getId(){
        return id;
    }

    public  void setId(int id){
        this.id=id;
    }

}
