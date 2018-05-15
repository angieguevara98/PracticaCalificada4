package practica.com.pe.practicacalificada4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edtusername;
    private EditText edtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusername = (EditText) findViewById(R.id.username_input);
        edtpassword = (EditText) findViewById(R.id.password_input);

    }


    public void callLogin(View view) {

        String username = edtusername.getText().toString();
        String password = edtpassword.getText().toString();

        ApiService servicio = ApiServiceGenerator.createService(ApiService.class);
        Call<ResponseMessage> call = null;

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Usuario y Contraseña son campos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }else{
            call = servicio.createAuth(username,password);

            // Intent a = new Intent(this, MainActivity.class);
            // startActivity(a);
        }
        final Intent a = new Intent(this, MainActivity.class);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);

                        // Toast.makeText(LoginActivity.this, responseMessage.getMessage(), Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "Usuario válido, ingresando...", Toast.LENGTH_LONG).show();
                        startActivity(a);
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Credenciales incorrectas");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }


            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });



    }

    public void agregar(View view){

        String username = edtusername.getText().toString();
        String password = edtpassword.getText().toString();

        ApiService servicio1 = ApiServiceGenerator.createService(ApiService.class);
        Call<ResponseMessage> call = null;

        call = servicio1.createUsuario(username,password);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);

                        Toast.makeText(MainActivity.this, responseMessage.getMessage(), Toast.LENGTH_LONG).show();


                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }
}
