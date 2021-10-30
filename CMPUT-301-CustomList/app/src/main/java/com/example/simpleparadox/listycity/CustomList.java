package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this function will get the size of list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this function will add a city into the list
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }


    /**
     * Return boolean tells if certain city is in the list
     * @param city
     *        Prospective city to check in the city list
     * @return
     *        A boolean value to tell if the city is in the list
     */

    public boolean hasCity(City city){
        boolean has_city = false;
        for (int i = 0; i < cities.size(); i++){
            if (city == cities.get(i)){
                has_city = true;
            }
        }
        return has_city;
    }


    /**
     * This method delete a city from cityList
     * @param city
     *      Prospective city to delete from the list
     */
    public void delete(City city){
        if (!(cities.contains(city))){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }



    /**
     * This method returns how many cities are in the list
     * @return
     *      An integer value tells how many cities does the list have
     */

    public int countCities(){
        int count = cities.size();
        return count;
    }


}
