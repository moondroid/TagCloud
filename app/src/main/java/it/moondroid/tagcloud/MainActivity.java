package it.moondroid.tagcloud;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.lib.tagcloud.Tag;
import it.moondroid.lib.tagcloud.TagCloudView;


public class MainActivity extends ActionBarActivity {

    private TagCloudView mTagCloudView;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Step0: to get a full-screen View:
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Step1: get screen resolution:
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        //Step2: create the required TagList:
        //notice: All tags must have unique text field
        //if not, only the first occurrence will be added and the rest will be ignored
        List<Tag> myTagList= createTags();

        //Step3: create our TagCloudview and set it as the content of our MainActivity
        mTagCloudView = new TagCloudView(this, width, height, myTagList, 6, 34, 5 ); //passing current context
        setContentView(mTagCloudView);
        mTagCloudView.requestFocus();
        mTagCloudView.setFocusableInTouchMode(true);

        //Step4: (Optional) adding a new tag and resetting the whole 3D TagCloud
        //you can also add individual tags later:
        //mTagCloudView.addTag(new Tag("AAA", 5, "http://www.aaa.com"));
        // .... (several other tasg can be added similarly )
        //indivual tags will be placed along with the previous tags without moving
        //old ones around. Thus, after adding many individual tags, the TagCloud
        //might not be evenly distributed anymore. reset() re-positions all the tags:
        //mTagCloudView.reset();

        //Step5: (Optional) Replacing one of the previous tags with a new tag
        //you have to create a newTag and pass it in together
        //with the Text of the existing Tag that you want to replace
        //Tag newTag=new Tag("Illinois", 9, "http://www.illinois.com");
        //in order to replace previous tag with text "Google" with this new one:
        //boolean result=mTagCloudView.Replace(newTag, "google");
        //result will be true if "google" was found and replaced. else result is false
    }

    private List<Tag> createTags(){
        //create the list of tags with popularity values and related url
        List<Tag> tempList = new ArrayList<Tag>();

        tempList.add(new Tag("Google", 7, "http://www.google.com"));  //1,4,7,... assumed values for popularity
        tempList.add(new Tag("Yahoo", 3, "www.yahoo.com"));
        tempList.add(new Tag("CNN", 4, "www.cnn.com"));
        tempList.add(new Tag("MSNBC", 5, "www.msnbc.com"));
        tempList.add(new Tag("CNBC", 5, "www.CNBC.com"));
        tempList.add(new Tag("Facebook", 7, "www.facebook.com"));
        tempList.add(new Tag("Youtube", 3, "www.youtube.com"));
        tempList.add(new Tag("BlogSpot", 5, "www.blogspot.com"));
        tempList.add(new Tag("Bing", 3, "www.bing.com"));
        tempList.add(new Tag("Wikipedia", 8, "www.wikipedia.com"));
        tempList.add(new Tag("Twitter", 5, "www.twitter.com"));
        tempList.add(new Tag("Msn", 1, "www.msn.com"));
        tempList.add(new Tag("Amazon", 3, "www.amazon.com"));
        tempList.add(new Tag("Ebay", 7, "www.ebay.com"));
        tempList.add(new Tag("LinkedIn", 5, "www.linkedin.com"));
        tempList.add(new Tag("Live", 7, "www.live.com"));
        tempList.add(new Tag("Microsoft", 3, "www.microsoft.com"));
        tempList.add(new Tag("Flicker", 1, "www.flicker.com"));
        tempList.add(new Tag("Apple", 5, "www.apple.com"));
        tempList.add(new Tag("Paypal", 5, "www.paypal.com"));
        tempList.add(new Tag("Craigslist", 7, "www.craigslist.com"));
        tempList.add(new Tag("Imdb", 2, "www.imdb.com"));
        tempList.add(new Tag("Ask", 4, "www.ask.com"));
        tempList.add(new Tag("Weibo", 1, "www.weibo.com"));
        tempList.add(new Tag("Tagin!", 8, "http://scyp.idrc.ocad.ca/projects/tagin"));
        tempList.add(new Tag("Shiftehfar", 8, "www.shiftehfar.org"));
        tempList.add(new Tag("Soso", 5, "www.google.com"));
        tempList.add(new Tag("XVideos", 3, "www.xvideos.com"));
        tempList.add(new Tag("BBC", 5, "www.bbc.co.uk"));
        return tempList;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
