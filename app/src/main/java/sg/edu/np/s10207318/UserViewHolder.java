package sg.edu.np.s10207318;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public TextView description;
    public View img;

    public UserViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        description = itemView.findViewById(R.id.txtDescription);
        img = itemView.findViewById(R.id.profileIcon);
    }
}