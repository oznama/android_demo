package com.uver.pymes.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class UserDetailTabsAdapter extends FragmentStatePagerAdapter {

    private int count;
    private UserDetailMainFragment userDetailMainFragment;

    public UserDetailTabsAdapter(FragmentManager fm, int behavior, UserDetailMainFragment userDetailMainFragment) {
        super(fm, behavior);
        this.count = behavior;
        this.userDetailMainFragment = userDetailMainFragment;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                //UserDetailMainFragment main = new UserDetailMainFragment();
                //return main;
                return userDetailMainFragment;
            case 1:
                UserDetailCoursesFrament courses = new UserDetailCoursesFrament();
                return courses;
            case 2:
                UserDetailFeedbackFragment feedback = new UserDetailFeedbackFragment();
                return feedback;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
