package com.example.armando.fragmentsejemplos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.armando.fragmentsejemplos.Fragments.DosFragment;
import com.example.armando.fragmentsejemplos.Fragments.PageAdapter;
import com.example.armando.fragmentsejemplos.Fragments.UnoFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Comunicacion {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public boolean actualizarLista = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);

        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_cara_feliz_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_headset_black_24dp);

        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> Agregarfragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();

        fragments.add(new UnoFragment());
        fragments.add(new DosFragment());

        return fragments;
    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),Agregarfragments()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void enviarDatos(String mensaje) {
        DosFragment dosFragment;
        dosFragment = (DosFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        dosFragment.recibir(mensaje);
    }
}
