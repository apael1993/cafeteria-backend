package com.soso.controller;

import com.soso.services.AuthenticationTokenService;
import com.soso.services.JsonConverter;
import com.soso.services.JsonMapBuilder;
import com.soso.utility.AuthenticationToken;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Garik Kalashyan on 3/9/2017.
 */

@CrossOrigin("*")
@Controller
@RequestMapping("authenticateService")
public class AuthenticationRequestsController {

    @RequestMapping(value = "/isValidToken/{serviceId}/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void isValidToken(Integer serviceId,String token,  HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonConverter.toJson(new JsonMapBuilder()
                 .add("isValidToken", AuthenticationTokenService.existsToken(new AuthenticationToken(serviceId,token)))
                 .build()));
    }

    @RequestMapping(value = "/createToken/{serviceId}/{token}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(Integer serviceId,String token,  HttpServletResponse response) throws IOException {
        response.getWriter().write(JsonConverter.toJson(new JsonMapBuilder()
                .add("createdToken", AuthenticationTokenService.getGeneratedAuthenticationToken(serviceId,token))
                .build()));
    }

    @RequestMapping(value = "/deleteToken/{serviceId}/{token}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void remove(@PathVariable("serviceId") Integer serviceId,@PathVariable("token") String token,HttpServletResponse response){
        AuthenticationToken authenticationToken = new AuthenticationToken(serviceId,token);
        if(AuthenticationTokenService.removeToken(authenticationToken)){
            response.setStatus(200);
        } else{
            response.setStatus(400);
        }

    }




}
