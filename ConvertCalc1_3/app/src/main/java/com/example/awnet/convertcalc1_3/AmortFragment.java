package com.example.awnet.convertcalc1_3;

/**
 * StealthPavilion
 *
 * Simple Amortization App.  Accepts three inputs and gives one output
 *
 *Imports:
 *     Bundle -- Used to pass data between activities.  Size of data matters
 *     in some instances
 *     NonNull/Nullable -- indicates parameters that not be null or return
 *     a variable that cannot be null and visa versa.
 *     Fragment -- https://developer.android.com/guide/components/fragments#Design
 *          The only way to give Fragment any justice is to read the actual Dev Docs.
 *          Fragments are a way of handling and viewing data.  There is a slight difference
 *          betwen Fragments and Activites.  Fragment was chosen due to Activity becoming outdated
 *     LayoutInflater -- Instantiates or gets layout from XML file.  Works in conjunction with View
 *     View/ViewGroup -- Handles onscreen events such as EditText, TextView, Button.  The latter draw
 *          objects on the screen for future use.
 */



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


/**
 * Amort Class stores functions for the Amortization calculation
 * Views are named and made private as they can also be used in other classes.
 */


public class AmortFragment extends Fragment {
    private EditText numMonths;
    private EditText borrowAmount;
    private EditText numRate;
    private TextView numTotal;
    private Button CalButt;

    /**
     * Variables are created.  Names appear as is due to being frustrated with the calculation and divide by zero error
     *
     */
    double interest;
    double dFactor;
    double powpow;
    double bowwow;
    double goingbonkers;
    double dFactors;
    double intRate = 0.0;
    double intRata = 0.0;
    double intRataFin = 0.0;
    double icanttakeit = 0.0;

    double almostthere = 0.0;

    double itsover = 0.0;

    /**
     * getMonths Method
     *
     * Accepts a string as a variable and converts it to a Integer or Double.  Android Studio(AS)
     * gives a yellow warning as there is another way to due this.  AS also gives warning as some
     * javadocs are dangling or do not belong to a class
     *
     * Calculation is broken down to the nearest operation as it keeps giving divide by zero error.
     */

    public void getMonths(){
        String Months = numMonths.getText().toString();
        String Rate = numRate.getText().toString();
        String Amount = borrowAmount.getText().toString();
        //String message =" ";

        double Mths1 = Integer.parseInt(Months);
        double Rt1 = Double.parseDouble(Rate);
        double bA = Integer.parseInt(Amount);
//Calcuation broken down to each component.
        double moreMonths = 12 * Mths1;
        double Rtl1a = Rt1 / 1200.00;

        intRate  = 1 + Rtl1a;
        intRata = Math.pow(intRate,moreMonths);
        intRataFin = intRata - 1;
        icanttakeit = Math.pow((1+Rtl1a),moreMonths);
        goingbonkers = (Rtl1a * icanttakeit);
        almostthere = intRataFin/goingbonkers;

        itsover = bA / almostthere;
        /**
        //Math was commented out due to divide by zero error.
        //dFactor = (Math.pow(powpow,moreMonths) - 1)  / (Math.pow(bowwow,moreMonths));
        //dFactors = bA / dFactor;
        //message = String.format("%.0f", itsover);
         */

        numTotal.setText(String.format("%.0f", itsover));



    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     *
     * Part of the Fragment family.  Specifies the view and saves the instance of the view upon rotation of the device.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_amort, container, false);


    }

    /**
     *
     * @param view
     * @param savedInstanceState
     *
     * Part of the Fragment Family.  References the graphical view in the XML file fragment_amort
     */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        borrowAmount = (EditText) view.findViewById( R.id.borrowAmount );
        numMonths = (EditText) view.findViewById(R.id.numMonths);
        numRate = (EditText) view.findViewById(R.id.numRate);
        numTotal = (TextView) view.findViewById(R.id.numTotal);
        CalButt = (Button) view.findViewById(R.id.CalButt);
// As Mr. Whitehouse would put it, "Gives the button ears" or listens for the event.
        CalButt.setOnClickListener( new View.OnClickListener() {
            /**
             *
              * @param v
             * Referenes the view.  One the button  is clicked, the program goes through the calculation.
             */
            @Override
            public void onClick(View v) {
                getMonths();
            }
        } );




    }
}
