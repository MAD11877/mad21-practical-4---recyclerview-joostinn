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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> data = new ArrayList<User>();
        for(int i=0; i<20; i++)
        {
            User u = new User();
            u.setName("Name" + new Random().nextInt(1000000000));
            u.setDescription("Description " + new Random().nextInt(1000000000));
            u.setId(i);
            data.add(u);
        }

        RecyclerView rv = findViewById(R.id.rv);
        UsersAdapter adapter = new UsersAdapter(this, data);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

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
    }


}