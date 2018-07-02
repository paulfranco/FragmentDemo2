package co.paulfran.paulfranco.fragmentdemo2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
    }

    public void addFragmentA(View view) {

        Fragment fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "FragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null){
            transaction.remove(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void addFragmentB(View view) {
        Fragment fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "FragB");
        transaction.commit();
    }

    public void remFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("FragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null){
            transaction.remove(fragmentB);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment B not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "FragA");
        transaction.commit();

    }

    public void replaceByFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "FragB");
        transaction.commit();
    }

    public void attachFragmentA(View view) {

        // Get Reference to the detached fragment
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "FragmentA not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void detachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "FragmentA not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.show(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "FragmentA not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.hide(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "FragmentA not found", Toast.LENGTH_SHORT).show();
        }
    }
}
