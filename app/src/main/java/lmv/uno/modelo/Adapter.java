package lmv.uno.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import lmv.uno.R;

public class Adapter extends BaseAdapter{
    private Context context;
    private List<Carta> cartas;

    public Adapter(Context context, List<Carta> cartas) {
        this.context = context;
        this.cartas = cartas;
    }

    @Override
    public int getCount() {
        return cartas.size();
    }

    @Override
    public Object getItem(int position) {
        return cartas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        Carta item = cartas.get(position);

        // Load your image into the ImageView using a library like Glide or Picasso
        // For example, using Glide:
        Glide.with(context)
                .load(item.getImagemCarta()) // Replace with your image URL or resource
                .into(imageView);
        // Bind other data to your views here if needed

        return convertView;
    }
}
