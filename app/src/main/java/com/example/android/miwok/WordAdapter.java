package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jalaj on 7/10/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    private int mcolorId;
    public WordAdapter(Context context, ArrayList<Word> words,int colorId){

super(context,0,words);//passing actual parameters to the Parent Class which we extended.'0' as parameter as there is a custom layout file resource
        mcolorId = colorId ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//getView() is called by listView to ArrayAdapter for next view to be inflated.
        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;// This is the view to be reused which is sent by listview.

        /** The next 3 lines of code are used whenever the activity isfirst created at time of which it does not have any view in scrap pile
        to be recycled and hence the value sent by convertView is null as there is no view and hence in that case a layout is inflated on own
         using layoutInflator.So this code of 3 lines become useless once all view ie starting 5-6 views are created on the screen and
         after that there is a view to be recycled in scrap pile of listView.**/

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate( // basically layoutInflator is used when we want to have a layout.xml file inflated or created in a View itself.
                    R.layout.list_item_layout, parent, false); // 'parent' refers to passing of parent view which is listView and 'false' indicates that we dont want to attach the listItemView just now to the listView as we have to modify it and return it later.
        }

        // Get the {@link Word} object of Word class located at this position in the list(ArrayList in our case) and the getItem method is predefined in the ArrayAdapter SuperClass.
        Word currentWord = getItem(position);

        // Find the TextView in the list_item_layout.xml layout with the ID version_name
        TextView miwok = (TextView) listItemView.findViewById(R.id.miwok); // here list_item_view acts as the root View
        // Get the version name from the current Word object and
        // set this text on the name TextView
        miwok.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView english = (TextView) listItemView.findViewById(R.id.english);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        english.setText(currentWord.getDefaultTranslation());

        // For setting textview color depending on different activities

            miwok.setBackgroundResource(mcolorId);
            english.setBackgroundResource(mcolorId);


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current Word object and
        // set the image to iconView
        int imageResourceId = currentWord.getImageResourceId();

        if (imageResourceId == -1) // manipulating  the code to work with phrasesActivity.
            iconView.setVisibility(View.GONE);
        else {
            iconView.setBackgroundResource(R.color.tan_background);
            iconView.setImageResource(imageResourceId);
            iconView.setVisibility(View.VISIBLE);
        }
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}








