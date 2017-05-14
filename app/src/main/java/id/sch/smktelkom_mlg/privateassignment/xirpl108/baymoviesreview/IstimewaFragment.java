package id.sch.smktelkom_mlg.privateassignment.xirpl108.baymoviesreview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static id.sch.smktelkom_mlg.privateassignment.xirpl108.baymoviesreview.R.id.recyclerViewIstimewa;


/**
 * A simple {@link Fragment} subclass.
 */
public class IstimewaFragment extends Fragment {

    ArrayList<IstimewaItem> fList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public IstimewaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_istimewa, container, false);

//        RecyclerView recyclerViewwe = (RecyclerView) view.findViewById(R.id.recyclerViewfav);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerViewwe.setLayoutManager(layoutManager);
//        fAdapter = new FavouriteAdapter(fList, getActivity().getApplicationContext());
//        recyclerViewwe.setAdapter(fAdapter);

        recyclerView = (RecyclerView) view.findViewById(recyclerViewIstimewa);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fList = new ArrayList<>();

        adapter = new IstimewaAdapter(fList, getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

//        FavouriteItem favouriteItem = FavouriteItem.findById(FavouriteItem.class, 1);
//        textView = (TextView) view.findViewById(R.id.textViewNdek);
//        textView.setText(favouriteItem.deskripsi);

        fList.addAll(IstimewaItem.listAll(IstimewaItem.class));
        adapter.notifyDataSetChanged();

        return view;
    }

//    @Override
//    public void doDelete(int pos)
//    {
//        final FavouriteItem favouriteItem = fList.get(pos);
//        fList.remove(pos);
//        fAdapter.notifyDataSetChanged();
//        Snackbar.Callback callback = new Snackbar.Callback()
//        {
//            @Override
//            public void onDismissed(Snackbar transientBottomBar, int event)
//            {
//                if (event != Snackbar.Callback.DISMISS_EVENT_ACTION)
//                    favouriteItem.delete();
//                super.onDismissed(transientBottomBar, event);
//            }
//        };
//    }

}
