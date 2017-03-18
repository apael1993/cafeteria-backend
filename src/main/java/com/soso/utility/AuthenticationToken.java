package com.soso.utility;



import com.soso.services.BaseSecurity;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Garik.Kalashyan on 1/28/2017.
 */
public class AuthenticationToken {

    private String key;
    private Integer serviceId;

    public AuthenticationToken(@NotNull Integer serviceId, String key) {
        this.serviceId = serviceId;
        this.key = key;
    }

    public AuthenticationToken(){}

    public String getKey(){
        return this.key;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthenticationToken)) return false;

        AuthenticationToken that = (AuthenticationToken) o;

        if (!key.equals(that.key)) return false;
        return getServiceId().equals(that.getServiceId());
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + getServiceId().hashCode();
        return result;
    }
}
