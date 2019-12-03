package org.hltic.sms_androidfrontend.api;


import org.hltic.sms_androidfrontend.domaine.dto.RecrutmentDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RecruitmentApiRestService {

    @GET("recrutments/")
    Call<List<RecrutmentDto>> getRecrutments(@Header("Authorization") String authorization);

    @POST("saveRecrutment")
    Call<RecrutmentDto> saveRecrutment(@Header("Authorization") String authorization, @Body RecrutmentDto recrutmentDto);

    @PUT("updateRecrutment/{idRec}")
    Call<RecrutmentDto> updateRecrutment(@Header("Authorization") String authorization, @Path("idRec") Long idRec, @Body RecrutmentDto recrutmentDto);


    //recrutment/api/getOneRecrutmentDto/HL001
    @GET("getOneRecrutmentDto/{recrutmentRef}")
    Call<RecrutmentDto> getOneRecrutmentDto(@Header("Authorization") String authorization, @Path("recrutmentRef") String recrutmentRef);

    @DELETE("deleteRecrutment/{idRec}")
    Call<RecrutmentDto> deleteRecrutment(@Header("Authorization") String authorization, @Path("idRec") Long idReg);


//    @GET("delete/{regRef}")
//    public void deleteRecrutment(@Header("Authorization")String authorization, @Path("idReg")Long idReg);

}
