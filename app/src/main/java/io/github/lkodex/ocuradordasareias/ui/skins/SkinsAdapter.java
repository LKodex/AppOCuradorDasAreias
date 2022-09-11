package io.github.lkodex.ocuradordasareias.ui.skins;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class SkinsAdapter extends BaseAdapter {
    private final Context context;
    private final List<Integer> skinsList;

    public SkinsAdapter(Context context, List<Integer> skinsList){
        this.context = context;
        this.skinsList = skinsList;
    }

    @Override
    public int getCount() {
        return skinsList.size();
    }

    @Override
    public Object getItem(int position) {
        return skinsList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource((int) getItem(position));
        imageView.setLayoutParams(new ViewGroup.LayoutParams(230, 230));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(20, 20, 20, 20);
        return imageView;
    }
}
