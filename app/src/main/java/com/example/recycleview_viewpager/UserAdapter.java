package com.example.recycleview_viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserView>{

    private List<User> mlistUser;
    private Context mcontext;

    public UserAdapter(Context context,List<User> listUser) {
        this.mlistUser = listUser;
        this.mcontext  = context;
    }

    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_interface,parent,false);
        return new UserView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserView holder, int position) {
        User user = mlistUser.get(position);
        if(user == null){
            return;
        }else{
            holder.imgAvatar.setImageResource(user.getResourceId());
            holder.tvName.setText(user.getName());
            holder.tvAdress.setText(user.getAdress());

            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickGoToDetail(user);
                }
            });
        }
    }

    private void onClickGoToDetail(User user) {
        Intent intent =new Intent(mcontext,DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Object User",user);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mlistUser != null){
            return mlistUser.size();
        }
        return 0;
    }

    public class UserView extends RecyclerView.ViewHolder{

        private ImageView imgAvatar;
        private TextView tvName;
        private TextView tvAdress;
        private RelativeLayout relativeLayout;

        public UserView(@NonNull View itemView) {
            super(itemView);

            imgAvatar   = itemView.findViewById(R.id.imgIcon);
            tvName      = itemView.findViewById(R.id.etName);
            tvAdress    = itemView.findViewById(R.id.etAdress);
            relativeLayout = itemView.findViewById(R.id.relativeLayout_user);
        }
    }
}
