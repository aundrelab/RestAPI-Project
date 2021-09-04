package info.aundre.restapi_project_hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LandingPageActivity extends AppCompatActivity {

    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        Bundle bundle = getIntent().getExtras();
        myTextView = findViewById(R.id.text_view);
        updateTextView(bundle);
    }

    private void updateTextView(Bundle b) {

        myTextView.append("Hello, " + b.getString("username") + "!" + " Your user id is " + b.getInt("userId") + "\n\n");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https:jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    myTextView.setText("Code:" + response.code());
                    return;
                }
                List<Post> posts = response.body();
                if (posts != null) {
                    for (Post post : posts) {
                        if (post.getUserId() == b.getInt("userId")) {
                            String content = "";
                            content += "ID: " + post.getId() + "\n"
                                    + "User ID: " + post.getUserId() + "\n"
                                    + "Title: " + post.getTitle() + "\n"
                                    + "Text: " + post.getText() + "\n\n";
                            myTextView.append(content);
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                myTextView.setText(t.getMessage());
            }
        });
    }


}