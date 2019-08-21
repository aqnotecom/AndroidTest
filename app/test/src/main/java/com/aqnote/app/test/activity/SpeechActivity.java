package com.aqnote.app.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.aqnote.app.test.R;

import java.util.Locale;

/**
 * 文本转语音例子
 *
 * @author "Peng Li"<aqnote@aqnote.com>
 **/
public class SpeechActivity extends Activity {

    private static final String TAG = SpeechActivity.class.getSimpleName();

    private TextToSpeech mSpeech;
    private Button       mReadButton;
    private EditText     mEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);

        mReadButton = (Button) findViewById(R.id.readButton);
        mEditText = (EditText) findViewById(R.id.readEditText);

        mReadButton.setEnabled(false);
        mSpeech = new TextToSpeech(this, new _OnInitListener());
        mReadButton.setOnClickListener(new _OnClickListener());

    }

    @Override
    protected void onDestroy() {
        if (mSpeech != null) {
            mSpeech.stop();
            mSpeech.shutdown();
        }
        super.onDestroy();
    }

    class _OnInitListener implements OnInitListener {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                int result = mSpeech.setLanguage(Locale.ENGLISH);
                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("lanageTag", "not use");
                } else {
                    mReadButton.setEnabled(true);
                    mSpeech.speak("TextToSpeech init finish", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        }
    }

    class _OnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            mSpeech.speak(mEditText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
}