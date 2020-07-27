package com.google.ar.sceneform.emrhmrc.huhuvideorecording;

import android.media.MediaRecorder;

import java.io.IOException;

/**
 * Created by hamurcuabi on 27,July,2020
 **/
public class AudioRecorder {

    private String pathName;
    private MediaRecorder recorder;


    public AudioRecorder(String pathName) {
        this.pathName = pathName;
        setupMediaRecorder();
    }


    private void setupMediaRecorder() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(pathName);
        try {
            recorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startRecording() {
        recorder.start();   // Recording will start
    }

    public String getPathName() {
        return pathName;
    }

    public void stopRecording() {
        recorder.stop();
        recorder.reset();   // You can reuse the object by going back to setAudioSource() step
        recorder.release(); // Now the object cannot be reused
    }
}
