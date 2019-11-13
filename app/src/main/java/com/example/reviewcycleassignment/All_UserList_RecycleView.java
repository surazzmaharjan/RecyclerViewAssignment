package com.example.reviewcycleassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.reviewcycleassignment.Model.User;

import java.util.List;

public class All_UserList_RecycleView extends AppCompatActivity {
    RecyclerView recyclerView;
//    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_userlist_recycle_view);


       recyclerView=findViewById(R.id.rvusers);

//       users.add(new User("momo","male","19-8-2016","nepal","5656","sd@g.c","yjy"));

        Intent intent = getIntent();

        final List<User> users = (List<User>)intent.getSerializableExtra("userlist");


        MyRVAdapter adapter = new MyRVAdapter(users,this);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
