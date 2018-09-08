package joaogouveia89.github.io.testedeperformance.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import joaogouveia89.github.io.testedeperformance.R;
import joaogouveia89.github.io.testedeperformance.controller.IntroduceController;
import joaogouveia89.github.io.testedeperformance.ui.fragments.CantDoTestFragment;
import joaogouveia89.github.io.testedeperformance.ui.fragments.StartTestFragment;

public class IntroduceActivity extends AppCompatActivity implements IntroduceInstance{

    private ProgressDialog dialog;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        setDialog();

        IntroduceController controller = new IntroduceController(this, this);

        controller.hasBeenChecked();
    }

    private void setDialog() {
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Aguarde");
    }

    @Override
    public void callProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void loadFragment(boolean hasBeenChecked) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(hasBeenChecked){
            fragment = new StartTestFragment();
            transaction.replace(R.id.fragment_view, fragment).commit();
        }else{
            fragment = new CantDoTestFragment();
            transaction.replace(R.id.fragment_view, fragment).commit();
        }
    }
}
