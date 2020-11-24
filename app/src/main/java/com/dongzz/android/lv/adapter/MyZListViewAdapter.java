package com.dongzz.android.lv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dongzz.android.lv.R;
import com.dongzz.android.lv.model.BlogData;

import java.util.List;

/**
 * ZListView 适配器
 */
public class MyZListViewAdapter extends BaseAdapter {

    private Context mContext; //上下文
    private List<BlogData> mList; //数据

    public MyZListViewAdapter(Context context, List<BlogData> list) {
        this.mContext = context;
        this.mList = list;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public BlogData getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 渲染 列表项 视图和数据
     *
     * @param position    位置
     * @param convertView 列表项视图
     * @param parent      父级视图
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_zlv, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh); // 缓存 ViewHolder
        } else {
            vh = (ViewHolder) convertView.getTag(); // 直接获取 缓存的 ViewHolder
        }

        //设置 数据
        BlogData b = mList.get(position);
        vh.tvId.setText("ID：" + b.getId());
        vh.tvTitle.setText("标题：" + b.getTitle());
        vh.tvAuthor.setText("作者：" + b.getAuthor());

        return convertView;
    }

    /**
     * 列表项 视图
     */
    public class ViewHolder {

        public View view; //列表项 视图
        public TextView tvId;
        public TextView tvTitle;
        public TextView tvAuthor;

        public ViewHolder(View itemView) {
            view = itemView;
            tvId = itemView.findViewById(R.id.tv_id);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthor = itemView.findViewById(R.id.tv_author);
        }


    }
}
