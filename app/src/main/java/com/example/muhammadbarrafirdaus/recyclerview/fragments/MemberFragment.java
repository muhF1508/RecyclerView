package com.example.muhammadbarrafirdaus.recyclerview.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muhammadbarrafirdaus.recyclerview.R;
import com.example.muhammadbarrafirdaus.recyclerview.adapter.MemberListAdapter;
import com.example.muhammadbarrafirdaus.recyclerview.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberFragment extends Fragment{
    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;

    protected Context context;

    public static MemberFragment newInstance(){
        return new MemberFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member, container, false);

        listMember = (RecyclerView) rootView.findViewById(R.id.listmember);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);

        loadData();
    }

    private void loadData(){
        List<Member> memberList = new ArrayList<>();
        Member member;

        int thumb[] = {R.drawable.cow, R.drawable.elephant, R.drawable.monkey,
                R.drawable.moose, R.drawable.ostrich, R.drawable.penguin,
                R.drawable.bee, R.drawable.crab, R.drawable.crocodile,
                R.drawable.frog, R.drawable.giraffe, R.drawable.dolphin,
                };

        String name[] = {"Sapi", "Gajah", "Monyet", "Rusa",
                "Burung Onta", "Penguin", "lebah", "Kepiting",
                "Buaya", "Katak", "Jerapah", "Lumba-lumba",
                };

        String team = "Macam-macam Hewan";

        for(int i=0; i < thumb.length; i++){
            member = new Member();

            member.setId(i+1);
            member.setName(name[i]);
            member.setTeam(team);
            member.setThumb(thumb[i]);

            memberList.add(member);
        }

        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
