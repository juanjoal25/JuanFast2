package com.upb.myrestaurantevirtual;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.myrestaurantevirtual.databinding.ActivitySedeBinding;

import java.util.WeakHashMap;

public class SedeActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter {


    private GoogleMap mMap;
    private ActivitySedeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySedeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Laureles = new LatLng(6.2546184, -75.6041257);
        LatLng Itagui = new LatLng(6.1770229, -75.6347531);
        LatLng Medellin = new LatLng(6.242304, -75.579392);
        LatLng Poblado = new LatLng(6.209337, -75.5702626);
        LatLng Centro = new LatLng(6.2645809, -75.5681631);
        LatLng Envigado = new LatLng(6.1664754, -75.6025179);

        //creacion de marcadores para las sedes

        Marker markerLaureles = mMap.addMarker(new MarkerOptions()
                .position(Laureles)
                .title("Laureles")
                .snippet("Cra. 47, 56-101, Medellín, JuanFast"));
        markerLaureles.setTag(R.drawable.laureles);

        Marker markerItagui = mMap.addMarker(new MarkerOptions()
                .position(Itagui)
                .title("Itagui")
                .snippet("Cl. 56a #n 57 24, Villa Paula, Itagüi, Antioquia, JuanFast"));
        markerItagui.setTag(R.drawable.itagui);

        Marker markerPoblado = mMap.addMarker(new MarkerOptions()
                .position(Poblado)
                .title("Poblado")
                .snippet("Carrera 37a 9 9A Zona Rosa, Poblado District, Medellín, JuanFast"));
        markerPoblado.setTag(R.drawable.poblado);

        Marker markerCentro = mMap.addMarker(new MarkerOptions()
                .position(Centro)
                .title("Centro")
                .snippet("Cra. 54 #46-55, La Candelaria, Medellín, JuanFast"));
        markerCentro.setTag(R.drawable.centro);

        Marker markerEnvigado = mMap.addMarker(new MarkerOptions()
                .position(Envigado)
                .title("Envigado")
                .snippet("Carrera 43a #29 sur 85, Envigado, JuanFast"));
        markerEnvigado.setTag(R.drawable.envigado);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Medellin));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMinZoomPreference(12f);

        mMap.setInfoWindowAdapter(this);


    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        return null;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        View view = getLayoutInflater().inflate(R.layout.info_mapas, null);

        // Obtener referencias a las vistas
        ImageView imageView = view.findViewById(R.id.info_window_image);
        TextView titleView = view.findViewById(R.id.info_window_title);
        TextView snippetView = view.findViewById(R.id.info_window_snippet);

        // Configurar la imagen y el texto
        titleView.setText(marker.getTitle());
        snippetView.setText(marker.getSnippet());

        // Obtener el identificador de la imagen asociada al marcador
        Integer imageResId = (Integer) marker.getTag();
        if (imageResId != null) {
            imageView.setImageResource(imageResId); // Configurar la imagen
        } else {
            // Imagen por defecto si no hay ninguna asociada
            imageView.setImageResource(R.drawable.myrestaurantemenu);
        }

        return view;

    }
}