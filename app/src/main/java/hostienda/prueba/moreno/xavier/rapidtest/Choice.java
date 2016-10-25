package hostienda.prueba.moreno.xavier.rapidtest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by xavier on 28/07/16.
 */

public class Choice
{

    @SerializedName("choice")
    @Expose
    private String choice;
    @SerializedName("votes")
    @Expose
    private Integer votes;

    public String getChoice()
    {
        return choice;
    }

    public void setChoice(String choice)
    {
        this.choice = choice;
    }

    public Integer getVotes()
    {
        return votes;
    }

    public void setVotes(Integer votes)
    {
        this.votes = votes;
    }

}
