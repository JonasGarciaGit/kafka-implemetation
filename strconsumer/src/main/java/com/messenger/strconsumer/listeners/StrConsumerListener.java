package com.messenger.strconsumer.listeners;

import com.messenger.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: Received Message : {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Received Message : {}", message);
    }

}
