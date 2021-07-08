package com.example.recycleviewclick;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

class StudentViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvStudentImg;
    private TextView tvName;
    private TextView tvAge;
    private TextView tvAddress;
    private TextView tvDob;
    private RelativeLayout mRelativeLayout;
    private ItemClickListener itemClickListener;
    public StudentViewHolder(@NonNull View itemView,ItemClickListener itemClickListener){
        super(itemView);
        this.itemClickListener=itemClickListener;
        iniView(itemView);
    }
    private void iniView(View itemView){
        mIvStudentImg=itemView.findViewById(R.id.ivStudentImg);
        tvName =itemView.findViewById(R.id.tvName);
        tvAddress =itemView.findViewById(R.id.tvAddress);
        tvAge =itemView.findViewById(R.id.tvAge);
        tvDob =itemView.findViewById(R.id.tvDob);
        mRelativeLayout =itemView.findViewById(R.id.relativeLayout);

    }
    public void setData(StudentModel studentModel){
        mIvStudentImg.setImageResource(studentModel.getImageId());
        tvName.setText(studentModel.getName());
        tvAge.setText(studentModel.getAge());
        tvAddress.setText(studentModel.getAddress());
        tvDob.setText(studentModel.getDOB());

        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(studentModel,getAdapterPosition());
            }
        });
    }

}
