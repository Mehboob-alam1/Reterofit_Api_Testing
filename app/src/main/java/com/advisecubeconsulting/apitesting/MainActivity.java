package com.advisecubeconsulting.apitesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Model>> call = api.getdata();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                if (!response.isSuccessful()){
                    textView.setText("Code" +response.code());
                    return;
                }
                List<Model> data = response.body();
                for (Model model:data) {
                   String content="";
                   content+="Id"+model.getId()+"\n";
                   content+="User Id"+model.getUserId()+ "\n";
                   content+="Title"+model.getTitle() +"\n";
                   content+="Body"+model.getBody() +"\n\n";
                   textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
    textView.setText(t.getLocalizedMessage());
            }
        });
    }
}