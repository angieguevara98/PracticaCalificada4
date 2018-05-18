package practica.com.pe.practicacalificada4;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    String API_BASE_URL = "https://ide.c9.io/angie_guevara98/php56-cloned";

    @GET("api/v1/denuncias")
    Call<List<Denuncia>> getDenuncias();


    @FormUrlEncoded
    @POST("/api/v1/usuarios")
    Call<Usuario> createUsuario(@Field("username") String username,
                                        @Field("password") String password);


    @FormUrlEncoded
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenuncia(@Field("titulo") String titulo,
                                         @Field("descripcion") String comentario,
                                         @Field("id_usuario") Integer usuarios_id
    );
    @Multipart
    @POST("/api/v1/denuncias")
    Call<ResponseMessage> createDenunciaWithImage(
            @Part("titulo") RequestBody titulo,
            @Part("descripcion") RequestBody comentario,
            @Part("id_usuario") RequestBody usuarios_id,
            @Part MultipartBody.Part imagen
    );

    @FormUrlEncoded
    @POST("/api/v1/login")
    Call<Usuario> createAuth(@Field("username") String username,
                             @Field("password") String password);





}
