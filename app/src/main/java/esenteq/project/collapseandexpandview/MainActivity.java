package esenteq.project.collapseandexpandview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_colExp;
    private TextView textMedCategory, textMedTime;
    private LinearLayout layout_main, layout_colExpHeader, layout_col, layout_exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_colExp = findViewById(R.id.btn_homeRowColExpID);

        textMedCategory = findViewById(R.id.text_homeRowCategoryID);
        textMedTime = findViewById(R.id.text_homeRowTimeID);

        layout_main = findViewById(R.id.layout_homeRowColExpMainID);
        layout_colExpHeader = findViewById(R.id.layout_homeRowColExpHeaderID);
        layout_col = findViewById(R.id.layout_homeRowCollapseID);
        layout_exp = findViewById(R.id.layout_homeRowExpandID);

        btn_colExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout_exp.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(layout_main, new AutoTransition());
                    layout_colExpHeader.setBackgroundResource(R.drawable.rounded_up_rec_white);
                    textMedCategory.setTextColor(getResources().getColor(R.color.colorPrimary));
                    textMedTime.setTextColor(getResources().getColor(R.color.colorPrimary));
                    btn_colExp.setBackgroundResource(R.drawable.ic_expand_less_24dp);
                    layout_exp.setVisibility(View.VISIBLE);
                    layout_col.setVisibility(View.GONE);
                }else {
                    TransitionManager.beginDelayedTransition(layout_main, new AutoTransition());
                    layout_colExpHeader.setBackgroundResource(R.drawable.rounded_up_rectangle);
                    textMedCategory.setTextColor(getResources().getColor(R.color.colorWhite));
                    textMedTime.setTextColor(getResources().getColor(R.color.colorWhite));
                    btn_colExp.setBackgroundResource(R.drawable.ic_expand_more_white_24dp);
                    layout_exp.setVisibility(View.GONE);
                    layout_col.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
