package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    private Button mPlusButton;
    private Button mMinusButton;
    private TextView mCounterTextView;
    private Integer counter;                                    // "int" won't let me toString

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // Set counter to 0
        counter = 0;

        // Get references
        mPlusButton = (Button) findViewById(R.id.plus_button);
        mMinusButton = (Button) findViewById(R.id.minus_button);
        mCounterTextView = (TextView) findViewById(R.id.counter_text_view);

        // Set up onClickListeners
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Add 1 to counter
                alterCounter(1);
            }
        });

        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Minus 1 from counter
                alterCounter(-1);
            }
        });

    }

    public void alterCounter(int amount) {

        // alter counter by amount
        counter = counter + amount;

        // Get a string version of counter
        String counterString = counter.toString();

        // update text view
        mCounterTextView.setText(counterString);        // apparently setText will not accept counter by itself

        // is counter more than 20? Note that this will happen every single time the counter is altered and it is above 20
        if (counter > 20) {

            // Create and show appropriate toast
            Toast.makeText(CounterActivity.this, R.string.over_20_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
