package com.example.bankapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankapp.adapter.InboxAdapter;
import com.example.bankapp.model.MInbox;

import java.util.ArrayList;
import java.util.List;

public class InboxFragment extends Fragment {

    private RecyclerView recyclerView;
    private InboxAdapter adapter;
    private List<MInbox> inboxItems;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InboxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InboxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InboxFragment newInstance(String param1, String param2) {
        InboxFragment fragment = new InboxFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_inbox, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerViewInbox);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize your inbox items list
        inboxItems = new ArrayList<MInbox>();

        inboxItems.add(new MInbox("Apriyani Penisa Damayanti","you have messages...."));
        inboxItems.add(new MInbox("Taufiqu Rahman","you have messages...."));
        inboxItems.add(new MInbox("Abiyyu Dhiyaul Haq","you have messages...."));
        inboxItems.add(new MInbox("M. Nasirudianto","you have messages...."));
        inboxItems.add(new MInbox("Charish Trisuard","you have messages...."));
        inboxItems.add(new MInbox("Gregoria Mariana S","you have messages...."));
        inboxItems.add(new MInbox("Decynta Putry","you have messages...."));
        inboxItems.add(new MInbox("Oktavia Rahmadiana","you have messages...."));
        inboxItems.add(new MInbox("Bendri Sepriadi Z","you have messages...."));
        inboxItems.add(new MInbox("M. Ilham Kurniawan","you have messages...."));

        // Create an adapter and set it to the RecyclerView
        adapter = new InboxAdapter(inboxItems);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
