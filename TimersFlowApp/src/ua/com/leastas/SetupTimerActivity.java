package ua.com.leastas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import ua.com.leastas.objects.IntervalTimer;

/**
 * Created with IntelliJ IDEA.
 * User: stanislavchumarin
 * Date: 09.06.12
 * Time: 02:30
 * This activity manages creation and modification of IntervalTimer
 */
public class SetupTimerActivity extends Activity {

    int[] selected_hms = {0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_timer_layout);

        setupSpinners();
    }

    private void setupSpinners() {
        setupSpinner(R.id.hours_spin, 0);
        setupSpinner(R.id.minutes_spin, 1);
        setupSpinner(R.id.seconds_spin, 2);
    }

    private void setupSpinner(int id, final int initial) {
        Spinner sp = (Spinner) findViewById(id);
        sp.setSelection(selected_hms[initial]);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected_hms[initial] = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    public void setupTimer(View v) {
        IntervalTimer t = new IntervalTimer();
        t.hours = selected_hms[0];
        t.minutes = selected_hms[1];
        t.seconds = selected_hms[2];
        t.name = ((TextView) findViewById(R.id.timer_name)).getText().toString();
        //this should be not next, but previous intent. Or implement custom behaviour on back button
        Intent intent = new Intent(this, TimersListActivity.class);
        intent.putExtra(IntervalTimer.PARCELABLE, t);
        startActivity(intent);
    }
}
