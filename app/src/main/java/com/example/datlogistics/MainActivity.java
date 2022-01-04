package com.example.datlogistics;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.datlogistics.ui.Fragment.Goihang_Fragment;
import com.example.datlogistics.ui.Fragment.Vi_tri_Fragment;
import com.example.datlogistics.ui.Fragment.trangchu_Fragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
  //  private static final  int FRAGMENT_DANGKI =1;
    private static final  int FRAGMENT_TRANGCHU =1;
    private static final  int FRAGMENT_GOIHANGCUATOI =2;
    private static final  int FRAGMENT_VITRI =3;

    private int currentFragment =  FRAGMENT_TRANGCHU ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

      //  replaceFrament(new trangchu_Fragment());

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_trangchu, R.id.nav_goihangcuatoi, R.id.nav_vitri ,R.id.nav_dangnhap)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_dangnhap){
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                if(id == R.id.nav_trangchu){
                    if( FRAGMENT_TRANGCHU != currentFragment){
                        replaceFrament(new trangchu_Fragment());
                        currentFragment = FRAGMENT_TRANGCHU;
                    }
                }
                if(id == R.id.nav_goihangcuatoi){
                    if( FRAGMENT_GOIHANGCUATOI != currentFragment){
                        replaceFrament(new Goihang_Fragment());
                        currentFragment = FRAGMENT_GOIHANGCUATOI;
                    }
                }
                if(id == R.id.nav_vitri){
                    if( FRAGMENT_VITRI != currentFragment){
                        replaceFrament(new Vi_tri_Fragment());
                        currentFragment = FRAGMENT_VITRI;
                    }
                }
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });

    }

    private void replaceFrament(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conten_fragment,fragment);
        fragmentTransaction.commit();
    }

//    public void CatchOnItemListView(){
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.nav_dangnhap){
//            Intent intent = new Intent(MainActivity.this, Login.class);
//            startActivity(intent);
//        }
//        if(id == R.id.nav_trangchu){
//            if( FRAGMENT_TRANGCHU != currentFragment){
//                replaceFrament(new trangchu_Fragment());
//                currentFragment = FRAGMENT_TRANGCHU;
//            }
//        }
//        if(id == R.id.nav_goihangcuatoi){
//            if( FRAGMENT_GOIHANGCUATOI != currentFragment){
//                replaceFrament(new Goihang_Fragment());
//                currentFragment = FRAGMENT_GOIHANGCUATOI;
//            }
//        }
//        if(id == R.id.nav_vitri){
//            if( FRAGMENT_VITRI != currentFragment){
//                replaceFrament(new Vi_tri_Fragment());
//                currentFragment = FRAGMENT_VITRI;
//            }
//        }
//        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }


}