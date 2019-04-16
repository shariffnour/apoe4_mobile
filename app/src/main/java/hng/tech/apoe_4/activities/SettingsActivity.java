package hng.tech.apoe_4.activities;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import hng.tech.apoe_4.R;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.toHide)
    LinearLayout toHide;

    @BindView(R.id.hiddenUnits)
    LinearLayout hiddenUnits;

    @BindView(R.id.hiddenFeedback)
    LinearLayout hiddenFeedback;

    @BindView(R.id.hiddenAbout)
    LinearLayout hiddenAbout;

    @BindView(R.id.drop)
    ImageView drop;

    @BindView(R.id.dropUnit)
    ImageView dropUnit;

    @BindView(R.id.dropFeedback)
    ImageView dropFeedback;

    @BindView(R.id.dropAbout)
    ImageView dropAbout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ButterKnife.bind(this);

        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);


        drop.setOnClickListener(v -> animateView(toHide, drop));
        dropUnit.setOnClickListener(v -> animateView(hiddenUnits, dropUnit));
        dropFeedback.setOnClickListener(v -> animateView(hiddenFeedback, dropFeedback));
        dropAbout.setOnClickListener(v -> animateView(hiddenAbout, dropAbout));

    }
    
    private void animateView(View view, ImageView button){
        if (view.getVisibility() == View.GONE){

            view.setVisibility(View.VISIBLE);
            view.setAlpha(0.0f);

// Start the animation
            view.animate()
                    .translationY(10)
                    .alpha(1.0f)
                    .setListener(null);
        }
        else {
            view.animate()
                    .translationY(0)
                    .alpha(0.0f)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.setVisibility(View.GONE);
                        }
                    });
        }
    }
}
