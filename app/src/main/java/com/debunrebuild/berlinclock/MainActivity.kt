package com.debunrebuild.berlinclock

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.debunrebuild.berlinclock.LampState.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val berlinClockViewModel by viewModels<BerlinClockViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        berlinClockViewModel.clockState.observe(this, Observer {
            findViewById<View>(R.id.bc_seconds).setBackgroundColor(getLampColor(it.seconds))
            setHoursTopRow(it.topHour)
            setBottomHoursTopRow(it.bottomHour)
            setMinutesTopRow(it.topMinutes)
            setMinutesBottomRow(it.bottomMinutes)
            setRegularClockText(it.clockText)
        })
        berlinClockViewModel.setClockEvent(BerlinClockEvent.StartAutomaticClock)
    }

    private fun setRegularClockText(clockText: String) {
        findViewById<TextView>(R.id.regular_clock_text).setText(clockText)
    }

    private fun setHoursTopRow(topHour: Array<LampState>) {
        for (i in topHour.indices) {
            findViewById<LinearLayout>(R.id.bc_hours_top).getChildAt(i)
                .setBackgroundColor(getLampColor(topHour[i]))
        }
    }

    private fun setBottomHoursTopRow(topHour: Array<LampState>) {
        for (i in topHour.indices) {
            findViewById<LinearLayout>(R.id.bc_hours_bottom).getChildAt(i)
                .setBackgroundColor(getLampColor(topHour[i]))
        }
    }

    private fun setMinutesTopRow(topMinute: Array<LampState>) {
        for (i in topMinute.indices) {
            findViewById<LinearLayout>(R.id.bc_minutes_top).getChildAt(i)
                .setBackgroundColor(getLampColor(topMinute[i]))
        }
    }

    private fun setMinutesBottomRow(topMinute: Array<LampState>) {
        for (i in topMinute.indices) {
            findViewById<LinearLayout>(R.id.bc_minutes_bottom).getChildAt(i)
                .setBackgroundColor(getLampColor(topMinute[i]))
        }
    }

    private fun getLampColor(lampState: LampState): Int {
        return when (lampState) {
            ON -> {
                getColor(R.color.yellow_on)
            }

            OFF -> {
                getColor(R.color.grey_off)
            }

            QUARTER_ON -> {
                getColor(R.color.red_on)
            }
        }
    }
}