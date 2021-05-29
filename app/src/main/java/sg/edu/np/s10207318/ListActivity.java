package sg.edu.np.s10207318;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.content.DialogInterface;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    static ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        DBHandler db = new DBHandler(this);
        userList = db.getUser();

        userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User u = new User();
            u.name = "Name" + new Random().nextInt();
            u.description = "Description " + new Random().nextInt();
            u.followed = new Random().nextInt() % 2 == 0;
            userList.add(u);
        }

        RecyclerView rv = findViewById(R.id.rv);
        UsersAdapter itemsAdapter = new UsersAdapter(userList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(itemsAdapter);
    }
}

        /*ImageView img = findViewById(R.id.profilebtn);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Debug", "Image clicked");

                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Profile")
                        .setMessage("MADness")
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(ListActivity.this, MainActivity.class);
                                viewProfile.putExtra("id", new Random().nextInt());
                                startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();

            }
        });*/



