package joaogouveia89.github.io.testedeperformance.api;

import joaogouveia89.github.io.testedeperformance.api.responses.ResultResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static joaogouveia89.github.io.testedeperformance.app.Constants.Service.CHECK_IMEI;

public interface ResultsService {
    @GET(CHECK_IMEI)
    Call<ResultResponse> checkImei(@Path("imei") String imei);
}
