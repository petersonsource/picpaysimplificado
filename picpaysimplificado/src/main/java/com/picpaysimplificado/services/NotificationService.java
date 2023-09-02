package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String mensagem) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, mensagem);

/*        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);
        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            System.out.println("erro ao enviar notificacao");
            throw new Exception("servico de notificacao esta fora do ar.");
        }*/

        System.out.println("notificacao enviada para o usuario");
    }




}
