package ua.com.leastas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TimersListActivity extends Activity {
    /**
     * Called when the activity is first created.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timers_list);

//        findViewById(R.id.add_row).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(TimersListActivity.this, SetupTimerActivity.class));
//            }
//        });
    }

    public void addRow(View v) {
        Intent setupTimerIntent = new Intent(v.getContext(), SetupTimerActivity.class);
        startActivity(setupTimerIntent);
    }


    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

}
