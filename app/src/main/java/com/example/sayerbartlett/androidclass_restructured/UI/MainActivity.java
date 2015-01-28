package com.example.sayerbartlett.androidclass_restructured.UI;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sayerbartlett.androidclass_restructured.R;

import java.util.Random;


public class MainActivity extends ActionBarActivity
{
  private Button mButtonSubmit;
  private Button mButtonInfo;
  private Button mButtonClicker;
  private EditText mEditText;
  private TextView mTextView;
  private TextView mTextViewPunchIt;
  private int mTotalClicks;
  public final static String EXTRA_MESSAGE = "com.mycompany.android class.MESSAGE";
  static final String NUM_CLICKS = "numberOfClicks";
  static final String BOOL_FIRST = "mOnFirstLvl";
  static final String BOOL_SECOND = "mOnSecondLvl";
  static final String BOOL_THIRD = "mOnThirdLvl";
  static final String BOOL_FOURTH = "mOnFourthLvl";
  static final String BUTTON_TEXT = "clickerButtonText";
  private Boolean mOnFirstLvl = true;
  private Boolean mOnSecondLvl = false;
  private Boolean mOnThirdLvl = false;
  private Boolean mOnFourthLvl = false;
  private String [] mQuotes;


  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mButtonSubmit = (Button) findViewById(R.id.button_submit);
    mButtonInfo = (Button) findViewById(R.id.button_info);
    mButtonClicker = (Button) findViewById(R.id.button_clicker);
    mEditText = (EditText) findViewById(R.id.editText);
    mTextView = (TextView) findViewById(R.id.messageTextView);
    mTextViewPunchIt = (TextView) findViewById(R.id.textView_punchIt);
    mQuotes = getResources().getStringArray(R.array.five_quotes_array);

    mButtonSubmit.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        String message = mEditText.getText().toString();
        showMessage(message);
      }
    });

    mButtonInfo.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        showInfo();
      }
    });

    mButtonClicker.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        updateClicks();
      }
    });

  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main_activity_actions, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    switch(id)
    {
      case R.id.action_search:
        return true;


      case R.id.action_like:
        likeText();
        return true;
    }

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings)
    {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @Override
  public void onSaveInstanceState(Bundle savedInstanceState)
  {
    savedInstanceState.putInt(NUM_CLICKS, mTotalClicks);
    savedInstanceState.putBoolean(BOOL_FIRST, mOnFirstLvl);
    savedInstanceState.putBoolean(BOOL_SECOND, mOnSecondLvl);
    savedInstanceState.putBoolean(BOOL_THIRD, mOnThirdLvl);
    savedInstanceState.putBoolean(BOOL_FOURTH, mOnFourthLvl);
    savedInstanceState.putString(BUTTON_TEXT, mButtonClicker.getText().toString());

    super.onSaveInstanceState(savedInstanceState);
  }

  @Override
  public void onRestoreInstanceState(Bundle savedInstanceState)
  {
    // Always call the superclass so it can restore the view hierarchy
    super.onRestoreInstanceState(savedInstanceState);



    mTotalClicks = savedInstanceState.getInt(NUM_CLICKS);
    mButtonClicker.setText(savedInstanceState.getString(BUTTON_TEXT));

    if(mTotalClicks != 0)
      mTextView.setText(getString(R.string.total_clicks) + " " + mTotalClicks);

    mOnFirstLvl = savedInstanceState.getBoolean(BOOL_FIRST);
    mOnSecondLvl = savedInstanceState.getBoolean(BOOL_SECOND);
    mOnThirdLvl = savedInstanceState.getBoolean(BOOL_THIRD);
    mOnFourthLvl = savedInstanceState.getBoolean(BOOL_FOURTH);

  }

  public void showMessage(String message)
  {
    Intent intent = new Intent(this, MessageActivity.class);
    intent.putExtra(EXTRA_MESSAGE, message);

    startActivity(intent);
  }

  public void showInfo()
  {
    startActivity(new Intent(this, InfoActivity.class));
  }

  public void likeText()
  {
    Random randomGenerator = new Random();
    int randomNumber = randomGenerator.nextInt(mQuotes.length);

    String qoute = (mQuotes[randomNumber]);
    mTextViewPunchIt.setText(qoute);
  }

  public void updateClicks()
  {

    mTotalClicks++;

    if(mTotalClicks == 25 && mOnFirstLvl)
    {
      mOnFirstLvl = false;
      mOnSecondLvl = true;
      mTotalClicks = 0;
      mButtonClicker.setText(getString(R.string.clicks_first_level));
    }

    if(mTotalClicks == 10 && mOnSecondLvl)
    {
      mOnSecondLvl = false;
      mOnThirdLvl = true;
      mTotalClicks = 0;
      mButtonClicker.setText(getString(R.string.clicks_second_level));
    }

    if(mTotalClicks == 7 && mOnThirdLvl)
    {
      mOnThirdLvl = false;
      mOnFourthLvl = true;
      mTotalClicks =0;
      mButtonClicker.setText(getString(R.string.clicks_third_level));
    }

    if(mTotalClicks == 1 && mOnFourthLvl)
    {
      startActivity(new Intent(this, RickAstleyActivity.class));
    }
    else
      mTextView.setText(getString(R.string.total_clicks) + " " + mTotalClicks);

  }

}
