package com.example.reviewcycleassignment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewcycleassignment.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyHolder> {

    List<User> userlist = new ArrayList<>();
    Context context;


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyRVAdapter(List<User> userlist, Context context) {
        this.userlist = userlist;
        this.context = context;
    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userlayout,parent,false);
        MyHolder myholder = new MyHolder(view);
        return myholder;
    }


    // Replace the contents of a view
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final  User user = userlist.get(position);



        String uri = "@drawable/" + user.getImage();
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable image = ContextCompat.getDrawable(context, imageResource);

        holder.imageview.setImageDrawable(image);
        holder.username.setText(user.getName());


        holder.username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(context, Individual_Detail_Activity.class);
                intent1.putExtra("name",user.getName());
                intent1.putExtra("gender",user.getGender());
                intent1.putExtra("dob",user.getDob());
                intent1.putExtra("country",user.getCountry());
                intent1.putExtra("phone",user.getPhone());
                intent1.putExtra("email",user.getEmail());
                intent1.putExtra("image",user.getImage());

                context.startActivity(intent1);
             //   Toast.makeText(context,user.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return userlist.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageview;
        TextView username;
       public MyHolder(@NonNull View itemView) {
           super(itemView);
           imageview = itemView.findViewById(R.id.userimage);
           username = itemView.findViewById(R.id.username);
       }
   }
}
