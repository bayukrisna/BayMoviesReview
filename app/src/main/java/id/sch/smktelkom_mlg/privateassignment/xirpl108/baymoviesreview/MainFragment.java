package id.sch.smktelkom_mlg.privateassignment.xirpl108.baymoviesreview;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String URL_DATA = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?api-key=1dbd2b147ea540e5b8788ec7ea7cb300";
    public List<MainListItem> mainListItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main2, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mainListItems = new ArrayList<>();

        loadRecyclerViewData();

        /*for (int i = 0; i <= 10; i++ )
        {
            HomeListItem listItem = new HomeListItem(


                    "heading" + (i+1),
                    "Lorem ipsum"

            );

            listItems.add(listItem);
        }

        adapter = new HomeAdapter(listItems, getActivity());

        recyclerView.setAdapter(adapter);*/
        return view;
    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading data ...");
        progressDialog.show();

        //tigas baris diatas untuk menampilkan laodinng dalam pengambilan data

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();//untuk memghilangkan loading saat data sdh di dapat.
                        try {
                            JSONObject jsonObject = new JSONObject(s);

                            JSONArray array = jsonObject.getJSONArray("results");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                MainListItem item = new MainListItem(
                                        o.getJSONObject("multimedia").getString("src"),
                                        o.getString("display_title"),
                                        o.getString("byline")
                                );
                                mainListItems.add(item);
                            }
                            adapter = new MainAdapter(mainListItems, getActivity().getApplication());//apabila di acyvity getactivity hanya ditulis this saja.
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity().getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

}
