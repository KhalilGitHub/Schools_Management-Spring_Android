package org.hltic.sms_androidfrontend.api;



import org.hltic.sms_androidfrontend.domaine.dto.LoginDto;
import org.hltic.sms_androidfrontend.domaine.dto.RegistrationDto;
import org.hltic.sms_androidfrontend.domaine.dto.TokenDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RegistrationApiRestService {

    @GET("registrations/")
    Call<List<RegistrationDto>> getRegistrations(@Header("Authorization") String authorization);

    // @GET("getOneRegistrationDto/{registerRef}")
    //Call<RegistrationDto> getOneRegistrationDto(@Header("Authorization")String authorization, @Path("registerRef")String registerRef);

    @POST("saveRegistration")
    Call<RegistrationDto> saveRegistrations(@Header("Authorization") String authorization, @Body RegistrationDto registrationDto);

    @PUT("update/{idReg}")
    Call<RegistrationDto> updateRegistrations(@Header("Authorization") String authorization, @Path("idReg") Long idReg, @Body RegistrationDto registrationDto);

    /*@GET("delete/{regRef}")
    public void deleteRegistrations(@Header("Authorization")String authorization, @Path("idReg")Long idReg);
*/
    @DELETE("delete/{idReg}")
    Call<RegistrationDto> deleteRegistration(@Header("Authorization") String authorization, @Path("idReg") Long idReg);



    @GET("getOneRegistrationDto/{registerRef}")
    Call<RegistrationDto> findRegistrationByRef(@Header("Authorization") String authorization, @Path("registerRef") String registerRef);


    //@GET("registrations/")
    //Optional<RegistrationDto> findByidReg(@Header("Authorization")String authorization, Long id);

    /*
    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("signin")
    Call<TokenDto> login(@Field("username") String username, @Field("password") String password);
    */
    @POST("signin")
    Call<TokenDto> login(@Body LoginDto loginDto);


}
