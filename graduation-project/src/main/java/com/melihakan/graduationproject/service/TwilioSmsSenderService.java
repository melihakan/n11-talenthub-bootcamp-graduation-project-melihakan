package com.melihakan.graduationproject.service;

import com.melihakan.graduationproject.config.TwilioConfig;
import com.melihakan.graduationproject.entity.User;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwilioSmsSenderService implements SmsSenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSenderService.class);
    private final TwilioConfig twilioConfig;


    @Override
    public void sendSms(User user) {

        if(isPhoneNumberValid(user.getPhoneNumber())){

            PhoneNumber to = new PhoneNumber(user.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String message = "User saved";
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            //LOGGER.info("send sms {}"+ smsRequest);
        }else {
            throw new IllegalArgumentException("Phone Number ["+user.getPhoneNumber()+"] is not a valid number");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
