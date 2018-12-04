package com.example.awnet.convertcalc1_3;

/**
 * //Calculator Fragment  Creates actions for all buttons.  Had issues with Fragment vs. AppCompatActivity.  Cannot have both.
//        * Fragment was called previously, therefore could not use Appompat
//        * awnetworking
//        * Stealth Pavilion
//

//imports: Edit and Buttons should be self explanatory.  Actions link to fragment_calculator.xml through num
 Imports:
    Fragment defines the view in conjuction with layout and View/ViewGroup
 Button and EditText reference the XML file and the graphics
 Bundles -- referres to how data is transferred between fragments
 */
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class CalculatorFragment extends Fragment {

    /**Button periodNum, clearNum, addNum, subNum, divNum, multNum, equalNum, oneNum, twoNum, threeNum, fourNum, fiveNum, sixNum, sevenNum, eightNum, nineNum, zeroNum;
    EditText calculate;
     This is the easier way to add variables to the Buttons.  Was originally used for testing
     */
// give two variables integers
    double nb1, nb2;
//boolean is not null or if aAdd is true then calculation...
    boolean aAdd, aSub, aMult, aDiv;

    /**
     * Javadoc is screeming here and is asking for tags.  More research needs to be done.
     * This view creates the calculator and references the XML file fragment_calculator.
     * @param inflater Instantiates a layout XML file into its corresponding View objects. It is never used directly.
     * @param container Holds the current view.
     * @param savedInstanceState Saves the current view.  If the screen is rotated, the view/fragment does not change
     * @return Returns the current view, fragment_calculator
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_calculator, container, false );

    }

    /**
     *
     * @param view creates the view buttons and screen color.  References the XML file by the use of R.id.
     *             R is an object which identifies views in the XML file
     * @param savedInstanceState  Same as above, saves the view so that it does not change to another view.
     */
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Button oneNum = view.findViewById( R.id.num1 );
        Button twoNum = view.findViewById( R.id.num2 );
        Button threeNum = view.findViewById( R.id.num3 );
        Button fourNum = view.findViewById( R.id.num4 );
        Button fiveNum = view.findViewById( R.id.num5 );
        Button sixNum = view.findViewById( R.id.num6 );
        Button sevenNum = view.findViewById( R.id.num7 );
        Button eightNum = view.findViewById( R.id.num8 );
        Button nineNum = view.findViewById( R.id.num9 );
        Button periodNum = view.findViewById( R.id.pNum );
        Button addNum = view.findViewById( R.id.addnum );
        Button subNum = view.findViewById( R.id.subnum );
        Button multNum = view.findViewById( R.id.multnum );
        Button divNum = view.findViewById( R.id.divnum );
        Button clearNum = view.findViewById( R.id.clearNum );
        final Button equalNum = view.findViewById( R.id.equalnum );
        final EditText calculate = view.findViewById( R.id.edit );

        Button zeroNum = view.findViewById( R.id.num0 );



        zeroNum.setOnClickListener( new View.OnClickListener() {
            /**
             *
             * @param v creates views and listeners (gives ears) to the buttons on screan.  If button
             *          pressed then show 0 - 9 or a calculation symbol.
             */
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "0" );
            }
        } );


        oneNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "1" );
            }
        } );
        twoNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "2" );
            }
        } );

        threeNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "3" );
            }
        } );
        fourNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "4" );
            }
        } );

        fiveNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "5" );
            }
        } );

        sixNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "6" );
            }
        } );

        sevenNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "7" );
            }
        } );

        eightNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "8" );
            }
        } );

        nineNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "9" );
            }
        } );

/**
 *
 */
        addNum.setOnClickListener( new View.OnClickListener() {
            /**
             *
             * @param v if nothing pressed then empty space else calculate the two integers nb1, nb2.
             *          Does not handle divide by zero well.
             */
            @Override
            public void onClick(View v) {

                if (calculate == null) {
                    calculate.setText( "" );
                } else {
                    nb1 = Double.parseDouble( calculate.getText() + "" );
                    aAdd = true;
                    calculate.setText( null );
                }
            }
        } );

        subNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb1 = Double.parseDouble( calculate.getText() + "" );
                aSub = true;
                calculate.setText( null );
            }
        } );

        multNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb1 = Double.parseDouble( calculate.getText() + "" );
                aMult = true;
                calculate.setText( null );
            }
        } );

        divNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb1 = Double.parseDouble( calculate.getText() + "" );
                aDiv = true;
                calculate.setText( null );
            }
        } );

        equalNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb2 = Double.parseDouble( calculate.getText() + "" );

                if (aAdd) {
                    calculate.setText( nb1 + nb2 + "" );
                    aAdd = false;
                }

                if (aSub) {
                    calculate.setText( nb1 - nb2 + "" );
                    aSub = false;
                }

                if (aMult) {
                    calculate.setText( nb1 * nb2 + "" );
                    aMult = false;
                }

                if (aDiv) {
                    calculate.setText( nb1 / nb2 + "" );
                    aDiv = false;
                }
            }
        } );

        clearNum.setOnClickListener( new View.OnClickListener() {
            /**
             *
             * @param v Sets the text of the numbers on screen
             */
            @Override
            public void onClick(View v) {
                calculate.setText( "" );
            }
        } );

        periodNum.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText( calculate.getText() + "." );
            }
        } );

    }
}