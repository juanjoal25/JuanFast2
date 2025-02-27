package com.upb.myrestaurantevirtual;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PostresActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;
    private static ArrayList<info> l_postres= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_postres);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.listaPostres);
        listView.setAdapter(myAdapterMenu);
    }
    public void setData() {
        l_postres.clear();

        info postre1 = new info(
                getResources().getStringArray(R.array.Postres)[0],
                getResources().getStringArray(R.array.Postres)[1],
                R.drawable.milo
        );
        l_postres.add(postre1);

        info postre2 = new info(
                getResources().getStringArray(R.array.Postres)[2],
                getResources().getStringArray(R.array.Postres)[3],
                R.drawable.pie
        );
        l_postres.add(postre2);

        info postre3 = new info(
                getResources().getStringArray(R.array.Postres)[4],
                getResources().getStringArray(R.array.Postres)[5],
                R.drawable.helado2
        );
        l_postres.add(postre3);

        info postre4 = new info(
                getResources().getStringArray(R.array.Postres)[6],
                getResources().getStringArray(R.array.Postres)[7],
                R.drawable.oreo
        );
        l_postres.add(postre4);

        info postre5 = new info(
                getResources().getStringArray(R.array.Postres)[8],
                getResources().getStringArray(R.array.Postres)[9],
                R.drawable.fresas
        );
        l_postres.add(postre5);
    }
    public static class MyAdapterMenu extends BaseAdapter {
        private Context mContext;

        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_postres.size();
        }

        @Override
        public Object getItem(int position) {
            return l_postres.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("useCompatLoadingForDrawbles")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;

            if (convertView == null) {
                // Make up a new view
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.info_menu, null);
            } else {
                // Use convertView if it is available
                view = convertView;
            }

            // Example to get an image resource
            ImageView img = (ImageView) view.findViewById(R.id.image);
            img.setImageDrawable(mContext.getResources().getDrawable(l_postres.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_postres.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_postres.get(position).descripcion);

            return view;
        }
    }
}