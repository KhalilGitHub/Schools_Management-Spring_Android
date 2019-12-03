package org.hltic.sms_androidfrontend.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAccessorAdaptor extends FragmentPagerAdapter {


    public TabsAccessorAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 1:
                /*StudentDetailsFragment studentDetailsFragment = new StudentDetailsFragment();
                return studentDetailsFragment;
*/
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){

            case 0:
                return "Students List";

            case 1:
                return "Student Details";

            default:
                return null;
        }
    }
}

