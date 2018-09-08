package joaogouveia89.github.io.testedeperformance.ui.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import joaogouveia89.github.io.testedeperformance.R;
import joaogouveia89.github.io.testedeperformance.helpers.HardwareInformation;
import joaogouveia89.github.io.testedeperformance.model.Result;
import joaogouveia89.github.io.testedeperformance.model.enums.Algorithm;
import joaogouveia89.github.io.testedeperformance.threads.BubbleSortThread;
import joaogouveia89.github.io.testedeperformance.threads.QuickSortThread;
import joaogouveia89.github.io.testedeperformance.threads.ThreadHasFinished;

import static joaogouveia89.github.io.testedeperformance.app.Constants.Threads.MAX_ELEMENTS;

public class MeasureActivity extends AppCompatActivity implements ThreadHasFinished{
    private List<Result> results;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        results = new ArrayList<>();
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("Teste em execução...");

        BubbleSortThread bubbleSortThread = new BubbleSortThread(MAX_ELEMENTS, this);
        bubbleSortThread.pupulateList();
        bubbleSortThread.start();
        dialog.show();
    }


    @Override
    public void onThreadFinished(int algorithm, long time) {
        results.add(
                new Result(
                        HardwareInformation.getNumberOfCores(),
                        HardwareInformation.getMaxCpuFrequency(),
                        HardwareInformation.getMemoryCapacity(),
                        HardwareInformation.getBrand(),
                        algorithm,
                        MAX_ELEMENTS,
                        time,
                        12,
                        HardwareInformation.getImei(MeasureActivity.this)
                )
        );
        if(algorithm == Algorithm.BUBBLE_SORT.getId()){
            QuickSortThread quickSortThread = new QuickSortThread(MAX_ELEMENTS, this);
            quickSortThread.pupulateList();
            quickSortThread.start();
        }else{
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.hide();
                    Intent thankyou = new Intent(MeasureActivity.this, ThankYouActivity.class);
                    startActivity(thankyou);
                }
            });
        }
    }
}
