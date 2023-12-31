package com.example.bankapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bankapp.adapter.ProfileAdapter;
import com.example.bankapp.model.MInbox;
import com.example.bankapp.model.MPersonalData;
import com.example.bankapp.model.MProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private ProfileAdapter adapter;
    private List<MProfile> profileItems;
    private ArrayList<MPersonalData> personalData = new ArrayList<>();
    TextView ProfileName;
    String email;
    String username;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        ProfileName = rootView.findViewById(R.id.profile_name);

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        ProfileName.setText(name);

        recyclerView = rootView.findViewById(R.id.recyclerViewProfile);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        profileItems = new ArrayList<MProfile>();

        profileItems.add(new MProfile(R.drawable.personalcard,"Personal Data"));
        profileItems.add(new MProfile(R.drawable.setting,"Settings"));

        // Create an adapter and set it to the RecyclerView
        adapter = new ProfileAdapter(profileItems, ProfileFragment.this, ProfileFragment.this);
        recyclerView.setAdapter(adapter);

        Button LogoutButton = rootView.findViewById(R.id.logoutButton);
        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start LoginActivity when the button is clicked
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(getActivity(), EditProfileActivity.class);

        startActivity(intent);
    }
}