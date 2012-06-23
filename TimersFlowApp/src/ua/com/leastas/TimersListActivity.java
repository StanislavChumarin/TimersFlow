package ua.com.leastas;

import android.content.Intent;
import android.os.Bundle;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import ua.com.leastas.objects.IntervalTimer;

import java.util.Iterator;
import java.util.LinkedList;

public class TimersListActivity extends SherlockListActivity {

    LinkedList<IntervalTimer> timersList = new LinkedList<IntervalTimer>();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timers_list);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeButtonEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            addOrUpdateTimer((IntervalTimer) bundle.getParcelable(IntervalTimer.PARCELABLE));
        }
    }


    private void addOrUpdateTimer(IntervalTimer intervalTimer) {
        Iterator<IntervalTimer> iterator = timersList.iterator();
        boolean listUpdated = false;
        while (iterator.hasNext()) {
            IntervalTimer it = iterator.next();
            if (it.equals(intervalTimer)) {
                it.updateWithData(intervalTimer);
                listUpdated = true;
            }
        }
        if (listUpdated) timersList.add(intervalTimer);
    }

    public void addRow() {
        Intent setupTimerIntent = new Intent(getApplicationContext(), SetupTimerActivity.class);
        startActivity(setupTimerIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addRow:
                addRow();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getSupportMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
