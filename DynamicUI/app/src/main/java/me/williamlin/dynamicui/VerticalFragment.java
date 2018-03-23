package me.williamlin.dynamicui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by william on 3/4/18.
 */

public class VerticalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vertical_fragment_layout, container, false);
        return view;
    }

//    public void toggleList(){
//        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.list_fragment);
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        if (fragment.isHidden()) {
//            transaction.show(fragment);
//            Log.d("hidden","Show");
//        } else {
//            transaction.hide(fragment);
//            Log.d("Shown","Hide");
//        }
//
//        transaction.commit();
//    }
}
