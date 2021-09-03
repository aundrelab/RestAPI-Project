package info.aundre.restapi_project_hw2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create button variable
        Button buttonForLogin = findViewById(R.id.login);

        // Create on click listener functinality for login button
        buttonForLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText username1 = findViewById(R.id.username);
                EditText password1 = findViewById(R.id.password);
                String username = username1.getText().toString();
                String password = password1.getText().toString();

                if(validate(username, password)) {
                    Intent i = new Intent(MainActivity.this, LandingPageActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    public boolean validate(String username, String password) {
        return true;
    }

}