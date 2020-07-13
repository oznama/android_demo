package com.uver.pymes.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.uver.pymes.R;
import com.uver.pymes.object.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserDetailMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserDetailMainFragment extends Fragment {

    private final String LOGGER = "UserDetailMainFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_USER = "user";
    private static final String ARG_IS_ADMIN = "isAdmin";

    // TODO: Rename and change types of parameters
    private User user;
    private boolean isAdmin;

    private EditText firstName, lastName, phone, hireDate, supervisor, location, degree, school;

    public UserDetailMainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param user User detail.
     * @param isAdmin Is user Admin.
     * @return A new instance of fragment UserDetailMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserDetailMainFragment newInstance(User user, boolean isAdmin) {
        UserDetailMainFragment fragment = new UserDetailMainFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_USER, user);
        args.putBoolean(ARG_IS_ADMIN, isAdmin);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(LOGGER, "Creating fragment");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Log.d(LOGGER, "Loading arguments");
            user = (User) getArguments().getSerializable(ARG_USER);
            isAdmin = getArguments().getBoolean(ARG_IS_ADMIN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOGGER, "Creating view");
        View view = inflater.inflate(R.layout.user_detail_main, container, false);
        firstName = (EditText) view.findViewById(R.id.user_detail_et_firstName);
        firstName.setEnabled(isAdmin);
        lastName = (EditText)view.findViewById(R.id.user_detail_et_lastName);
        lastName.setEnabled(isAdmin);
        phone = (EditText)view.findViewById(R.id.user_detail_et_phone);
        phone.setEnabled(isAdmin);
        hireDate = (EditText)view.findViewById(R.id.user_detail_et_hireDate);
        hireDate.setEnabled(isAdmin);
        supervisor = (EditText)view.findViewById(R.id.user_detail_et_supervisor);
        supervisor.setEnabled(isAdmin);
        location = (EditText)view.findViewById(R.id.user_detail_et_location);
        location.setEnabled(isAdmin);
        degree = (EditText)view.findViewById(R.id.user_detail_et_degree);
        degree.setEnabled(isAdmin);
        school = (EditText)view.findViewById(R.id.user_detail_et_school);
        school.setEnabled(isAdmin);
        setValues();
        return view;
    }

    private void setValues(){
        Log.d(LOGGER, "Setting values: " + user);
        if(user != null){
            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            phone.setText(user.getPhone());
            hireDate.setText(user.getHireDate());
            supervisor.setText(user.getSupervisor());
            location.setText(user.getLocation());
            degree.setText(user.getDegree());
            school.setText(user.getSchool());
        }
    }
}