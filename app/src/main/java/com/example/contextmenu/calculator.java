package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * @since 16/11/19
 * @author Ido
 * @version 0.01
 */
public class calculator extends AppCompatActivity implements AdapterView.OnItemLongClickListener, View.OnCreateContextMenuListener  {
    Double[] Series = new Double[20];
    ListView lv;
    double diff, first;
    int kind, pos;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        lv = findViewById(R.id.lv);
        /**
         * set adapters on the ListView
         */
        lv.setOnItemLongClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnCreateContextMenuListener(this);

        /**
         * get the values from the intent.
         */
        Intent gi= getIntent();
        diff = gi.getDoubleExtra("diff", -5);
        first = gi.getDoubleExtra("firstNum", 1);
        kind = gi.getIntExtra("kind", 1);
        tv = findViewById(R.id.textView4);

        /**
         * checking the kind of the action
         */
        Series[0] = first;
        if(kind == R.id.Invoice) {
            Series = Invoid(Series, diff);
        } else{
            Series = Geomtric(Series, diff);
        }

        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, R.layout.support_simple_spinner_dropdown_item, Series);

        lv.setAdapter(adp);


    }

    /**
     *
     * @param menu
     * @param v
     * @param menuInfo
     * Adding values to the context menu.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Please choose an action");
        menu.add("sum");
        menu.add("index");
    }

    /**
     * when clikced sum sochem all the items from the start to the index chosen.
     * when click on index showing the index of the item.
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle().toString().equals("index")){
            tv.setText(""+pos);
        } else{
            int sum = 0;
            for(int i = 0; i<pos; i++){
                sum += Series[i];
            }
            tv.setText(""+ sum);
        }

        return true;
    }

    /**
     * setting the position value of the item clicked on local int.
     * @param parent
     * @param view
     * @param position
     * @param id
     * @return
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position+1;

        return false;

    }

    /**
     * Calculeting and put the items of the invoid series in array.
     * @param Series
     * @param diff
     * @return the array hafnia with the values.
     */
    public static Double[] Invoid(Double Series[], double diff){
        for(int i = 1; i<Series.length; i ++){
            Series[i] = Series[i-1]+ diff;
        }
        return Series;
    }

    /**
     * Calculeting and put the items of the Geomtric series in array.
     * @param Series
     * @param diff
     * @return the array hafnia with the values
     */
    public static Double[] Geomtric(Double Series[], double diff){
        for(int i = 2; i<Series.length+1; i ++){
            Series[i-1] = Series[0]*Math.pow(diff, i-1);
        }
        return Series;
    }


    /**
     * returnnig to main activity.
     * @param view
     */
    public void Back(View view) {
        finish();
    }


    /**
     * move to the credits activ.
     * @param view
     */
    public void Credits(View view) {
        Intent credit = new Intent(this, Credits.class);
        startActivity(credit);
    }
}

