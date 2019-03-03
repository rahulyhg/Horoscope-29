package com.example.horoscope.details_screen.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.horoscope.details_screen.presenter.DetailsActivityPresenter;
import com.example.horoscope.details_screen.view.contract.IDetailsActivityContract;
import com.example.horoscope.utils.Const;
import com.example.horoscope.utils.DetailsMarginSpan;
import com.example.zodiac.R;

public class DetailsActivity extends AppCompatActivity implements IDetailsActivityContract.View {

    private static final String SUN_SIGN = "sun_sign";

    private int mSunSignId;
    private DetailsActivityPresenter mPresenter;
    private Toolbar mToolbar;
    private ImageView mTodaySunSignImage, mTomorrowSunSignImage, mYesterdaySunSignImage;
    private TextView mTodayTitle, mTomorrowTitle, mYesterdayTitle;
    private TextView mTodayHoroscope, mTomorrowHoroscope, mYesterdayHoroscope;

    public static void start(@NonNull Context context, int id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(SUN_SIGN, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();
        initTabHost();
        setSupportActionBar(mToolbar);
        mPresenter.attachView(this);
        mPresenter.loadHoroscope(Const.ZODIAC_SUN_SIGNS[mSunSignId].toLowerCase(), "today_tab");

    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.viewIsReady();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void updateTodayUi(String text) {
        setDetails(text, mTodaySunSignImage, mTodayHoroscope);
       // mTodayHoroscope.setText(text);
        mTodayTitle.setText(Const.ZODIAC_SUN_SIGNS[mSunSignId]);
        //setImage(mSunSignId, mTodaySunSignImage);
    }

    @Override
    public void updateTomorrowUi(String text) {
        setDetails(text, mTomorrowSunSignImage, mTomorrowHoroscope);
        //mTomorrowHoroscope.setText(text);
        mTomorrowTitle.setText(Const.ZODIAC_SUN_SIGNS[mSunSignId]);
        //setImage(mSunSignId, mTomorrowSunSignImage);
    }

    @Override
    public void updateYesterdayUi(String text) {
        setDetails(text, mYesterdaySunSignImage, mYesterdayHoroscope);
        //mYesterdayHoroscope.setText(text);
        mYesterdayTitle.setText(Const.ZODIAC_SUN_SIGNS[mSunSignId]);
        //setImage(mSunSignId, mYesterdaySunSignImage);
    }

    private void init(){
        mPresenter = new DetailsActivityPresenter();
        mSunSignId = getIntent().getIntExtra(SUN_SIGN, -1);
        mToolbar = findViewById(R.id.toolbar);

        mTodayHoroscope = findViewById(R.id.today_horoscope_text_view);
        mTomorrowHoroscope = findViewById(R.id.tomorrow_horoscope_text_view);
        mYesterdayHoroscope = findViewById(R.id.yesterday_horoscope_text_view);

        mTodayTitle = findViewById(R.id.today_title_text_view);
        mTomorrowTitle = findViewById(R.id.tomorrow_title_text_view);
        mYesterdayTitle = findViewById(R.id.yesterday_title_text_view);

        mTodaySunSignImage = findViewById(R.id.today_sun_sign_image);
        mTomorrowSunSignImage = findViewById(R.id.tomorrow_sun_sign_image);
        mYesterdaySunSignImage = findViewById(R.id.yesterday_sun_sign_image);
    }

    private void initTabHost(){

        TabHost mTabHost = findViewById(android.R.id.tabhost);
        mTabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = mTabHost.newTabSpec("today_tab");
        tabSpec.setIndicator("Today");
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.today_tab);
        mTabHost.addTab(tabSpec);

        tabSpec = mTabHost.newTabSpec("tomorrow_tab");
        tabSpec.setIndicator("Tomorrow");
        tabSpec.setContent(R.id.tomorrow_tab);
        mTabHost.addTab(tabSpec);

        tabSpec = mTabHost.newTabSpec("yesterday_tab");
        tabSpec.setIndicator("Yesterday");
        tabSpec.setContent(R.id.yesterday_tab);
        mTabHost.addTab(tabSpec);

        // вторая вкладка будет выбрана по умолчанию
        mTabHost.setCurrentTabByTag("tag2");

        // обработчик переключения вкладок
        mTabHost.setOnTabChangedListener(tabId -> mPresenter.loadHoroscope(Const.ZODIAC_SUN_SIGNS[mSunSignId].toLowerCase(), tabId));

    }

    private void setDetails(String text, ImageView imageView, TextView textView){

        Drawable icon = getResources().getDrawable(Const.ZODIAC_ICON[mSunSignId]);
        int leftMargin = icon.getIntrinsicWidth() + 10;

        setImage(mSunSignId, imageView);
        imageView.setBackground(icon);

        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new DetailsMarginSpan(8, leftMargin), 0, spannableString.length(), 0);

        textView.setText(spannableString);
    }

    private void setImage(int id, ImageView targetImageView) {
        Glide
                .with(targetImageView.getContext())
                .load(Const.ZODIAC_ICON[id])
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_leo))
                .into(targetImageView);
    }
}
