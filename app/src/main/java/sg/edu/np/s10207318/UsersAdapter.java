package sg.edu.np.s10207318;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder>{
    ArrayList<User> data;

    public UsersAdapter(ArrayList<User> input){
        data = input;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.username7,
                    parent,
                    false
            );
        } else {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.activity_user_view_holder,
                    parent,
                    false
            );
        }
        return new UserViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(data.get(position).name.substring(data.get(position).name.length()-1));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User u = data.get(position);
        holder.name.setText(u.name);
        holder.description.setText(u.description);


        holder.img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Debug", "Image clicked");

                new AlertDialog.Builder(holder.img.getContext())
                        .setTitle("Profile")
                        .setMessage(u.name)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(holder.img.getContext(), MainActivity.class);
                                viewProfile.putExtra("id", position);
                                holder.img.getContext().startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}