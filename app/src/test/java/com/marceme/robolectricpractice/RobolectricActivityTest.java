package com.marceme.robolectricpractice;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.TestCase;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/3/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricActivityTest{

    private RobolectricActivity mRobolectricActivity;

    @Before
    public void setUp() throws Exception {
        mRobolectricActivity =  Robolectric.setupActivity(RobolectricActivity.class);
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception{

        TextView welcomeText = (TextView) mRobolectricActivity.findViewById(R.id.text_welcome);
        assertNotNull(welcomeText);
        MatcherAssert.assertThat(welcomeText.getVisibility(), equalTo( View.VISIBLE ) );
        assertThat(welcomeText.getText().toString(),
                equalTo(RuntimeEnvironment.application.getString(R.string.title_welcome)));
    }

    @Test
    public void shouldHaveUserNameEditText() throws Exception{
        TextView userNameEdit = (EditText) mRobolectricActivity.findViewById(R.id.edit_user_name);
        assertNotNull(userNameEdit);
        MatcherAssert.assertThat(userNameEdit.getVisibility(), equalTo( View.VISIBLE ) );
        assertThat(userNameEdit.getHint().toString(),
                equalTo(RuntimeEnvironment.application.getString(R.string.edit_username_hint)));
    }

    @Test
    public void shouldHaveEmailEditText() throws Exception{
        TextView emailEdit = (EditText) mRobolectricActivity.findViewById(R.id.edit_email);
        assertNotNull(emailEdit);
        MatcherAssert.assertThat(emailEdit.getVisibility(), equalTo( View.VISIBLE ) );
        assertThat(emailEdit.getHint().toString(),
                equalTo(RuntimeEnvironment.application.getString(R.string.edit_email_hint)));
    }

    @Test
    public void shouldHaveASendButton() throws Exception{
        TextView sendButton = (Button) mRobolectricActivity.findViewById(R.id.button_send);
        assertNotNull(sendButton);
        MatcherAssert.assertThat(sendButton.getVisibility(), equalTo( View.VISIBLE ) );
        assertThat(sendButton.getText().toString(),
                equalTo(RuntimeEnvironment.application.getString(R.string.action_send)));
    }

}