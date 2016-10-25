package hostienda.prueba.moreno.xavier.rapidtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by xavier on 28/07/16.
 */
public interface Client
{
    @GET ("/questions/{id}")
    Call<List<Question>> questions(@Path("id")int id);
}
