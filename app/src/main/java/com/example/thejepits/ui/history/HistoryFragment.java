package com.example.thejepits.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejepits.R;
import com.example.thejepits.databinding.FragmentHistoryBinding;
import com.example.thejepits.room.ItemModel;
import com.example.thejepits.room.MyItem;
import com.example.thejepits.util.AdapterRecycleView;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

private FragmentHistoryBinding binding;
    RecyclerView recyclerView2;
    AdapterRecycleView recyclerViewAdapter2;
    ArrayList<ItemModel> data2;
    private LinearLayoutManager recyclerViewLayoutManager2;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel notificationsViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

    binding = FragmentHistoryBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        recyclerView2 = root.findViewById(R.id.recyclerView2);

        recyclerViewLayoutManager2 = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(recyclerViewLayoutManager2);
        recyclerView2.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        data2 = new ArrayList<>();
        for (int i = 0; i < MyItem.Judul.length; i++) {
            data2.add(new ItemModel(
                    MyItem.Judul[i],
                    MyItem.Pengarang[i],
                    MyItem.Tahun[i],
                    MyItem.cover[i],
                    MyItem.Isi[i]
            ));
        }
        recyclerViewAdapter2 = new AdapterRecycleView(getContext(),data2);
        recyclerView2.setAdapter(recyclerViewAdapter2);

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}