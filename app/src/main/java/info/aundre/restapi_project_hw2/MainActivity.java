package info.aundre.restapi_project_hw2;

import java.util.List;
import java.util.ArrayList;

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
        // Hard-code User's and their values
        List<User> users = new ArrayList<>();
        users.add(new User("Bret", "bretrock", 1));
        users.add(new User("Antonette", "antwon", 2));
        users.add(new User("Samantha", "sammy", 3));
        users.add(new User("Karianne", "kar", 4));
        users.add(new User("Kamren", "killakam", 5));
        users.add(new User("Leopoldo_Corkery", "leodavinci", 6));
        users.add(new User("Elwyn.Skyles", "elsky", 7));
        users.add(new User("Maxime_Nienow", "niemax", 8));
        users.add(new User("Delphine", "dolphin", 9));
        users.add(new User("Moriah.Stanton", "mstanton", 10));

        // Iterate through list and compare and validate credentials
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}