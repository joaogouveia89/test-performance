package joaogouveia89.github.io.testedeperformance.controller;

import android.content.Context;

import joaogouveia89.github.io.testedeperformance.api.ResultsService;
import joaogouveia89.github.io.testedeperformance.api.RetrofitGenerator;
import joaogouveia89.github.io.testedeperformance.api.responses.ResultResponse;
import joaogouveia89.github.io.testedeperformance.helpers.HardwareInformation;
import joaogouveia89.github.io.testedeperformance.ui.activities.IntroduceInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IntroduceController {
    private Context context;
    private IntroduceInstance introduceInstance;
    public IntroduceController(Context context, IntroduceInstance introduceInstance) {
        this.context = context;
        this.introduceInstance = introduceInstance;
    }

    public void hasBeenChecked(){
        ResultsService service = RetrofitGenerator.createService(ResultsService.class);
        Call<ResultResponse> response = service.checkImei(HardwareInformation.getImei(this.context));
        introduceInstance.callProgressDialog();
        response.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                if(response.body() != null && response.body().getCode() == 200){
                    introduceInstance.loadFragment(true);
                }else{
                    introduceInstance.loadFragment(false);
                }
                introduceInstance.hideProgressDialog();
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                introduceInstance.hideProgressDialog();
                introduceInstance.loadFragment(false);
            }
        });
    }
}
