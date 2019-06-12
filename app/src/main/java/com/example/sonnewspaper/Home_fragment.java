package com.example.sonnewspaper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Random;

public class Home_fragment extends Fragment {
    private static final String KEY_LAYOUT = "sontit";
    private static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";
    SwipeRefreshLayout srl;
    RecyclerView recyclerView;
    NewpostAdapter adapter;
    ArrayList<NewPost> arrayList;
    String url = "https://baomoi.com/";
    public Home_fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("vongdoi","oncreatViewHOme");
        // ánh xạ
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        anhxa(view);
        setuprecyclerview();
        mess();
        sukienswipe();
        final Activity activity = getActivity();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && activity.findViewById(R.id.bottomnavigation).isShown()) {
                    activity.findViewById(R.id.bottomnavigation).setVisibility(View.GONE);
                } else if (dy < 0 ) {
                    activity.findViewById(R.id.bottomnavigation).setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        return view;
    }
    // lấy data
    private void mess()
    {
         String url =  "https://baomoi.com/";

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                arrayList.clear();
                Document document = Jsoup.parse(response);
                Elements items = document.select(".story");

                for(Element i:items)
                {
                    String linkthumbail = i.select(".story__thumb a img").attr("src");
                    String tittle = i.select(".story__heading a").text();
                    String timeago = i.select(".story__meta .time").attr("datetime");
                    String linkpost = "https://baomoi.com" + i.select(".story__heading a").attr("href");
                    if(!(linkthumbail.length() == 0 || tittle.length() == 0 || timeago.length() == 0 || linkpost.length() ==0))
                    {
                        arrayList.add(new NewPost(linkthumbail,tittle,timeago,linkpost));
                    }

                }
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    // bắt sự kiện swipe
    private  void sukienswipe()
    {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mess();
                Toast.makeText(getActivity(), "Đã refresh", Toast.LENGTH_SHORT).show();
                srl.setRefreshing(false);
            }
        });
    }
    // ánh xạ
    private void anhxa(View view)
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        srl = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        srl.setColorSchemeColors(color);
        arrayList = new ArrayList<>();
    }
    // set up recyclerview
    private void setuprecyclerview()
    {
        adapter = new NewpostAdapter(getActivity(),arrayList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    // vòng đời


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("vongdoi","oncreatHOme");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("vongdoi","onStartHOme");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("vongdoi","onresumeHOme");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("vongdoi","oncreatPauseHOme");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("vongdoi","onstopHOme");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("vongdoi","ondestroyViewHOme");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("vongdoi","ondestroyHOme");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("vongdoi","ondetachHOme");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("vongdoi","onAtacKHOme");
    }
}
