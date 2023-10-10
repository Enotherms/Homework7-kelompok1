package com.example.bankapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bankapp.adapter.GridAdapter;
import com.example.bankapp.databinding.FragmentPocketBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PocketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PocketFragment extends Fragment {

    EditText Balance;
    ImageButton ShowHideButton;
    private boolean isTextVisible = true;
    private FragmentPocketBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PocketFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PocketFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PocketFragment newInstance(String param1, String param2) {
        PocketFragment fragment = new PocketFragment();
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
        // Inflate the layout for this fragment

        binding = FragmentPocketBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ShowHideButton = (ImageButton) view.findViewById(R.id.showHideButtonPocket);

        binding.balancePocket.setClickable(false);
        binding.balancePocket.setFocusable(false);

        String[] pocketName = {"Main Pocket", "Travelling", "Social", "Savings", "Investment"};
        String[] pocketMoney ={"Rp. 250.000", "Rp. 100.000", "Rp. 250.000", "Rp. 200.000", "Rp. 200.000"};

        GridAdapter gridAdapter = new GridAdapter(requireContext(), pocketName, pocketMoney);
        binding.gridView.setAdapter(gridAdapter);

        ShowHideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isTextVisible = !isTextVisible;

                if (isTextVisible) {
                    binding.balancePocket.setTransformationMethod(null);
                } else {
                    binding.balancePocket.setTransformationMethod(new PasswordTransformationMethod());
                }
                binding.balancePocket.setSelection(binding.balancePocket.getText().length());
            }
        });

        return view;
    }
}