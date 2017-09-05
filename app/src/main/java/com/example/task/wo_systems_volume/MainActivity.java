package com.example.task.wo_systems_volume;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.seekBar_call)SeekBar call;
    @BindView(R.id.seekBar_systems)SeekBar systems;
    @BindView(R.id.seekBar_ring)SeekBar ring;
    @BindView(R.id.seekBar_music)SeekBar music;
    @BindView(R.id.seekBar_alarm)SeekBar alarm;
    private AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

         am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        通话音量
        int max = am.getStreamMaxVolume( AudioManager.STREAM_VOICE_CALL );
        int current = am.getStreamVolume( AudioManager.STREAM_VOICE_CALL );
        Log.d("VIOCE_CALL", "max : " + max + " current : " + current);
        call.setMax(max);
        call.setProgress(current);
        call.setOnSeekBarChangeListener(this);
//         系统音量
        max = am.getStreamMaxVolume( AudioManager.STREAM_SYSTEM );
        current = am.getStreamVolume( AudioManager.STREAM_SYSTEM );
        Log.d("SYSTEM", "max : " + max + " current : " + current);
        systems.setMax(max);
        systems.setProgress(current);
        systems.setOnSeekBarChangeListener(this);
//         铃声音量
        max = am.getStreamMaxVolume( AudioManager.STREAM_RING );
        current = am.getStreamVolume( AudioManager.STREAM_RING );
        Log.d("RING", "max : " + max + " current : " + current);
        ring.setMax(max);
        ring.setProgress(current);
        ring.setOnSeekBarChangeListener(this);
//         音乐音量
        max = am.getStreamMaxVolume( AudioManager.STREAM_MUSIC );
        current = am.getStreamVolume( AudioManager.STREAM_MUSIC );
        Log.d("MUSIC", "max : " + max + " current : " + current);
        music.setMax(max);
        music.setProgress(current);
        music.setOnSeekBarChangeListener(this);
//         提示声音音量
        max = am.getStreamMaxVolume( AudioManager.STREAM_ALARM );
        current = am.getStreamVolume( AudioManager.STREAM_ALARM );
        Log.d("ALARM", "max : " + max + " current : " + current);
        alarm.setMax(max);
        alarm.setProgress(current);
        alarm.setOnSeekBarChangeListener(this);


    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekBar_call:
                am.setStreamVolume(AudioManager.STREAM_VOICE_CALL,progress,0);
                call.setProgress(progress);
                break;
            case R.id.seekBar_systems:
                am.setStreamVolume(AudioManager.STREAM_SYSTEM,progress,0);
                call.setProgress(progress);
                break;
            case R.id.seekBar_ring:
                am.setStreamVolume(AudioManager.STREAM_RING,progress,0);
                call.setProgress(progress);
                break;
            case R.id.seekBar_music:
                am.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
                call.setProgress(progress);
                break;
            case R.id.seekBar_alarm:
                am.setStreamVolume(AudioManager.STREAM_ALARM,progress,0);
                call.setProgress(progress);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
