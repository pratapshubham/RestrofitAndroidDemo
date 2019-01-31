package com.example.braintech.restrofitandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.braintech.restrofitandroiddemo.moedel.HealthList;
import com.example.braintech.restrofitandroiddemo.requestresponse.APIClient;
import com.example.braintech.restrofitandroiddemo.requestresponse.APIInterface;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private APIInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
   // private List<HealthList> healthLists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("EMPLOYEE DATA");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewShowData);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = APIClient.getClient().create(APIInterface.class);



        Call<HealthList> call = apiInterface.doGetHealth();

        call.enqueue(new Callback<HealthList>() {
            @Override
            public void onResponse(Call<HealthList> call, Response<HealthList> response) {

               if(response.isSuccessful()){

                    HealthList healthList = response.body();
                   ArrayList<HealthList.Value> data = healthList.getValue();
                    recyclerAdapter = new RecyclerAdapter(data);
                    recyclerView.setAdapter(recyclerAdapter);

                   Toast.makeText(MainActivity.this,"Number of Item in APi------>"+response.body().getValue().size()
                           ,Toast.LENGTH_SHORT).show();
                   System.out.println("Number of Item in APi------>"+data);
               }

            }

            @Override
            public void onFailure(Call<HealthList> call, Throwable t) {
                call.cancel();
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
