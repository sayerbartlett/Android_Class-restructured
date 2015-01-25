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
    mTextViewPunchIt.setText("One does not simply MAKE an app...");
  }

  public void updateClicks()
  {
    mTotalClicks++;

    //if(mTotalClicks == 25)
      //startActivity(new Intent(this, rickAstleyActivity.class));

    //else
      mTextView.setText("Clicks so far: " + mTotalClicks);

  }

}
