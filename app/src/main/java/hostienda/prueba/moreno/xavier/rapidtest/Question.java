package hostienda.prueba.moreno.xavier.rapidtest;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by xavier on 28/07/16.
 */

public class Question
{
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("choices")
    @Expose
    private List<Choice> choices = new ArrayList<Choice>();

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getPublishedAt()
    {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    public List<Choice> getChoices()
    {
        return choices;
    }

    public void setChoices(List<Choice> choices)
    {
        this.choices = choices;
    }

}