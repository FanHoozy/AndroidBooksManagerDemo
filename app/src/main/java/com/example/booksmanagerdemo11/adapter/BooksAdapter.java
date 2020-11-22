package com.example.booksmanagerdemo11.adapter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booksmanagerdemo11.R;
import com.example.booksmanagerdemo11.domain.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    private int layoutResource;
    private List<Book> bookList;
    Handler handler = new Handler();

    // 因为网络请求之后，产生的数据需要设置进来
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged(); // 数据更新后，刷新页面
    }

    public BooksAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BooksAdapter(int layoutResource) {
        this.layoutResource = layoutResource;
    }

    public BooksAdapter(int layoutResource, List<Book> bookList) {
        this.layoutResource = layoutResource;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutResource, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.bookItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Book book = bookList.get(position);
                Toast.makeText(v.getContext(), "id:" + book.getBook_id() + "作者：" + book.getAuthor()
                        , Toast.LENGTH_SHORT).show();
            }
        });
        
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Book book = bookList.get(position);
        holder.tvTitle.setText(book.getBook_name());
        holder.tvClassification.setText(book.getClassifying());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvNoLend.setText(book.getSize());
    }

    @Override
    public int getItemCount() {
        if (bookList != null) {
            return bookList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View bookItemView;
        TextView tvTitle;
        TextView tvAuthor;
        TextView tvClassification;
        TextView tvNoLend;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookItemView = itemView;
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvClassification = itemView.findViewById(R.id.tv_classification);
            tvNoLend = itemView.findViewById(R.id.tv_no_lend);
        }
    }
}
