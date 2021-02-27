package com.example.makeupstyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class AboutActivity extends AppCompatActivity {
    ImageView twitter, instagram, facebook, gmail;
    TextView nameOfApp, aboutApp, idea, develop;
//    Locale current = getResources().getConfiguration().locale;
//    String current = Locale.getDefault().getLanguage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

//        Locale current = getResources().getConfiguration().locale;
//        nameOfApp = findViewById(R.id.nameOfApp);
//        aboutApp = findViewById(R.id.aboutApp);
//        idea = findViewById(R.id.idea);
//        develop = findViewById(R.id.develop);

//        if(current.equals("fa")){
//            nameOfApp.setText("برنامه آموزش آرایش");
//            aboutApp.setText("با استفاده از برنامه آموزش آرایش ، شما در مورد کانتورینگ ، آرایش چشم؛ آرایش لب برای مراسم گاه به گاه ، مهمانی ، عروسی یا هر نوع رویداد به صورت مرحله به مرحله. با تصاویر بصری و خارق العاده بسیار آسان ، ساده و کاربردی است. این برنامه آموزش آرایش قدم به قدم روش صحیح استفاده از ریمل ، قرار دادن خط چشم ، ایجاد چشم های دودی ، استفاده از پایه ، شکل دادن به ابروها ، استفاده از سرخ شدن ، بر روی رژ لب را مطابق با صورت و موارد دیگر نشان می دهد.");
//            idea.setText("شما می توانید ایده خود را در مورد این برنامه به اشتراک بگذارید.");
//            develop.setText("تهیه شده توسط سودابه شیرزاد");
//        }else{
//            nameOfApp.setText("Makeup Learning App");
//            aboutApp.setText("With makeup learning application you will learn about contouring, eye makeup; lip makeup for casual, party, wedding or any type of events step by step. It is very easy, simple and practical with visual and fantastic images. This makeup learning app step by step shows you the correct method to apply mascara, put on eyeliner, create smokey eyes, use foundation, shape your eyebrows, apply blush, put on lipstick according to your face and much more.");
//            idea.setText("You can Share your idea about this Application.");
//            develop.setText("Develop by Sodabeh Sherzad");
//        }

        twitter = findViewById(R.id.twitter);
        instagram = findViewById(R.id.instagram);
        facebook = findViewById(R.id.facebook);
        gmail = findViewById(R.id.gmail);

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW);
                intent. setData(Uri. parse("twitter://user?user_id=3028855001"));
                startActivity(intent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW);
                intent. setData(Uri. parse("fb://facewebmodal/f?href=https://www.facebook.com/CodeToInspire"));
                startActivity(intent);
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW);
                intent. setData(Uri. parse("mailto:info@codetoinspire.org?subject=Makeup%20Feedback&body=Write%20feedback%20here..."));
                startActivity(intent);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW);
                intent. setData(Uri. parse("instagram://user?username=codetoinspire"));
                startActivity(intent);

            }
        });
    }

    public void goBack(View view){
        super.onBackPressed();
    }


}
