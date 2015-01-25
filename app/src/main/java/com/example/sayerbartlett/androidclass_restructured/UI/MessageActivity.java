package com.example.sayerbartlett.androidclass_restructured.UI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sayerbartlett.androidclass_restructured.R;
import com.example.sayerbartlett.androidclass_restructured.UI.MainActivity;


public class MessageActivity extends ActionBarActivity

{
  private TextView mTextView;
  private TextView mTextViewPunchIt;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message);

    Intent intent = getIntent();
    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    mTextView = (TextView) findViewById(R.id.messageTextView);
    mTextView.setText(message);

    mTextViewPunchIt = (TextView) findViewById(R.id.textView_Message_punchIt);

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

  public void likeText()
  {
    mTextViewPunchIt.setText("One does not simply MAKE an app...");
  }
}
